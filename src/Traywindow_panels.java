import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Traywindow_panels {
    static ArrayList<JButton> flat_button_list;

    Traywindow_panels() {
        this.flat_button_list = new ArrayList<>();
    }

    public static String output(InputStream inputstream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        String output = reader.readLine();
        return output;
    }

    public ArrayList<JButton> flat_list() {
        return flat_button_list;
    }

    public static HashMap<JPanel, List<JButton>> add_button_to_panel(JPanel panel, int button_amount) {
        HashMap<JPanel, List<JButton>> map = new HashMap<>();
        List<JButton> button_list = new ArrayList<JButton>();
        for (int i = 0; i < button_amount; i++) {
            JButton btn = function.button();
            panel.add(btn);
            button_list.add(btn);
            flat_button_list.add(btn);
        }
        map.put(panel, button_list);
        return map;
    }

    public static void add_command_to_button(HashMap<JPanel, List<JButton>> map) {
        Iterator it = Traywindow_panels.read_command();
        ArrayList<JButton> flat_button_lsit = new ArrayList<>();
        int button_no = 0;
        for (Map.Entry<JPanel, List<JButton>> entry : map.entrySet()) {
            List<JButton> btn_list = entry.getValue();
            for (int i = 0; i < btn_list.size(); i++) {
                flat_button_lsit.add(btn_list.get(i));

            }

        }
    }

    public static Iterator read_command() {
        ArrayList<String> cl = new ArrayList<>();
        String command = "cmd.exe /c " + System.getProperty("user.dir") + "\\resources\\" + "test.py";
        cl.add(command);
        Iterator it = cl.listIterator();
        return it;
    }

    public static void main(String[] args) throws IOException {
        
       
        // FileInputStream fis = new FileInputStream("C:\\Users\\Edward\\Desktop\\t\\resources\\commands.json");
        // InputStreamReader reader = new InputStreamReader(fis);
        // BufferedReader breader = new BufferedReader(reader);
        // StringBuilder str = new StringBuilder();
        // String line = breader.readLine();
        // if (line != null) {
        //     str.append(line);
        //     line = breader.readLine();
        // }
        // HashMap<String, String> a = new HashMap<>();
        
        
    
    
    }
	
}
