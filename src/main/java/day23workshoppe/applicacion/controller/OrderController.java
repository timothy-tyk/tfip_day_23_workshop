package day23workshoppe.applicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import day23workshoppe.applicacion.repository.OrderRepoImpl;
import day23workshoppe.applicacion.model.Order;


@Controller
@RequestMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

  @Autowired
  OrderRepoImpl orderImpl;
  
  @GetMapping(path = "/total/{id}")
  public String showOrderDetails(@PathVariable Integer id, Model model){
    Order order = orderImpl.getOrder(id);
    model.addAttribute("order", order);
    return "orderDetails";
  }

}
