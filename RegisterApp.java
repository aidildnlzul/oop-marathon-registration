import java.io.*;
import java.util.StringTokenizer;
import java.util.InputMismatchException;

public class RegisterApp {
    public static void main(String[] args) throws Exception {
        try {
            // input file
            FileReader fr = new FileReader("Customer.txt");
            BufferedReader br = new BufferedReader(fr);
            // output file
            FileWriter fw = new FileWriter("Receipt.txt");
            PrintWriter Pw = new PrintWriter(fw);

            String custName, custPhoneNumber, custEmail, nationality, refreshmentKit, category;
            int distance, quantity;
            String paymentType;
            double average = 0.0, total = 0.0;

            Payment[] pmt = new Payment[5000];
            Race[] rc = new Race[5000];
            Customer[] customer = new Customer[5000];
            Service[] srv = new Service[5000];

            String input;
            int i = 0;
            int count = 0;
            while ((input = br.readLine()) != null && i < 5) 
            {
                StringTokenizer st = new StringTokenizer(input, "#");

                custName = st.nextToken();
                custPhoneNumber = st.nextToken();
                custEmail = st.nextToken();

                customer[i] = new Customer(custName, custPhoneNumber, custEmail);

                refreshmentKit = st.nextToken();
                if ( refreshmentKit.equalsIgnoreCase("CA") || refreshmentKit.equalsIgnoreCase("CB") || refreshmentKit.equalsIgnoreCase("CC") )
                {
                   srv[i] = new Service(refreshmentKit);
                }
                else
                {
                   System.out.println("Wrong Refreshment Kit Input"); 
                }

                nationality = st.nextToken();
                distance = Integer.parseInt(st.nextToken());
                quantity = Integer.parseInt(st.nextToken());
                category = st.nextToken();

                paymentType = st.nextToken();

                if (distance == 3) 
                {
                    if ((category.equalsIgnoreCase("Adults")) || (category.equalsIgnoreCase("Kids")))
                    {
                        rc[i] = new Distance3(category, distance, quantity, nationality);
                    }
                } else if (distance == 6)
                {
                    if ((category.equalsIgnoreCase("Adults")) || (category.equalsIgnoreCase("Kids")))
                    {
                        rc[i] = new Distance6(category, distance, quantity, nationality);
                    }
                }
                else 
                {
                    System.out.println("Wrong Distance Input");
                }

                if ( paymentType.equalsIgnoreCase("ONLINE BANKING") || paymentType.equalsIgnoreCase("TNG") )
                {
                    pmt[i] = new Payment(paymentType, customer[i], srv[i], rc[i]);
                }
                else
                {
                    System.out.println("Wrong Payment Type Input");
                }
                
                count++;
                i++;
            }

            Pw.println("\n--------------------------------------------------------------------------------------------------------------");
            Pw.println("                                   WELCOME TO MARATHON REGISTRATION TICKET SYSTEM                                                        ");
            Pw.println("--------------------------------------------------------------------------------------------------------------");

            Pw.println("  ");

            // Marathon Registration Table
            Pw.println("                          RACE DETAILS                              ");
            Pw.println("|=====================================================================|");
            Pw.println("|     DISTANCE    |   NATIONALITY     |   CATEGORY    |       FEE     |");
            Pw.println("|=====================================================================|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |    ADULT      |     25.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |     MALAYSIAN     |===============|===============|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |     KIDS      |     10.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|       3KM       |===================================================|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |    ADULT      |     30.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |   NON-MALAYSIAN   |===============|===============|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |     KIDS      |     15.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|=====================================================================|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |    ADULT      |     35.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |     MALAYSIAN     |===============|===============|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |     KIDS      |     25.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|       6KM       |===================================================|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |    ADULT      |     40.00     |");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |   NON-MALAYSIAN   |===============|===============|");
            Pw.println("|                 |                   |               |               |");
            Pw.println("|                 |                   |     KIDS      |     35.00     |");
            Pw.println("|=====================================================================|");

            Pw.println("  ");

            Pw.println("                          REFRESHMENT KIT                             ");
            Pw.println("|=====================================================================|");
            Pw.println("|    CODE ITEM    |           FOOD AND DRINKS         |   PRICE(RM)   |");
            Pw.println("|=====================================================================|");
            Pw.println("|                 |                                   |               |");
            Pw.println("|                 | -ROTI GARDENIA                    |               |");
            Pw.println("|        CA       | -ENERGYBYTE                       |     4.00      |");
            Pw.println("|                 |  BAR                              |               |");
            Pw.println("|                 | -MINERAL WATER(500ML)             |               |");
            Pw.println("|                 |                                   |               |");
            Pw.println("|=====================================================================|");
            Pw.println("|                 |                                   |               |");
            Pw.println("|        CB       | -ROTI GARDENIA                    |     4.00      |");
            Pw.println("|                 | -100 PLUS WATER(500ML)            |               |");
            Pw.println("|                 |                                   |               |");
            Pw.println("|=====================================================================|");
            Pw.println("|                 |                                   |               |");
            Pw.println("|        CC       | -ROTI GARDENIA                    |               |");
            Pw.println("|                 | -MINERAL WATER(500ML)             |     2.50      |");
            Pw.println("|                 |                                   |               |");
            Pw.println("|=====================================================================|");

            Pw.println("  ");

            Pw.println("                          PAYMENT METHOD                           ");
            Pw.println("|=====================================================================|");
            Pw.println("|               PAYMENT             |             DISCOUNT            |");
            Pw.println("|=====================================================================|");
            Pw.println("|                                   |                                 |");
            Pw.println("|           TOUCH n GO (TNG)        |                5%               |");
            Pw.println("|                                   |                                 |");
            Pw.println("|=====================================================================|");
            Pw.println("|                                   |                                 |");
            Pw.println("|           ONLINE BANKING          |                3%               |");
            Pw.println("|                                   |                                 |");
            Pw.println("|=====================================================================|");

            Pw.println("  ");

            Pw.println("\n--------------------------------------------------------------------------------------------------------------");
            Pw.println("                                    CUSTOMER'S RECEIPT LIST                                                        ");
            Pw.println("--------------------------------------------------------------------------------------------------------------");

            //Customer Details
            for (int p = 0; p < i; p++) 
            {
                if (pmt[p] != null) 
                {
                    Pw.println(pmt[p].toString());
                }
            }

            //Total Amount for Ticket
            for (i = 0; i < i; i++) 
            {
                if (rc[i] != null) 
                {
                    System.out.print(rc[i].calcPrice());
                }
            }

            //Average
            for ( i = 0; i < pmt.length; i++ )
            {
                if ( pmt[i] != null )
                total += pmt[i].calcTotalPrice();
            }
            average = total / count;
            Pw.println("\n--------------------------------------------------------------------------------------------------------------");
            Pw.println("\t\tAverage of Ticket Sold Income : RM" + String.format("%.2f", average));
            Pw.println("--------------------------------------------------------------------------------------------------------------");
            
            Pw.println("\n--------------------------------------------------------------------------------------------------------------");
            Pw.println("\t\tNumber of Ticket Sold ");
            Pw.println("--------------------------------------------------------------------------------------------------------------");
            
            // Count Ticket sold
            int countTix3 = 0;
            int countTix6 = 0;

            for (i = 0; i < rc.length; i++)
            {
                if (rc[i] instanceof Distance3) 
                {
                    Distance3 dst3 = (Distance3) rc[i];
                    if (dst3.getDistance() == 3) 
                    {
                        countTix3++;
                    }
                }
                if (rc[i] instanceof Distance6)
                {
                    Distance6 dst6 = (Distance6) rc[i];
                    if (dst6.getDistance() == 6) 
                    {
                        countTix6++;
                    }
                }
            }
            Pw.println("\nNum of ticket sold for distance 3 is: " + countTix3);
            Pw.println(" Num of ticket sold for distance 6 is: " + countTix6);

            Pw.println("\n--------------------------------------------------------------------------------------------------------------");
            Pw.println("\t\tMinimum and Maximum Ticket Purchases ");
            Pw.println("--------------------------------------------------------------------------------------------------------------");
            
            // min/max Ticket Purchases
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (int k = 0; k < i; k++) 
            {
                if (pmt[k] != null) 
                {
                    double totalPrice = pmt[k].calcTotalPrice();
                    if (totalPrice < min) 
                    {
                        min = totalPrice;
                    }
                    if (totalPrice > max) 
                    {
                        max = totalPrice;
                    }
                }
            }
            Pw.println("\nMinimum total price : RM" + String.format("%.2f", min));
            Pw.println("Maximum total price : RM" + String.format("%.2f", max));

            // total ticket sales
            double sum = 0.0;
            for (int j = 0; j < i; j++) 
            {
                if (pmt[j] != null) 
                {
                    sum += pmt[j].calcTotalPrice();
                }
            }
            Pw.println("Total ticket sales: RM" + String.format("%.2f", sum));
            Pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }   
    }
}



