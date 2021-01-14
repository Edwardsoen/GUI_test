
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter; 
import java.awt.SystemTray;

public class App {

    // public void windowStateChanged(WindowEvent e) {

    // if ((e.getNewState() == 1) || (e.getNewState() == 7)) {// if minimized
    // try {
    // tray.add(trayicon);
    // } catch (AWTException e1) {
    // e1.printStackTrace();
    // }

    // } else {
    // tray.remove(trayicon);
    // System.out.println("trayicon removed ");

    // }

    // }

    public static void main(String[] args) throws Exception {
        JFrame settings_frame = settings_panel.settings_main_frame();
        JFrame mini_frame = TrayWindow.mini_frame();
        settings_frame.setVisible(false);
        //mini_frame.setVisible(false);
        PopupMenu popup = System_tray.popup(settings_frame);
        TrayIcon trayicon = System_tray.trayicon_creator(popup);
        SystemTray systemtray = System_tray.Systemtray_creator(trayicon);
    
        trayicon.addMouseListener(new MouseAdapter() {
        
            @Override
            public void mouseClicked(MouseEvent e) {
                
                mini_frame.setLocation( 1000 , 1000);
                if (e.getButton() == 1 ) { 
                    
                    
                    if (mini_frame.isVisible() == false) {
                        function.setLocationToBottomCorner(mini_frame);
                        mini_frame.setVisible(true);
                        
                    }
                    
                    else {
                        mini_frame.setVisible(false);
                    }


                }
                //mini_frame.setVisible(true);

            }

            
        });

        
        

    }

   

}
