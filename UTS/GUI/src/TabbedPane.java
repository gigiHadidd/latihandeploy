import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedPane extends JFrame {
    TabbedPane(){
        //Set the frame
        JFrame frame = new JFrame("Tab Panel");
        frame.setLayout(new GridLayout(1, 1));

        //Initialize the tabbed panel
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

        frame.add(tab); // Adding the tabbed panel

        //Adding new panel for each task
        ///////////////////////////////////////////////////////////////////////////////////////
        JPanel panel1 = new JPanel();

        String items0pt[] = {"Vanilla", "Chocolate", "Strawberry", "Matcha"};
        JComboBox dropdown = new JComboBox(items0pt);
        panel1.add(dropdown);

        JPanel panel2 = new JPanel();

        String rows[][] = {{"1", "Alpha", "20"},
                           {"2", "Beta", "38"},
                           {"3", "Gamma", "17"},
                           {"4", "Delta", "25"},
                           {"5", "Epsilon", "28"},
                           {"6", "Zeta", "31"},
                           {"7", "Eta", "33"}};
        String column[] = {"No", "Title", "Count"};
        JTable table = new JTable(rows, column);

        panel2.add(new JScrollPane(table));

//        JPanel panel3 = new JPanel();
//        JPanel subpanel31 = new JPanel();
//        JPanel subpanel32 = JP



    }

}
