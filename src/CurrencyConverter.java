import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLayout(null);


        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(20, 20, 460, 30);
        frame.add(titleLabel);

        JLabel amountLabel = new JLabel("Enter Amount :");
        amountLabel.setBounds(40, 70, 140, 20);
        frame.add(amountLabel);


        JTextField amountField = new JTextField();
        amountField.setBounds(200, 70, 240, 20);
        frame.add(amountField);

        JLabel resultLabel = new JLabel("Amount in Tk :");
        resultLabel.setBounds(40, 110, 140, 20);
        frame.add(resultLabel);


        JTextField resultField = new JTextField();
        resultField.setBounds(200, 110, 240, 20);
        frame.add(resultField);



        JLabel currencyLabel = new JLabel("Select Currency:");
        currencyLabel.setBounds(40, 150, 120, 20);
        frame.add(currencyLabel);


        JComboBox<String> currencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "INR", "RUB", "CAD"});
        currencyComboBox.setBounds(200, 150, 240, 20);
        frame.add(currencyComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(200, 190, 100, 30);
        frame.add(convertButton);

        JRadioButton radioButtonFee = new JRadioButton("Enable Conversion Fee");
        radioButtonFee.setBounds(40, 230, 200, 20);
        frame.add(radioButtonFee);


        JRadioButton radioButtonNoFee = new JRadioButton("No Conversion Fee");
        radioButtonNoFee.setBounds(40, 260, 200, 20);
        frame.add(radioButtonNoFee);


        JCheckBox checkBox = new JCheckBox("Round to Nearest Integer");
        checkBox.setBounds(40, 290, 200, 20);
        frame.add(checkBox);



        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonFee);
        buttonGroup.add(radioButtonNoFee);


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input amount
                double amount = Double.parseDouble(amountField.getText());

                // Get the selected currency
                String selectedCurrency = (String) currencyComboBox.getSelectedItem();
                double conversionRate;


                switch (selectedCurrency) {
                    case "USD":
                        conversionRate = 108.20;
                        break;
                    case "EUR":
                        conversionRate = 118.15;
                        break;
                    case "GBP":
                        conversionRate = 137.00;
                        break;
                    case "JPY":
                        conversionRate = 0.77;
                        break;
                    case "INR":
                        conversionRate = 1.32;
                        break;
                    case "RUB":
                        conversionRate = 1.29;
                        break;
                    case "CAD":
                        conversionRate = 81.79;
                        break;
                    default:
                        conversionRate = 1.0;
                }


                if (radioButtonFee.isSelected()) {
                    conversionRate *= 0.98;
                }

                // Convert the amount
                double result = amount * conversionRate;


                if (checkBox.isSelected()) {
                    result = Math.round(result);
                }


                resultField.setText(String.valueOf(result));
            }
        });


        frame.setVisible(true);
    }
}
