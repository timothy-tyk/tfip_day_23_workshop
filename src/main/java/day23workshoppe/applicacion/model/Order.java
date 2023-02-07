package day23workshoppe.applicacion.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
  private Integer orderId;
  private Date orderDate;
  private Integer customerId;
  private Float quantity;
  private Float unitPrice;
  private Float discount;
  private Float shippingFee;
  private Float cost;
  private Float totalCost;
  
}
