import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.GraphicsEnvironment; 
import java.awt.Rectangle; 
import java.awt.geom.Area; 
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.GraphicsDevice; 
import java.awt.Toolkit;



public class testing2 {
    String variable; 
    String variable2; 
    String variable3; 
    String variable4; 

    testing2(){
        this.variable = "testinggggggg"; 
        this.variable2 = "testinggggggg2"; 
    }


    public void testing(){ 
        System.out.println("x");
        System.out.println(this.variable2);
        System.out.println(variable); 
        System.out.println(variable3);
        
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame(); 
        frame.setVisible(true);
        System.out.print("test");
        Thread.sleep(5000); 
        System.out.println(MouseInfo.getPointerInfo().getLocation());

        // STATIC == FUNCTION(); 
        // STATIC FUNCTION CAN BE ACCESSED IN NON STATIC WAY 
        // NON-STATIC CLASS.NEW   + CLASS.FUNCTION 



    }
}



