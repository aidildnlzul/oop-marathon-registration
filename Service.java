
/**
 * 
 */
public class Service 
{
    private String refreshmentKit;

    public Service(String refreshmentKit)
    {
        this.refreshmentKit = refreshmentKit;
    }

    public double calcPrice() 
    {
        if (refreshmentKit.equalsIgnoreCase("CA") || refreshmentKit.equalsIgnoreCase("CB"))
        {
            return 4.00;
        } else if (refreshmentKit.equalsIgnoreCase("CC")) 
        {
            return 2.50;
        }
        return 0.0;
    }

    public String toString() 
    {
        return "Refreshment Kit: " + refreshmentKit + "\nPrice: RM" + String.format("%.2f", calcPrice());
    }
}
