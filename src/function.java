import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.MouseInputListener;
import javax.swing.text.TabSet;

import jdk.vm.ci.meta.Local;

import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Insets; 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit; 
import java.awt.GraphicsEnvironment; 
import java.awt.GraphicsDevice;

public class function {
    public static JSplitPane Splitpane_creator(JPanel left, JPanel right) {
        JSplitPane splitpane = new JSplitPane();
        splitpane.setLeftComponent(left);
        splitpane.setRightComponent(right);
        splitpane.setBorder(null);
        splitpane.setDividerSize(0);
        return splitpane;
    }

    public static Hashtable<String, Integer> size_calculator(int frame_x, int button_amount, int frame_y,
            Boolean Vertical) {
        Hashtable<String, Integer> button_size = new Hashtable<>();
        if (Vertical == true) {
            int button_x = frame_x;
            int button_y = frame_y / button_amount;
            button_size.put("x", button_x);
            button_size.put("y", button_y);
        } else {
            int button_x = frame_x / button_amount;
            int button_y = frame_y;
            button_size.put("x", button_x);
            button_size.put("y", button_y);
        }
        return button_size;
    }

    public static JPanel top_panel(int menu_no) {
        JPanel top_panel = new JPanel();

        for (int i = 0; i < menu_no; i++) {
            JButton button = new JButton("Button" + i);
            top_panel.add(button);

        }

        return top_panel;
    }

    public static ImageIcon button_icon(String path) {
        ImageIcon img = new ImageIcon(path);
        Image image = img.getImage();
        Image resized = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgg = new ImageIcon(resized);
        return imgg;
    }

    public static JButton button() {
        String path = "C:\\Users\\Edward\\Desktop\\t\\Img\\btn.png";
        String path2 = "C:\\Users\\Edward\\Desktop\\t\\Img\\btn_clicked.png";
        String path3 = "C:\\Users\\Edward\\Desktop\\t\\Img\\btn_hover.png";
        ImageIcon img = function.button_icon(path2);
        ImageIcon imgg = function.button_icon(path);
        ImageIcon imggg = function.button_icon(path3);

        JButton button = new JButton(imgg);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        button.setPreferredSize(new Dimension(143, 151));
        button.setMaximumSize(new Dimension(100, 100));
        button.setLayout(null);
        
        button.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //button.setIcon(img);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setIcon(img);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setIcon(imgg);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(imggg);


            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(imgg);

            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
        return button; 


    }
    
    
    public static void setLocationToBottomCorner(JFrame frame) {
        // GraphicsConfiguration config = frame.getGraphicsConfiguration();
        // Rectangle bounds = config.getBounds();
        // System.out.println(bounds);
        // Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        // System.out.println(insets);
        // int x = bounds.width; 
        // int y = bounds.height; 
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int x = gd.getDisplayMode().getWidth();
        int y = gd.getDisplayMode().getHeight();

        frame.setLocation(x, y);
        
    }

    

    public static void main(String[] args) {
        // Date dt = new Date();
        // Calendar c = Calendar.getInstance(); 
        // // c.setTime(dt); 
        // c.add(Calendar.MONTH, -2);
        // c.add(Calendar.DATE, -1);
        // int test = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        // String Month = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        // System.out.println(Month);

        // ArrayList<Integer> date2 = new ArrayList<>();
        // for(int i = 1; i < 32; i++ ){
        //     date2.add(i);
        // }
       
        // System.out.println(date2);
        // for(int i =0; i <12; i++) {
        //     c.add(Calendar.MONTH,  - i);
        //     String Month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        //     // data.add(Month);

        String a = "a";
        String b= "b";
        String c = "c";

        String test = String.format("TEST %s %s %s", a, b ,c); 
        // String str2 = String.format("%s", "Amar Singh");
        Calendar cccc = Calendar.getInstance(); 
        // Long long= 1609430400798L;
        cccc.setTimeInMillis(1610177092674L);
        System.out.println(cccc.get(Calendar.DATE));

        }

    
}
