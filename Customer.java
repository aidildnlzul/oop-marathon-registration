
/**
 *
 */
public class Customer 
{
    private String custName;
    private String custPhoneNumber;
    private String custEmail;

    public Customer(String custName, String custPhoneNumber, String custEmail)
    {
        this.custName = custName;
        this.custPhoneNumber = custPhoneNumber;
        this.custEmail = custEmail;
    }

    public String getCustName()
    {
        return custName;
    }

    public String getCustPhoneNumber() 
    {
        return custPhoneNumber;
    }

    public String getCustEmail() 
    {
        return custEmail;
    }
}
