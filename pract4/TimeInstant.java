package pract4;

/**
 * Class TimeInstant. 
 * <p> This class allows you to represent instants or timestamps with 
 * detail of hours and minutes. Thus, this class represents the moment 
 * that defines a time instant, in this case, the hours and minutes of 
 * any given day.
 * </p>
 * 
 *  @author IIP - ETSINF - UPV  
 *  @version Academic Year 2023-24
 */
public class TimeInstant {

    // ATTRIBUTES:
    /** Integer attribute for storing the hours of a TimeInstant. 
     *  It should belong to the interval <code>[0..23]</code>
     */
    private int hours;
    /** Integer attribute for storing the minutes of a TimeInstant. 
     *  It should belong to the interval <code>[0..59]</code> 
     */
    private int minutes;
    
    // CONSTRUCTORS:
    /**
     *  <code>TimeInstant</code> corresponding to <code>iniHours</code> 
     *  hours and <code>iniMinutes</code> minutes.
     *  <p> Precondition: <code>0<=iniHours<24, 0<=iniMinutes<60 </code> </p>
     */
     public TimeInstant(int iniHours, int iniMinutes){
        hours = iniHours;
        minutes = iniMinutes;
        }
   
    /**
     * <code>TimeInstant</code> (hours and minutes) from current 
     * UTC (universal coordinated time).
     */
     public TimeInstant() {
        long tMinTotal = System.currentTimeMillis() / (60*1000);
        int tMinCurrent = (int) (tMinTotal % (24*60));
        hours = tMinCurrent / 60;
        minutes = tMinCurrent % 60;
        }
    
    // CONSULTORS AND MODIFYERS:
    /** Returns hours of current TimeInstant object. */ 
     public int getHours() {
        return hours;
        }

    /** Returns minutes of current TimeInstant object. */ 
     public int getMinutes() {
         return minutes;
        }
     
    /** Modifies hours of current TimeInstant object. */ 
     public void setHours(int newHours) {
         hours = newHours;
        }
    
    /** Modifies minutes of current TimeInstant object. */ 
     public void setMinutes(int newMinutes) {
         minutes = newMinutes;
        }
   
    // OTHER METHODS:
    /** Returns current TimeInstant object in "hh:mm" format. */
     public String toString() {
         String hh = hours/10 + "" + hours%10;
        String mm = minutes/10 + "" + minutes%10;
        hh = "0" + hh;
        mm = "0" + mm;
        hh = hh.substring(hh.length()-2);
        mm = mm.substring(mm.length()-2);
        return hh + ":" + mm;
     }
   
    /** Returns true only if <code> o </code> is a TimeInstant 
     *  that concides in hours and minutes with current TimeInstant.
     */
     public boolean equals(Object o) {
         return o instanceof TimeInstant && ((TimeInstant)o).hours == this.hours && ((TimeInstant)o).minutes == this.minutes;
     }
      
    /** Returns number of minutes from 
     *  00:00 until current TimeInstant object
     */
     public int toMinutes() {
         int min = hours*60 + minutes;
         return min;
        }
    
    /** Chronological comparison of current TimeInstant object 
     *  and <code>tInstant</code> parameter. Result is:
     *     <ul>
     *      <li>negative when current TimeInstant is previous to 
     *        <code>tInstant</code>
     *      </li>
     *      <li> zero if they are equal
     *      </li>
     *      <li>positive when current TimeInstant is posterior to 
     *        <code>tInstant</code>
     *      </li>
     *    </ul>
     */
      public int compareTo(TimeInstant tInstant) {
         return this.toMinutes() - tInstant.toMinutes();
      }

    // EXTRA ACTIVITY:
    /** Returns a TimeInstant from its textual description 
     *  in a <code>String</code> with format "<code>hh:mm</code>".
     */
      // TO COMPLETE
  
}
