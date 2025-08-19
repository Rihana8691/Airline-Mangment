package gitairlines;



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends BaseFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
        initializeComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void initializeComponents() {
        JLabel image = new JLabel(new ImageIcon(ClassLoader.getSystemResource("gitairlines/icons/plane2.jpg")));
        //image.setBounds(0, 0, 1600, 800);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        image.setBounds(0, 0, width, height);
        add(image);
        

        JLabel heading = new JLabel("WELCOME TO AIRLINES");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        image.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);

        addMenuItem(details, "Flight Details");
        addMenuItem(details, "Add Customer Details");
        addMenuItem(details, "Book Flight");
        addMenuItem(details, "Journey Details");
        addMenuItem(details, "Cancel Ticket");
    }

    private void addMenuItem(JMenu details, String name) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(this);
        details.add(menuItem);
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        switch (text) {
            case "Add Customer Details":
                new AddCustomer();
                break;
            case "Flight Details":
                new FlightInfo();
                break;
            case "Book Flight":
                new BookFlight();
                break;
            case "Journey Details":
                new JourneyDetails();
                break;
            case "Cancel Ticket":
                new Cancel();
                break;
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}