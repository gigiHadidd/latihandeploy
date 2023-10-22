import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI implements  ActionListener{
    //actionListener
    int count = 0;
    JLabel label;
    JFrame frame; // paling luar bisa banyak
    JPanel panel; //dalemnya
    JButton button;

    public GUI() {
        frame = new JFrame();
        button = new JButton("Click Me");
        button.addActionListener(this);

        label = new JLabel("Number of Clicks : 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.pink);
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gladys's GUI");
        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of Clicks " + count);
    }
}