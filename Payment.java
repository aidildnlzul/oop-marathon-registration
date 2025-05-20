
/**
 *
 */
import java.io.*;
import java.text.DecimalFormat;

public class Payment 
{
    private String paymentType;
    private Customer customer;
    private Service srv;
    private Race rc;

    public Payment(String paymentType, Customer customer, Service srv, Race rc)
    {
        this.paymentType = paymentType;
        this.customer = customer;
        this.srv = srv;
        this.rc = rc;
    }

    public double calcTotalPrice() 
    {
        double total = 0.0;
        double discount = 0.0;

        total = rc.calcPrice() + srv.calcPrice();

        if (paymentType.equalsIgnoreCase("TNG"))
        {
            discount = total * 0.05;
        } else if (paymentType.equalsIgnoreCase("ONLINE BANKING"))
        {
            discount = total * 0.03;
        }

        total = total - discount;
        return total;
    }

    public String toString() 
    {
        return  "\n--------------------------------------------------------------------------------------------------------------" +
                "\n\t\tCustomer's Receipt" +
                "\n--------------------------------------------------------------------------------------------------------------" +
                "\n\nCustomer's Name: " + customer.getCustName() +
                "\nPhone Number: " + customer.getCustPhoneNumber() +
                "\nEmail: " + customer.getCustEmail() +
                "\n" + rc.toString() +
                "\n" + srv.toString() +
                "\nPayment type: " + paymentType +
                "\nTotal price: RM" + String.format("%.2f", calcTotalPrice());
    }
}

