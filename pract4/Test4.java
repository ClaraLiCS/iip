package pract4;
import java.util.Scanner;
/**
 *  Class Test4. Test of TimeInstat.
 *  @author IIP 
 *  @version Academic Year 2023-24
 */
public class Test4 {
    
    /** No objects of this class are created. */
    private Test4() { }
    
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();
            
       TimeInstant t = new TimeInstant(h,m);
       TimeInstant curr = new TimeInstant();
 
       System.out.println("Input hour: " + t.toString());
       System.out.println("Current hour: " + curr.toString());
       System.out.println("Difference in minutes between the two hours: " + t.compareTo(curr));
       System.out.print("Is previous input hour to current hour? ");
       if(t.compareTo(curr) > 0) System.out.println("No");
       else System.out.println("Yes");
    }    
 
}   
