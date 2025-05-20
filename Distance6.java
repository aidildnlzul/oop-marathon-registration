
/**
 * 
 */
public class Distance6 extends Race 
{
    public Distance6(String category, int distance, int quantity, String nationality)
    {
        super(category, distance, quantity, nationality);
    }

    public double calcPrice() {
        double fee = 0.0;
        if (category.equalsIgnoreCase("Adults")) {
            if (nationality.equalsIgnoreCase("Malaysian")) {
                fee = 35.0;
            } else {
                fee = 40.0;
            }
        } else if (category.equalsIgnoreCase("Kids")) {
            if (nationality.equalsIgnoreCase("Malaysian")) {
                fee = 25.0;
            } else {
                fee = 35.0;
            }
        }
        return fee * quantity;
    }
}


