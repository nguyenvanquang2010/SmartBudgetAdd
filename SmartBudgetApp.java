import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartBudgetApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart Budget - Student Expense Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel(new GridLayout(13, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("SMART BUDGET - STUDENT EXPENSE MANAGER", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);
        JTextField nameField = new JTextField();
        JTextField incomeField = new JTextField();
        JTextField rentField = new JTextField();
        JTextField foodField = new JTextField();
        JTextField transportField = new JTextField();
        JTextField utilityField = new JTextField();
        JTextField internetField = new JTextField();
        JTextField studyField = new JTextField();
        JTextField entertainmentField = new JTextField();
        JTextField othersField = new JTextField();

        panel.add(new JLabel("Your Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Total Monthly Income (VND):"));
        panel.add(incomeField);
        panel.add(new JLabel("Rent:"));
        panel.add(rentField);
        panel.add(new JLabel("Food:"));
        panel.add(foodField);
        panel.add(new JLabel("Transportation:"));
        panel.add(transportField);
        panel.add(new JLabel("Utilities (Electricity, Water, Gas):"));
        panel.add(utilityField);
        panel.add(new JLabel("Internet and Phone:"));
        panel.add(internetField);
        panel.add(new JLabel("Study (Books, Tuition):"));
        panel.add(studyField);
        panel.add(new JLabel("Entertainment:"));
        panel.add(entertainmentField);
        panel.add(new JLabel("Other Expenses:"));
        panel.add(othersField);


        JButton calculateBtn = new JButton("Calculate");
        JButton resetBtn = new JButton("Reset");
        panel.add(calculateBtn);
        panel.add(resetBtn);

        frame.add(panel, BorderLayout.CENTER);

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    double income = Double.parseDouble(incomeField.getText());
                    double rent = Double.parseDouble(rentField.getText());
                    double food = Double.parseDouble(foodField.getText());
                    double transport = Double.parseDouble(transportField.getText());
                    double utility = Double.parseDouble(utilityField.getText());
                    double internet = Double.parseDouble(internetField.getText());
                    double study = Double.parseDouble(studyField.getText());
                    double entertainment = Double.parseDouble(entertainmentField.getText());
                    double others = Double.parseDouble(othersField.getText());

                    double totalExpenses = rent + food + transport + utility + internet + study + entertainment + others;
                    double balance = income - totalExpenses;

                    String message = "Hello " + name + ",\n\n"
                            + "Your total monthly expenses: " + String.format("%,.0f", totalExpenses) + " VND\n"
                            + "Remaining balance after expenses: " + String.format("%,.0f", balance) + " VND";

                    JOptionPane.showMessageDialog(frame, message, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers in all fields.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetBtn.addActionListener(e -> {
            nameField.setText("");
            incomeField.setText("");
            rentField.setText("");
            foodField.setText("");
            transportField.setText("");
            utilityField.setText("");
            internetField.setText("");
            studyField.setText("");
            entertainmentField.setText("");
            othersField.setText("");
        });

        frame.setVisible(true);
    }
}