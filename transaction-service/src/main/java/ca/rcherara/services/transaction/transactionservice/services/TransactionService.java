package ca.rcherara.services.transaction.transactionservice.services;

import ca.rcherara.services.transaction.transactionservice.config.ServiceConfig;
import ca.rcherara.services.transaction.transactionservice.model.Transaction;
import ca.rcherara.services.transaction.transactionservice.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    ServiceConfig config;

    public Transaction getTransaction(String transactionId,String vehicleId) {
        Transaction transaction = transactionRepository.findByVehicleIdAndTransactionId(transactionId, vehicleId) ;

        return transaction.withComment(config.getExampleProperty());
    }

    public List<Transaction> getTransactionByDealerList(String transactionId){
        return transactionRepository.findByTransactionId( transactionId );
    }

    public void saveLicense(Transaction transaction){
        transaction.withId( UUID.randomUUID().toString());
        transactionRepository.save(transaction);
    }
    
}