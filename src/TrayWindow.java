import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.text.Position;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
        bottom_comp.setBackground(new Color(96, 113, 133));
        splitpane.setBottomComponent(bottom_comp);
        splitpane.setTopComponent(top_comp);
        splitpane.setDividerSize(0);
        return splitpane;
    }

    public static JFrame mini_frame() throws AWTException, IOException {
        JSplitPane sl = sl_setup(new JPanel(), new JPanel());
        Color bg = new Color(96, 113, 133);
        Color fg = new Color(24, 35, 57);
        panel panel = new panel(sl, bg, fg);
        JPanel top_panel = panel.panel_creator(5, 50);
        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.LINE_AXIS));
        sl.setTopComponent(top_panel);
        Hashtable<String, JPanel> panels = panel.hashes();
        JPanel new_panel = Traywindow_panels.panel_1(panels.get("button0"));
        panels.put("Button" + 0,new_panel);          
        JFrame frame = frame(sl);
        frame.setVisible(true); 
        return frame; 
    }

    


    public static void main(String[] args) throws AWTException, IOException, InterruptedException {
        JSplitPane sl = sl_setup(new JPanel(), new JPanel());
        Color bg = new Color(96, 113, 133);
        Color fg = new Color(24, 35, 57);
        panel panel = new panel(sl, bg, fg);
        int panel_no = 5;
        JPanel top_panel = panel.panel_creator(panel_no, 50);
        top_panel.setLayout(new BoxLayout(top_panel, BoxLayout.LINE_AXIS));
        sl.setTopComponent(top_panel);

        Hashtable<String, JPanel> panels = panel.hashes();
        //Traywindow_panels.panel_1(panels.get("Panel 0")); 
        Traywindow_panels TrayWindow_panels = new Traywindow_panels();
        for(int i = 0; i < panel_no; i++){
            String panel_name = "Panel " + i; 
            TrayWindow_panels.add_button_to_panel(panels.get(panel_name), 3);
        }
        Iterator it = Traywindow_panels.read_command();
        ArrayList<JButton> bl = TrayWindow_panels.flat_list();
        int i = 0;
        while(it.hasNext()){
            String command = it.next().toString();
            bl.get(i).addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Runtime.getRuntime().exec(command);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            });
            i+= 1; 
        }


        
        JFrame frame = frame(sl);
        //frame.setVisible(true); 
        //function.setLocationToBottomCorner(frame);
        frame.setLocation(MouseInfo.getPointerInfo().getLocation());
        frame.setVisible(true);

        

        

    }
    
}
