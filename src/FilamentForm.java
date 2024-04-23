import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FilamentForm extends JPanel {
    private JComboBox<String> filamentType;
    private JTextField spoolWeightField;
    private JTextField filamentDiameterField;
    private JTextField spoolCostField;
    private JLabel resultLabel, resultLabel2;

    public FilamentForm() {
        setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Select Filament Type:"));
        filamentType = new JComboBox<>(new String[]{"PLA", "ABS", "TPU", "PETG"});
        add(filamentType);

        add(new JLabel("Enter Spool Weight (kg):"));
        spoolWeightField = new JTextField();
        add(spoolWeightField);

        add(new JLabel("Enter Filament Diameter (mm):"));
        filamentDiameterField = new JTextField();
        add(filamentDiameterField);

        add(new JLabel("Enter Spool Cost ($):"));
        spoolCostField = new JTextField();
        add(spoolCostField);

        JButton calculateButton = new JButton("Calculate Cost per Meter");
        calculateButton.addActionListener(this::performCalculation);
        add(calculateButton);

        resultLabel = new JLabel("Cost will be shown here.");
        add(resultLabel);
        add(new JLabel());
        resultLabel2 = new JLabel("Spool length will be shown here.");
        add(resultLabel2);
    }

    private void performCalculation(ActionEvent e) {
        try {
            double weight = Double.parseDouble(spoolWeightField.getText())*1000;
            double diameter = Double.parseDouble(filamentDiameterField.getText());
            double cost = Double.parseDouble(spoolCostField.getText());
            String type = (String) filamentType.getSelectedItem();

            double length = FilamentCostCalculator.calculateLength(weight, diameter, type);
            double costPerMeter = FilamentCostCalculator.calculateCostPerMeter(cost, length);
            resultLabel.setText(String.format("Cost per meter: $%.4f", costPerMeter));
            resultLabel2.setText(String.format("Spool Length (m): %.4f", length));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
