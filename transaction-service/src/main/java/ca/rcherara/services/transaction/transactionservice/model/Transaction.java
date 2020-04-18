package ca.rcherara.services.transaction.transactionservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Transaction")
public class Transaction{
  @Id
  @Column(name = "transaction_id", nullable = false)
  private String ransactionId;
  @Column(name = "dealership_id", nullable = false)
  private String dealershipId;
  @Column(name = "vehicle_name", nullable = false)
  private String productName;
public void withId(String string) {
}
public Transaction withComment(String exampleProperty) {
	return null;
}

}