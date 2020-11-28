
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.Hashtable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

public class App implements ActionListener, WindowStateListener, MouseListener {
    JSplitPane splitpane;
    Hashtable<String, JPanel> button_hash;
    Hashtable<String, JButton> button_hash2;
    JButton last_button_clicked;
    SystemTray tray;
    Image image;
    TrayIcon trayicon;
    JFrame mini_frame;
    JFrame frame;   



    App(JSplitPane splitpane) throws AWTException {
        this.splitpane = splitpane;
        this.button_hash = new Hashtable<String, JPanel>(); // {ButtonActionCommand: Jpanel}
        this.button_hash2 = new Hashtable<String, JButton>();
        this.tray = SystemTray.getSystemTray();
        this.image = Toolkit.getDefaultToolkit().getImage("Desktop/thumbnail.png");
        this.trayicon = new TrayIcon(image, "App", this.popup());
        this.trayicon.addMouseListener(this);
        this.tray.add(this.trayicon);
        //this.mini_frame = TrayWindow.frame();

    }

    
    public JPanel panel_creator(Color color, int button_amount) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setForeground(color);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));

        Dimension minSize = new Dimension(0, 200);
        Dimension prefSize = new Dimension(0, 200);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);

        panel.add(new Box.Filler(minSize, prefSize, maxSize));

        for (int i = 0; i < button_amount; i++) { // dynamically add button & buttonaction
            String action_command = "button" + i;
            JButton button = new JButton(action_command);
            button.setBackground(color);
            button.setBorderPainted(false);
            button.setForeground(new Color(96, 113, 133));
            button.setFocusable(false);

            JPanel rightpanel = new JPanel();
            rightpanel.setBackground(new Color(43, 70, 100));

            button.setActionCommand(action_command);
            button.addActionListener(this);
            button.setPreferredSize(new Dimension(200, 70)); //////////////////////////////////////////////
            button.setMaximumSize(new Dimension(200, 70));

            button_hash.put(action_command, rightpanel);
            button_hash2.put(action_command, button);

            panel.add(button);
        }
        return panel;

    }

    public void actionPerformed(ActionEvent e) {
        if (button_hash.containsKey(e.getActionCommand()) == true) {
            try {
                last_button_clicked.setBackground(new Color(24, 35, 57)); // change color to match right frame
            } finally {
                splitpane.setRightComponent(button_hash.get(e.getActionCommand()));
                button_hash2.get(e.getActionCommand()).setBackground(new Color(43, 70, 100));
                this.last_button_clicked = button_hash2.get(e.getActionCommand());
            }
        }
    }

    public JFrame FrameSetings(JSplitPane sl) {
        frame = new JFrame();
        frame.add(sl);
        frame.setBounds(1000, 1000, 1000, 1000);
        //frame.setVisible(true);

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setUndecorated(true);
        frame.addWindowStateListener(this);
        return frame;

    }

    public void windowStateChanged(WindowEvent e) {
        // SystemTray tray = SystemTray.getSystemTray();
        // Image image = Toolkit.getDefaultToolkit().getImage("Desktop/thumbnail.png");
        // TrayIcon trayIcon = new TrayIcon(image, "testing", this.popup());
        // trayIcon.setImageAutoSize(true);//////////////
        // System.out.println(e.getNewState()); ///////////////

        if ((e.getNewState() == 1) || (e.getNewState() == 7)) {// if minimized
            try {
                tray.add(trayicon);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }

        } else {
            tray.remove(trayicon);
            System.out.println("trayicon removed ");

        }

    }




    public PopupMenu popup() {
        PopupMenu popup = new PopupMenu();
        ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        
        ActionListener settingslistener = new ActionListener(){ 
            public void actionPerformed(ActionEvent e ) {
                frame.setVisible(true); 
            }
        };

        MenuItem settingsmenu = new MenuItem("Settings");
        MenuItem menuItem = new MenuItem("Exit");
        settingsmenu.addActionListener(settingslistener);
        menuItem.addActionListener(exitListener);
        popup.add(settingsmenu); 
        popup.add(menuItem);

        return popup;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getButton());
        if (e.getButton() == 1 ){ 
        if (mini_frame.isVisible() == true){
            mini_frame.setVisible(false);
        }
        else { 
            mini_frame.setVisible(true);
        }
        
    }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) throws Exception {
        JSplitPane splitpane = new JSplitPane(SwingConstants.VERTICAL);
        App App = new App(splitpane);
        JPanel leftpanel = App.panel_creator(new Color(24, 35, 57), 10);
        // leftpanel.add(Box.createVerticalGlue());

        leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.PAGE_AXIS));

        JPanel rightpanel = App.panel_creator(new Color(39, 59, 60), 0); // placeholder

        splitpane.setBorder(null);
        splitpane.setLeftComponent(leftpanel);
        splitpane.setRightComponent(rightpanel); //
        splitpane.setDividerSize(0); 
        App.FrameSetings(splitpane);
       
        

    }

   

}
