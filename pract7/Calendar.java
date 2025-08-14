package pract7;

import pract5.DateTime;

/**
 * Calendar class: data type class representing the calendar of a venue where events are held.
 *
 * @author IIP - Lab Activity 7
 * @version Academic Year 2023/24
 */
public class Calendar {
    public static final int MAX_EVENTS = 30;
    private int numEvents;
    private Event[] program;
    private int[] numPerType;
    
    /** Default constructor to create a new Calendar object empty (without events). */
    public Calendar() {      
        numEvents = 0;
        program = new Event[MAX_EVENTS];
        numPerType = new int[4];
    }
     
    /** 
     * Getter Method of the instance attribute numEvents. Return the total number of events.
     *  @return int, the number of events.
     */
    public int getNumEvents() { return this.numEvents; }
    
    /** 
     * Getter Method of the number of events of a given type, where 1 <= type <= 3.
     *  @param type int, the type. Precondition: 1 <= type <= 3.
     *  @return int, the number of events ot this type.
     */
    public int getNumType(int type) { return this.numPerType[type]; }
    
    /** 
     * Method toString, returns the String representation of all the events of the calendar.
     *  @return String.
     */
    public String toString() {
        String res = "";
        for(int i = 0; i<numEvents; i++){
            res += this.program[i].toString() + "\n";
        }
        return res;
    }
    
    /** 
     * Method that returns true if a given Event e overlaps with any other Event 
     *  in the current calendar. Otherwise, it returns false.
     * @param e Event, the event.
     * @return boolean, true if e overlaps and false otherwise.
     */
    private boolean overlaps(Event e) {
        boolean exists = false;
        for(int i = 0; i<numEvents && exists == false; i++){
            if(UtilEvent.overlaps(e, this.program[i])) {exists = true;}
        }
        return exists;
    }
    
    /** 
     * Method that, if a given Event e fits and does not overlap with any other
     *   in the current calendar, adds it in chronological order to the calendar and returns true. 
     *   If it does not fit or there is overlap, it does not add it and returns false.
     * @param e Event, event to be added.  
     * @return boolean, true if added and false otherwise.
     */    
    public boolean add(Event e) { 
        if(!overlaps(e) && numEvents < MAX_EVENTS){
            int i = numEvents-1;
            while(i>=0 && e.getStartTime().compareTo(this.program[i].getStartTime()) < 0){
                this.program[i+1] = this.program[i];
                i--;
            }
            
            this.program[i+1] = e;
            numPerType[e.getType()]++;
            numEvents++;
        }
        else{
            return false;
        }
        
        return true; 
    }
    
    /** 
     * Method that returns the position in the array program for a given title event.
     * or -1 if it does not exist.
     * @param title String, the title.
     * @return int, the position of the event in the array or -1 if not present. 
     */
    private int searchTitle(String title) {
        for(int i = numEvents-1; i>=0; i--){
            if(title.equals(this.program[i].getTitle())) return i;
        }
        return -1;  
    }
           
    /** 
     * Method that removes the given title event from the calendar, if it exists, and returns true.
     * If it does not exist, removes nothing and returns false.
     * @param title String, the title.
     * @return boolean, true if removed and false otherwise.     * @param title String, the title.
     * @return int, the event's position in the array, or -1 if it is not present. 
     */
    public boolean delete(String title) {
        int pos = searchTitle(title);
        if(pos < 0) return false;
        else{
            numPerType[this.program[pos].getType()]--;
            for(int i = pos; i<numEvents && i<MAX_EVENTS-1; i++){
                this.program[i] = this.program[i+1];
            }
            numEvents--;
            this.program[numEvents] = null;
        }
        return true;
    }
    
    /** 
     * Method that returns the longest event (with the longest duration) in the calendar.
     * Precondition: at least one event. 
     * @return Event, the event.
     */
    public Event eventLarger() {
        Event larger = this.program[0];
        for(int i = 1; i<numEvents; i++){
            if(larger.getDuration() < this.program[i].getDuration()){
                larger = this.program[i];
            }
        }
        return larger;
    }
    
    /** 
     * Method that returns an array with all the events of type type type of the calendar, being 1 <= type <= 3. 
     * The size of the returned array must be equal to the number of events of type type, 
     * being 0 if there are no events of type type type.
     * @param type int, the type. Precondition: 1 <= type <= 3.
     * @return Event[], the array.
     */
    public Event[] filterByType(int type) {
        int n = this.numPerType[type];
        Event[] filtered = new Event[n];
        n = 0;
        for(int i = 0; i<numEvents && n<this.numPerType[type]; i++){
            if(this.program[i].getType() == type){
                filtered[n] = this.program[i];
                n++;
            }
        }
        
        return filtered;
    }
    
}