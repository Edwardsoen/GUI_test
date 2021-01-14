import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;


public class settings_panel {
    public static JFrame settings_main_frame() throws AWTException {
        JSplitPane splitpane = new JSplitPane(SwingConstants.VERTICAL);
        Color bg = new Color(96, 113, 133); 
        Color fg = new Color(24, 35, 57); 
        panel App = new panel(splitpane, bg, fg);
        JPanel leftpanel = App.panel_creator(9, 70);
        leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));
        splitpane.setBorder(null);
        splitpane.setLeftComponent(leftpanel);
        splitpane.setRightComponent(new JPanel()); //
        splitpane.setDividerSize(0); 
        JFrame frame = new JFrame(); 
        frame.add(splitpane); 
        frame.setSize(1000,1000);
        frame.setVisible(true);
        return frame; 
    } 




    
    public static void main(String[] args) throws AWTException {
       
        
    }
}
