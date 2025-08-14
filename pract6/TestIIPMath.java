package pract6;
import graph2D.Graph2D;
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class TestIIPMath here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestIIPMath {
    /** Write to standard output, line by line, the values of
     * Math.sin(x) and IIPMath.sin(x), for x from 0 to 20 radians.
     * Display the difference in absolute value between these values.
     */
    public static void table(){
        double xMin = 0;
        double xMax = 20;
        System.out.println("----------------------------------------------------------------");
        System.out.println(" x          Math.sin(x)          IIPMath.sin(x)          |dif|");
        System.out.println("----------------------------------------------------------------");
        
        double inc = 1;
        for(double x = xMin; x <= xMax; x = x+inc) {
            double dif = Math.abs(Math.sin(x)-IIPMath.sin(x));
            System.out.printf(Locale.US, "%4.1f %23.15f %23.15f %23.15f\n", x, Math.sin(x), IIPMath.sin(x), Math.abs(dif));
        }
    }
    
    /** Get the grapgh of the function IIPMath.sin(x) on the interval [-20,20].
     */
    public static void graph() {
        double xMin = -20;
        double xMax = 20;
        double yMin = -2;
        double yMax = 2;
        
        Graph2D gd = new Graph2D(xMin,xMax,yMin,yMax,800,250);
        gd.setTitle("IIPMath");
        
        double delta = (xMax - xMin)/Graph2D.INI_WIDTH;
        
        for(double x = xMin; x <= xMax; x = x+delta) {
            double y = IIPMath.sin(x);
            gd.drawPoint(x,y,Color.BLUE,2);
        }
    }
}
