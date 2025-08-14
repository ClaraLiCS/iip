package pract3;

import java.util.Scanner;
/**
 *  Class Test3.
 *  A first class with data input from keyboard, 
 *  and use of operations with int, long, Math, and String.
 *  It has three compilation errors.
 *  @author IIP 
 *  @version Academic Year 2023-24
 */

public class Test3 {

    public static void main(String[] args){
        Scanner kbd=new Scanner(System.in);
        System.out.println("Reading hour from keyboard.");
        System.out.print("   -> Input the hour (between 0 and 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Input the minutes (between 0 and 59): ");
        int m = kbd.nextInt();
        String hh = h/10 + "" + h%10;
        String mm = m/10 + "" + m%10;
        hh = "0" + hh;
        mm = "0" + mm;
        hh = hh.substring(hh.length()-2);
        mm = mm.substring(mm.length()-2);
        System.out.println("Input hour: " + hh + ":" + mm + "h");
        
        long tMinTotal = System.currentTimeMillis() / (60*1000);
        int tMinCurrent = (int) (tMinTotal % (24*60));
        int hC = tMinCurrent / 60;
        int mC = tMinCurrent % 60;
        String hhC = "" + hC;
        String mmC = "" + mC;
        hhC = "0" + hhC;
        mmC = "0" + mmC;
        hhC = hhC.substring(hhC.length()-2);
        mmC = mmC.substring(mmC.length()-2);
        System.out.println("Current hour: " + hhC + ":" + mmC + "h" + " (UTC time).");
        
        int tMinIn = (h * 60) + m;
        int difMin = Math.max(tMinIn,tMinCurrent) - Math.min(tMinIn,tMinCurrent);
        int difMinH = difMin / 60;
        int min = difMin % 60;
        System.out.println("Difference in minutes between two hours: " + difMin + " (" + difMinH + "h., " +  min + "min.)");
    
        
        boolean prev = tMinIn < tMinCurrent;
        System.out.println("Is previous hour " + hh + ":" + mm + " to the hour " + hhC + ":" + mmC+ "? " + prev);
          boolean palindrome = hh.charAt(0) == mm.charAt(1) && hh.charAt(1) == mm.charAt(0);
        System.out.println("Is palindrome the hour " + hh + ":" + mm + "? " + palindrome);
    }    
 
}
