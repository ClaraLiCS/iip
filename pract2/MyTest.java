package pract2;

 
/**
 * Program class to test all the defined shapes
 * Can be executed from BlueJ <B>workbench</B> 
 * @author IIP
 * @version Academic year 2023/24
 */
public class MyTest {
    /** No objects of this class are created. */
    private MyTest() { }

    public static void main(String[] args) {        
        // Init blackboard given name and dimensions
        Blackboard bb = new Blackboard("WINDOW TO THE WORLD", 500, 300);
          
        Circle c2 = new Circle(16, "lightgray", 222, 50);     
        // put it on the drawing space
        bb.add(c2);
        // show on the screen the perimeter of the circle
        
        Circle c3 = new Circle(16, "lightgray", 228, 35);     
        // put it on the drawing space
        bb.add(c3);
        
        Circle c4 = new Circle(16, "lightgray", 232, 45);     
        // put it on the drawing space
        bb.add(c4);
        // show on the screen the perimeter of the circle
        
        Circle c5 = new Circle(16, "lightgray", 245, 38);     
        // put it on the drawing space
        bb.add(c5);
        // show on the screen the perimeter of the circle
        
        Circle c6 = new Circle(16, "lightgray", 239, 25);     
        // put it on the drawing space
        bb.add(c6);
        // show on the screen the perimeter of the circle
        
        Circle c7 = new Circle(16, "lightgray", 220, 28);     
        // put it on the drawing space
        bb.add(c7);
        // show on the screen the perimeter of the circle
     
        Rectangle r3 = new Rectangle(35, 75, "grey", 225, 95);
        // put it on the drawing space
        bb.add(r3); 
     
        TrIsosceles t = new TrIsosceles(100, 75, "red", 200, 120 );
        // put it on the drawing space
          bb.add(t);  
     
        // Yellow circle
        Circle c = new Circle(10, "blue", 200, 125);     
        // put it on the drawing space
        bb.add(c);
        // show on the screen the perimeter of the circle
        
        // Long and red rectangle
        Rectangle r = new Rectangle(100, 100, "yellow", 200, 195);
        // put it on the drawing space
        bb.add(r); 
        
        Rectangle r2 = new Rectangle(30, 70, "black", 200, 210);
        // put it on the drawing space
        bb.add(r2); 
              
    }
    
} // of TestProgram
