package day23workshoppe.applicacion.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import day23workshoppe.applicacion.model.Order;
import java.util.List;

@Repository
public class OrderRepoImpl implements OrderRepo{
  @Autowired
  JdbcTemplate jdbcTemplate;
  @Override
  public Order getOrder(Integer id) {
    try{
      List<Order> orderList = jdbcTemplate.query(Queries.getOrderSQL, BeanPropertyRowMapper.newInstance(Order.class), id);
      // Create new order object to send to controller for display
    Order ord = new Order();
    ord.setOrderId(id);
    // same order date for each list item ~
    ord.setOrderDate(orderList.get(0).getOrderDate()); 
    ord.setCustomerId(orderList.get(0).getCustomerId());
    // Set cost by calling getCost method (SUM)
    ord.setCost(getCost(id));
    // Northwind data discount is all 0, I added shipping fee to calculate totalCost instead..
    ord.setTotalCost(getCost(id)+orderList.get(0).getShippingFee());
    return ord;
    }catch(IndexOutOfBoundsException e){
      // return null object to controller so that error message can be displayed instead of erroring out at this step
      return null;
    }
    
  }
  @Override
  public Float getCost(Integer id) {
    Float cost = jdbcTemplate.queryForObject(Queries.getCostPrice, Float.class, id);
    return cost;
  }

  
}
