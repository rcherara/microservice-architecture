package ca.rcherara.services.vehicle.model;

import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class Transaction
{

    static int transactionID;
    static GregorianCalendar date;
    static Vehicle car;
    static String salesPerson;
    static double price;
    public Map<String, Object> infoMap;

    public enum TransactionType
	{
		BUY, RETURN;
    }
    
    public static TransactionType type;


    public Transaction(int transactionID, GregorianCalendar date, Vehicle car, String salesPerson, TransactionType type, double price)
    {
        transactionID = transactionID;
        date = date;
        car = car;
        salesPerson = salesPerson;
        type = type;
        price = price;   
        infoMap = new TreeMap<String, Object>();
        infoMap.put("ID", transactionID);
        infoMap.put("Date", date);
        infoMap.put("Car", car);
        infoMap.put("SP", salesPerson);
        infoMap.put("Type", type);
        infoMap.put("Price", price);
        
    }



    public GregorianCalendar getDate()
    {
    	return (GregorianCalendar) infoMap.get("Date");
    }
    
    public Vehicle getCar() 
    {
    	return (Vehicle) infoMap.get("Car");
    }
    
    public double getPrice()
    {
    	return (double) infoMap.get("Price");
    }
    public Transaction.TransactionType getType()
    {
    	return (TransactionType) infoMap.get("Type");
    }
    public String getSalesPerson()
    {
    	return (String) infoMap.get("SP");
    }

}
