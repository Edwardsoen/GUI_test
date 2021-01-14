import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.PopupMenu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Popup;

public class System_tray {
    public static SystemTray Systemtray_creator(TrayIcon trayicon) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        tray.add(trayicon);
        return tray; 

    }

    public static TrayIcon trayicon_creator(PopupMenu menu){ 
        Image image = Toolkit.getDefaultToolkit().getImage("Desktop/thumbnail.png");
        TrayIcon trayicon = new TrayIcon(image, "App", menu );
        return trayicon;
    }





    public static PopupMenu popup(JFrame settings_frame)  {
        PopupMenu popup = new PopupMenu();
        ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        ActionListener settingslistener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               settings_frame.setVisible(true);
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

    
 
 public static void main(String[] args) throws AWTException {
    
     
 }   
}
