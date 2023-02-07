package day23workshoppe.applicacion.repository;
import day23workshoppe.applicacion.model.Order;

public interface OrderRepo {
  Order getOrder(Integer id);
  Float getCost(Integer id);
}
