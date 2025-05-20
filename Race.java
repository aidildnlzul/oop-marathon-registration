
/**
 *
 */
 public abstract class Race 
 {
    protected String category;
    protected int distance;
    protected int quantity;
    protected String nationality;

    public Race(String category, int distance, int quantity, String nationality)
    {
        this.category = category;
        this.distance = distance;
        this.quantity = quantity;
        this.nationality = nationality;
    }

    public int getDistance() 
    {
        return distance;
    }

    public abstract double calcPrice();

    public String toString() 
    {
        return "\nRace Category: " + category + "\nDistance: " + distance + "km, \nQuantity: " + quantity + "\nNationality: " + nationality;
    }
}
