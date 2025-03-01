import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculator extends JFrame {
    private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JLabel resultLabel;

    public SalesCalculator() {
        setTitle("Daily Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Phone details
        add(new JLabel("Phone Price:"));
        phonePriceField = new JTextField(10);
        add(phonePriceField);

        add(new JLabel("Phone Quantity Sold:"));
        phoneQuantityField = new JTextField(10);
        add(phoneQuantityField);

        // Repair details
        add(new JLabel("Repair Price per Hour:"));
        repairPriceField = new JTextField(10);
        add(repairPriceField);

        add(new JLabel("Repair Hours:"));
        repairHoursField = new JTextField(10);
        add(repairHoursField);

        // Calculate button
        JButton calculateButton = new JButton("Calculate Total Sales");
        add(calculateButton);

        // Result label
        resultLabel = new JLabel("Total Sales: ");
        add(resultLabel);

        // Button action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSales();
            }
        });
    }

    private void calculateSales() {
        double phonePrice = Double.parseDouble(phonePriceField.getText());
        int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
        double repairPrice = Double.parseDouble(repairPriceField.getText());
        int repairHours = Integer.parseInt(repairHoursField.getText());

        Phone phone = new Phone("Phone", phonePrice, phoneQuantity);
        RepairService repair = new RepairService("Repair", repairPrice, repairHours);

        double totalPhoneSales = phone.calculateTotalSales();
        double totalRepairSales = repair.calculateTotalSales();

        resultLabel.setText("Total Sales - Phones: ₱" + totalPhoneSales + ", Repairs: ₱" + totalRepairSales);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SalesCalculator().setVisible(true);
        });
    }
}