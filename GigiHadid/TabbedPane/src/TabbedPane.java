import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedPane extends JFrame {
    TabbedPane() {
        super("Tab Panel");
        setLayout(new GridLayout(1, 1));

        // Initialize the tabbed panel
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

        add(tab); // Adding the tabbed panel

        // Adding new panel for each task
        ///////////////////////////////////////////////////////////////////////////////////////
        JPanel panel1 = new JPanel();

        String items0pt[] = {"Vanilla", "Chocolate", "Strawberry", "Matcha"};
        JComboBox<String> dropdown = new JComboBox<>(items0pt);
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

        // Create a button for exiting the application
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application when the button is clicked
            }
        });

        // Add the button to a new panel
        JPanel panel3 = new JPanel();
        panel3.add(exitButton);

        tab.addTab("Dropdown", panel1);
        tab.addTab("Table", panel2);
        tab.addTab("Exit", panel3); // Add the exit button panel to the tab

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TabbedPane().setVisible(true);
        });
    }
}
