import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HungerRelief extends JFrame {

    private ArrayList<String> donations;

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public ungerRelief() {
        donations = new ArrayList<>();

        // Set up the main frame
        setTitle("Food Donation App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create and add panels for the starting page, donor login, registration, recipient login, donor, and recipient
        cardPanel.add(createStartingPagePanel(), "startingPage");
        cardPanel.add(createDonorLoginPanel(), "donorLogin");
        cardPanel.add(createDonorRegistrationPanel(), "donorRegistration");
        cardPanel.add(createRecipientLoginPanel(), "recipientLogin");
        cardPanel.add(createRecipientRegistrationPanel(), "recipientRegistration");
        cardPanel.add(createDonorPanel(), "donor");
        cardPanel.add(createRecipientPanel(), "recipient");

        add(cardPanel);

        // Initially show the starting page
        cardLayout.show(cardPanel, "startingPage");
    }

    private JPanel createStartingPagePanel() {
        JPanel startingPagePanel = new JPanel(new FlowLayout());

        JButton donorLoginButton = new JButton("Donor Login");
        JButton donorRegistrationButton = new JButton("Donor Register");
        JButton recipientLoginButton = new JButton("Recipient Login");
        JButton recipientRegistrationButton = new JButton("Recipient Register");

        donorLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "donorLogin");
            }
        });

        donorRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "donorRegistration");
            }
        });

        recipientLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "recipientLogin");
            }
        });

        recipientRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "recipientRegistration");
            }
        });

        startingPagePanel.add(new JLabel("Welcome to Food Donation App!"));
        startingPagePanel.add(donorLoginButton);
        startingPagePanel.add(donorRegistrationButton);
        startingPagePanel.add(recipientLoginButton);
        startingPagePanel.add(recipientRegistrationButton);

        return startingPagePanel;
    }

    private JPanel createDonorLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back to Starting Page");

        loginPanel.add(new JLabel("Donor Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(backButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your donor authentication logic here
                // For simplicity, let's assume any non-empty username and password are valid
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    cardLayout.show(cardPanel, "donor"); // Change to "donor" for now, modify as needed
                } else {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Invalid credentials");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return loginPanel;
    }

    private JPanel createDonorRegistrationPanel() {
        JPanel registrationPanel = new JPanel(new GridLayout(7, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField(); // New field for phone number
        JTextField emailField = new JTextField(); // New field for email ID
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Starting Page");

        registrationPanel.add(new JLabel("New Donor Username:"));
        registrationPanel.add(usernameField);
        registrationPanel.add(new JLabel("New Password:"));
        registrationPanel.add(passwordField);
        registrationPanel.add(new JLabel("Phone Number:"));
        registrationPanel.add(phoneField);
        registrationPanel.add(new JLabel("Email ID:"));
        registrationPanel.add(emailField);
        registrationPanel.add(new JLabel()); // Empty label for spacing
        registrationPanel.add(registerButton);
        registrationPanel.add(new JLabel()); // Empty label for spacing
        registrationPanel.add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your donor registration logic here
                // For simplicity, let's assume any non-empty username, password, phone, and email are valid
                String newUsername = usernameField.getText();
                String newPassword = new String(passwordField.getPassword());
                String phone = phoneField.getText();
                String email = emailField.getText();

                if (!newUsername.isEmpty() && !newPassword.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Donor Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Invalid donor registration information");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return registrationPanel;
    }

    private JPanel createRecipientLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back to Starting Page");

        loginPanel.add(new JLabel("Recipient Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(backButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your recipient authentication logic here
                // For simplicity, let's assume any non-empty username and password are valid
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    cardLayout.show(cardPanel, "recipient"); // Change to "recipient" for now, modify as needed
                } else {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Invalid credentials");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return loginPanel;
    }

    private JPanel createRecipientRegistrationPanel() {
        JPanel registrationPanel = new JPanel(new GridLayout(7, 2));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField(); // New field for phone number
        JTextField emailField = new JTextField(); // New field for email ID
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back to Starting Page");

        registrationPanel.add(new JLabel("New Recipient Username:"));
        registrationPanel.add(usernameField);
        registrationPanel.add(new JLabel("New Password:"));
        registrationPanel.add(passwordField);
        registrationPanel.add(new JLabel("Phone Number:"));
        registrationPanel.add(phoneField);
        registrationPanel.add(new JLabel("Email ID:"));
        registrationPanel.add(emailField);
        registrationPanel.add(new JLabel()); // Empty label for spacing
        registrationPanel.add(registerButton);
        registrationPanel.add(new JLabel()); // Empty label for spacing
        registrationPanel.add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your recipient registration logic here
                // For simplicity, let's assume any non-empty username, password, phone, and email are valid
                String newUsername = usernameField.getText();
                String newPassword = new String(passwordField.getPassword());
                String phone = phoneField.getText();
                String email = emailField.getText();

                if (!newUsername.isEmpty() && !newPassword.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Recipient Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(ungerRelief.this, "Invalid recipient registration information");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return registrationPanel;
    }

    private JPanel createDonorPanel() {
        JPanel donorPanel = new JPanel(new FlowLayout());

        JTextField donorNameField = new JTextField(20);
        JTextField foodTypeField = new JTextField(20);
        JTextField quantityField = new JTextField(20);
        JButton donateButton = new JButton("Donate");
        JButton clearButton = new JButton("Clear"); // Added Clear button
        JButton backButton = new JButton("Back to Starting Page");

        donorPanel.add(new JLabel("Donor Name:"));
        donorPanel.add(donorNameField);
        donorPanel.add(new JLabel("Food Type:"));
        donorPanel.add(foodTypeField);
        donorPanel.add(new JLabel("Quantity:"));
        donorPanel.add(quantityField);
        donorPanel.add(new JLabel()); // Empty label for spacing
        donorPanel.add(donateButton);
        donorPanel.add(clearButton); // Added Clear button
        donorPanel.add(backButton);

        donateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String donation = String.format("Donor: %s, Food: %s, Quantity: %s",
                        donorNameField.getText(), foodTypeField.getText(), quantityField.getText());
                donations.add(donation);
                JOptionPane.showMessageDialog(ungerRelief.this, "Donation submitted!");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearDonorFields(donorNameField, foodTypeField, quantityField);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return donorPanel;
    }

    private void clearDonorFields(JTextField donorNameField, JTextField foodTypeField, JTextField quantityField) {
        donorNameField.setText("");
        foodTypeField.setText("");
        quantityField.setText("");
    }

    private JPanel createRecipientPanel() {
        JPanel recipientPanel = new JPanel(new BorderLayout());

        JTextArea donationListArea = new JTextArea(10, 20);
        donationListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(donationListArea);

        JButton viewDonationsButton = new JButton("View Donations");
        JButton backButton = new JButton("Back to Starting Page");

        recipientPanel.add(scrollPane, BorderLayout.CENTER);
        recipientPanel.add(viewDonationsButton, BorderLayout.SOUTH);
        recipientPanel.add(backButton, BorderLayout.NORTH);

        viewDonationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDonations(donationListArea);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "startingPage");
            }
        });

        return recipientPanel;
    }

    private void displayDonations(JTextArea donationListArea) {
        donationListArea.setText("Donations:\n");
        for (String donation : donations) {
            donationListArea.append(donation + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FoodDonationAppWithStartingPage1().setVisible(true);
            }
        });
    }
}
