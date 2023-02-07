package day23workshoppe.applicacion.repository;

public class Queries {
  // Get List of Orders under the same id
  public static final String getOrderSQL = "SELECT * FROM order_details INNER JOIN orders ON orders.id = order_details.order_id WHERE orders.id=?";

  // Get total cost for items (without shipping)
  public static final String getCostPrice = "SELECT SUM(order_details.quantity*order_details.unit_price) FROM order_details WHERE order_id=?";
}