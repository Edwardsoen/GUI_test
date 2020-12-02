import java.awt.Dimension;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class function {
    public static JSplitPane Splitpane_creator(JPanel left, JPanel right) {
        JSplitPane splitpane = new JSplitPane(); 
        splitpane.setLeftComponent(left);
        splitpane.setRightComponent(right);
        splitpane.setBorder(null);
        splitpane.setDividerSize(0); 
        return splitpane;
    }
    
    
    public static Hashtable<String, Integer>  size_calculator(int frame_x, int button_amount, int  frame_y,  Boolean Vertical){
        Hashtable <String, Integer> button_size = new Hashtable<>(); 
        if (Vertical == true) {
        int button_x = frame_x;  
        int button_y = frame_y/button_amount;
        button_size.put("x", button_x);
        button_size.put("y", button_y);
        }
        else { 
            int button_x = frame_x/button_amount; 
            int button_y = frame_y; 
            button_size.put("x", button_x);
            button_size.put("y", button_y);
        }
        return button_size; 
    }


    
    public static JPanel top_panel(int menu_no){ 
        JPanel top_panel = new JPanel(); 
        
        for (int i = 0; i < menu_no; i ++ ){
            JButton button = new JButton("Button" + i);
            top_panel.add(button);  
            

        }

        return top_panel; 
    }
    

    public static JButton button(){
        String path = "C:\\Users\\Edward\\Desktop\\t\\Img\\btn.png";
        ImageIcon img = new ImageIcon(path); 
        Image image = img.getImage(); 
        Image resized = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imgg = new ImageIcon(resized);

        JButton button = new JButton(imgg); 
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        
        button.setPreferredSize(new Dimension(143, 151));
        //button.setMaximumSize(new Dimension(100,100));   
        button.setLayout(null);
        return button; 
    }
    
    

    public static void main(String[] args) {
        
    }
}
