import java.util.Scanner;



public class embroidery {
    public static void main (String args[]) {
        Scanner myScanner = new Scanner (System.in);
        System.out.println ("Enter Machine Shift Length in minutes: ");
        Double T = myScanner.nextDouble();
        Double TimeLeft = 0.0;
        int L = 0;
        
        for (TimeLeft = T; TimeLeft > 0.0; T++) {
            System.out.println("Enter Stitch Count of Location: ");
            
            Double a = myScanner.nextDouble();
            Double b = (a/11.58);                                               //calculate theoretical batch time
            Double c = (b*1.1688);                                              // adjust to account for downtime
            
            System.out.println("Enter Run Quantity: ");
            Double d = myScanner.nextDouble();
            Double e = (d % 8.0);
            int f = (int)(d/8);
            
            int numBat = 0;
            if (e > 0){
                numBat = f + 1;
                System.out.println("Number of Batches: " +(f+1));
            }
            else {
                numBat = f+1;
                System.out.println("Number of Batches: " +(f));
            }
            
            System.out.println("Enter order type (0 for hats, 1 for flats): "); //setup time to hoop
            
            int g = myScanner.nextInt();
            switch (g) {
                case 0: g = 200;
                break;
                case 1: g = 299;
                break;
                default: System.out.println("You did not enter an appropriate order type.");
                
                System.out.println("Time left: " +TimeLeft);
                break;
            }
            
            Double h = c + g;
            Double i = (numBat)*h;
            Long j = Math.round((i/60)*100/100);
            TimeLeft = TimeLeft-j;
            System.out.println("TimeLeft: " +(TimeLeft));
            
            if( TimeLeft  <0 ) {
                System.out.println("Last order too large to complete. If you want to enter a different order enter '0': ");
                System.out.println("If you want to begin on a new machine enter '1': ");
                int m = myScanner.nextInt();
                switch (m){
                    case 0 : TimeLeft = TimeLeft+j;
                    break;
                    case 1 : System.out.println("Enter New Machine Shift Length in minutes: " );
                    Double u = myScanner.nextDouble();
                    TimeLeft = u;
                    break;
                    default : System.out.println ("You did not enter a correct digit.");
                }
            }
            
            else {
                System.out.println("If you want to enter another order enter '0': ");
                System.out.println("If you want to begin on a new machine enter '1': ");
                System.out.println("If you want to take out the last order entered enter '2': ");
                
                int N = myScanner.nextInt();
                switch (N) {
                    case 0 : L++;
                    break;
                    case 1 : System.out.println("Enter New Machine Shift Length in Minutes: ");
                    Double S = myScanner.nextDouble();
                    TimeLeft = S;
                    System.out.println("New Machine Time Left is " +(TimeLeft));
                    break;
                    case 2 : TimeLeft = TimeLeft+j;
                    System.out.println(TimeLeft);
                    break;
                    default: System.out.println("You did not enter a correct digit");
                    break;
                }
            }
        }
    }
} 

//git add .
//git commit -m "message"
//git push