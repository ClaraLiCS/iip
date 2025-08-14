package pract6;


/**
 * Write a description of class IIPMath here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IIPMath {
    /** Calculate the sine of an angle x, in radians,*
     * with a maximum error epsilon.
     * 
     * @param double x (the angle)
     * @param double epsilon (the maximum error)
     * @return double the sinus of x
     */
    public static double sin(double x, double epsilon) {
        int k = 0;
        double term = x;
        double prevTerm = 0;
        double sum = x;
        while(Math.abs(term)>epsilon) {
            k++;
            term = -x*x*term / (2 * k * (2 * k + 1 ));
            sum += term;
        }
        return sum;
    }
    
    /** Calculate the sine of an angle x, in radians,
     * with a maximum error 1e-15.
     * 
     * @param double x (the angle)
     * @return double the sinus of x
     */
    public static double sin(double x) {
        double res = sin(x,1e-15);
        return res;
    }
    
    /** Return the reduction of the angle x to the first circumference.
     * Precondition: x is in radians.
     */
    private static double reducFirstCirc(double x) {
        x = x%(Math.PI * 2);
        return x;
    }
}
