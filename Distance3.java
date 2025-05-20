
/**
 * 
 */
public class Distance3 extends Race 
{
    public Distance3(String category, int distance, int quantity, String nationality) 
    {
        super(category, distance, quantity, nationality);
    }

    public double calcPrice() 
    {
        double fee = 0.0;

        if (category.equalsIgnoreCase("Adults"))
        {
            if (nationality.equalsIgnoreCase("Malaysian")) 
            {
                fee = 25.0;
            } else 
            {
                fee = 30.0;
            }
        } else if (category.equalsIgnoreCase("Kids"))
        {
            if (nationality.equalsIgnoreCase("Malaysian")) 
            {
                fee = 10.0;
            } else
            {
                fee = 15.0;
            }
        }
        return fee * quantity;
    }
}


    