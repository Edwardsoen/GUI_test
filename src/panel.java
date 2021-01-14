
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



public class panel implements ActionListener {
    JSplitPane splitpane;
    Hashtable<String, JPanel> button_name_panel_hash;
    Hashtable<String, JButton> button_name_button_object_hash;
    JButton last_button_clicked;
    Color second_panel_color; 
    Color background_color; 
    int frame_x; 
    int frame_y;
    JSplitPane sl; 

    panel(JSplitPane splitpane, Color background_color, Color second_panel_color) throws AWTException {
        this.splitpane = splitpane;
        this.button_name_panel_hash = new Hashtable<String, JPanel>(); // {ButtonActionCommand: Jpanel}
        this.button_name_button_object_hash = new Hashtable<String, JButton>();
        this.background_color = background_color;
        this.second_panel_color = second_panel_color; 
    }

    


    public JPanel panel_creator(int button_amount, int button_size_height) {
        JPanel panel = new JPanel();
        panel.setBackground(background_color);
        panel.setForeground(background_color);

        // panel.add(Box.createRigidArea(new Dimension(5, 0)));
        // Dimension minSize = new Dimension(0, 200);
        // Dimension prefSize = new Dimension(0, 200);
        // Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);
        // panel.add(new Box.Filler(minSize, prefSize, maxSize));
        for (int i = 0; i < button_amount; i++) { 
            String action_command = "Panel " + i;
            JButton button = new JButton(action_command);
            button.setBackground(background_color);
            button.setBorderPainted(false);
            button.setForeground(Color.DARK_GRAY);
            button.setFocusable(false);
            JPanel rightpanel = new JPanel();
            rightpanel.setBackground(second_panel_color);
            button.setActionCommand(action_command);
            button.addActionListener(this);
            button.setPreferredSize(new Dimension(200, button_size_height)); //////////////////////////////////////////////
            button.setMaximumSize(new Dimension(200, button_size_height));
            button_name_panel_hash.put(action_command, rightpanel);
            button_name_button_object_hash.put(action_command, button);
            panel.add(button);
        }

        
        return panel;

    }

    public Hashtable<String, JPanel> hashes(){
        return this.button_name_panel_hash;
    }

    public void actionPerformed(ActionEvent e) {
        if (button_name_panel_hash.containsKey(e.getActionCommand()) == true) {
            try {
                last_button_clicked.setBackground(background_color); // change color to match right frame
                
            } finally {
                splitpane.setRightComponent(button_name_panel_hash.get(e.getActionCommand()));
                button_name_button_object_hash.get(e.getActionCommand()).setBackground(second_panel_color);
                this.last_button_clicked = button_name_button_object_hash.get(e.getActionCommand());
            }
        }
    }



    public static void main(String[] args) throws Exception {
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
        frame.setSize(1000,200);
        frame.setVisible(true);
        

    }

   

}
