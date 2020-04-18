package ca.rcherara.services.transaction.transactionservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.rcherara.services.transaction.transactionservice.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository 
   extends CrudRepository<Transaction,String>
{
    public List<Transaction> findByOrganizationId(String organizationId);
    public Transaction findByVehicleIdAndTransactionId(String transactionId,String vehicleId);
	public List<Transaction> findByTransactionId(String transactionId);
}