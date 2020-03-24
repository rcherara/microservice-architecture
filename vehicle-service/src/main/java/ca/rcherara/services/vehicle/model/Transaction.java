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


    public Transaction(int transactionID2, GregorianCalendar date2, Vehicle car2, String salesPerson2, TransactionType type2, double price2)
    {
        transactionID = transactionID2;
        date = date2;
        car = car2;
        salesPerson = salesPerson2;
        type = type2;
        price = price2;
        
       
        infoMap = new TreeMap<String, Object>();
        infoMap.put("ID", transactionID);
        infoMap.put("Date", date);
        infoMap.put("Car", car);
        infoMap.put("SP", salesPerson);
        infoMap.put("Type", type);
        infoMap.put("Price", price);
        
    }

    /**
     * Displays transaction information
     * @return a string of the information
     */
    public String display()
    {
        String formatdate = date.toZonedDateTime().format(DateTimeFormatter.ofPattern("d MMM uuuu"));
        return
        "------------------------------\n"
        + "[Transaction]\t[ID: " + transactionID + "]\n"
        + "\nDate:\t\t" + formatdate
        + "\nType:\t\t" + type
        + "\nSalesPerson:\t" + salesPerson
        + "\nVIN:\t\t" + car.vin
        + "\nModel:\t\t" + car.model
        + "\nPrice:\t\t$" + car.price
        ;

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
