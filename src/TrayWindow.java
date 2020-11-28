import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;


public class TrayWindow  {
    public static JFrame frame(JSplitPane sl){ 
        JFrame frame = new JFrame();
        frame.add(sl);
        //frame.setUndecorated(true);   
        frame.setBounds(1000,1000,500,250);
        
        
        
        return frame;    

    }

    public static JSplitPane sl_setup(JPanel bottom_comp, JPanel top_comp){
        JSplitPane splitpane = new JSplitPane(SwingConstants.HORIZONTAL);
        splitpane.setBorder(null);
        splitpane.setBottomComponent(bottom_comp);
        splitpane.setTopComponent(top_comp);
        splitpane.setDividerSize(10);
        return splitpane; 

    }
    
    // public static JPanel top_panel(){ 

    // }
    

    
    
    
    public static void main(String[] args) {
        System.out.println("test");
        JSplitPane sl = sl_setup(new JPanel(),new JPanel()); 
        JFrame frame = frame(sl); 
        frame.setVisible(true);



    }
    
}
