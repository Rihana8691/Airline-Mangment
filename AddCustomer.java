package gitairlines;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("unused")
public class AddCustomer extends BaseFrame implements ActionListener {

    /**
   * 
   */
  private static final long serialVersionUID = 1L;
  JTextField tfName, tfNationality, tfPhone, tfAddress, tfpassnum;
    JRadioButton rbMale, rbFemale;
    JButton btnAdd, btnReset;

    public AddCustomer() {
        super();
        initializeComponents();
        // Set the window to visible here
        setVisible(true);
    }

    private void initializeComponents() {
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 50, 150, 25);
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200, 50, 150, 25);
        add(tfName);

        JLabel lblNationality = new JLabel("Nationality:");
        lblNationality.setBounds(50, 100, 150, 25);
        add(lblNationality);

        tfNationality = new JTextField();
        tfNationality.setBounds(200, 100, 150, 25);
        add(tfNationality);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 150, 150, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200, 150, 150, 25);
        add(tfPhone);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(50, 200, 150, 25);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 200, 150, 25);
        add(tfAddress);

        JLabel lblpassnum = new JLabel("passport number:");
        lblpassnum.setBounds(50, 250, 150, 25);
        add(lblpassnum);

        tfpassnum = new JTextField();
        tfpassnum.setBounds(200, 250, 150, 25);
        add(tfpassnum);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(50, 300, 150, 25);
        add(lblGender);

        // Radio Buttons for Gender (Male and Female)
        ButtonGroup genderGroup = new ButtonGroup();
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 300, 70, 25);
        add(rbMale);
        genderGroup.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(270, 300, 70, 25);
        add(rbFemale);
        genderGroup.add(rbFemale);

        btnAdd = new JButton("Save");
        btnAdd.setBounds(50, 350, 150, 25);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnReset = new JButton("Reset");btnReset.setBounds(220, 350, 120, 25);
        btnReset.addActionListener(this);
        add(btnReset);

        setSize(400, 450);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            String name = tfName.getText();
            String nationality = tfNationality.getText();
            String phone = tfPhone.getText();
            String address = tfAddress.getText();
            String aadhar = tfpassnum.getText();
            String gender = null;

            if (rbMale.isSelected()) {
                gender = "Male";
            } else if (rbFemale.isSelected()) {
                gender = "Female";
            } 

            if (!isValidName(name)) {
                JOptionPane.showMessageDialog(null, "Name should not contain numbers.");
                return; 
            }

            if (!isValidNationality(nationality)) {
                JOptionPane.showMessageDialog(null, "Nationality should not contain numbers.");
                return; 
            }

            if (!isValidPhone(phone)) {
                JOptionPane.showMessageDialog(null, "Phone number should only contain numbers.");
                return; 
            }

            if (!isValidAadhar(aadhar)) {
                JOptionPane.showMessageDialog(null, "Aadhar number should only contain numbers.");
                return; 
            }
            try {
                Conn conn = new Conn();
                
                String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnReset) {
            tfName.setText("");
            tfNationality.setText("");
            tfPhone.setText("");
            tfAddress.setText("");
            tfpassnum.setText("");
            rbMale.setSelected(false); 
            rbFemale.setSelected(false); 
        }
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Zs]+"); // Allow letters and spaces
    }

    private boolean isValidNationality(String nationality) {
        return nationality.matches("[a-zA-Zs]+"); // Allow letters and spaces
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d+"); // Allow only digits
    }

    private boolean isValidAadhar(String aadhar) {
        return aadhar.matches("\\d+"); // Allow only digits
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}