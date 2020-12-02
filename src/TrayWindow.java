import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.util.Hashtable;
import java.awt.AWTException;
import java.awt.Color;

public class TrayWindow {
    public static JFrame frame(JSplitPane sl) {
        JFrame frame = new JFrame();
        frame.add(sl);
        frame.setUndecorated(true);
        frame.setBounds(1000, 1000, 500, 250);
        return frame;

    }

    public static JSplitPane sl_setup(JPanel bottom_comp, JPanel top_comp) {
        JSplitPane splitpane = new JSplitPane(SwingConstants.HORIZONTAL);
        splitpane.setBorder(null);
        splitpane.setBottomComponent(bottom_comp);
        splitpane.setTopComponent(top_comp);
        splitpane.setDividerSize(0);
        return splitpane;
    }




    public static void main(String[] args) throws AWTException {
        JSplitPane sl = sl_setup(new JPanel(),new JPanel()); 
        Color bg = new Color(96, 113, 133); 
        Color fg = new Color(24, 35, 57); 
        panel panel = new panel(sl,bg, fg );    
        JPanel top_panel = panel.panel_creator(5, 50);
        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.LINE_AXIS));
        sl.setTopComponent(top_panel);     
        
        Hashtable<String, JPanel> panels = panel.hashes();
        
        for ( String key : panels.keySet() ) {
            System.out.println(key);
            JButton btn = function.button();
            panels.get(key).add(btn);
        }
        
        JFrame frame = frame(sl);
        frame.setVisible(true); 
        System.out.println(top_panel.getSize());


      


    }
    
}
