import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarApp {
    private static int month;
    private static int year;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        month = Calendar.getInstance().get(Calendar.MONTH);
        year = Calendar.getInstance().get(Calendar.YEAR);

        JFrame frame = new JFrame("Calendar App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel(" " + getMonthName(month) + " " + year);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        calendarPanel.add(label, BorderLayout.NORTH);

        JPanel daysPanel = new JPanel(new GridLayout(1, 7));
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day);
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            daysPanel.add(dayLabel);
        }
        calendarPanel.add(daysPanel, BorderLayout.SOUTH);

        JPanel monthPanel = new JPanel(new GridLayout(6, 7));
        calendarPanel.add(monthPanel, BorderLayout.CENTER);

        updateCalendar(monthPanel, month, year);

        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (month == 0) {
                    month = 11;
                    year--;
                } else {
                    month--;
                }
                label.setText(" " + getMonthName(month) + " " + year);
                updateCalendar(monthPanel, month, year);
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (month == 11) {
                    month = 0;
                    year++;
                } else {
                    month++;
                }
                label.setText(" " + getMonthName(month) + " " + year);
                updateCalendar(monthPanel, month, year);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(prevButton);
        controlPanel.add(nextButton);

        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month];
    }

    private static void updateCalendar(JPanel panel, int month, int year) {
        panel.removeAll();

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < firstDay; i++) {
            panel.add(new JLabel(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            JButton dayButton = new JButton(Integer.toString(day));
            panel.add(dayButton);
        }

        panel.revalidate();
        panel.repaint();
    }
}
