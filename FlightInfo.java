package gitairlines;


import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.*;

@SuppressWarnings("unused")
public class FlightInfo extends BaseFrame {
    private static final long serialVersionUID = 1L;

    public FlightInfo() {
        super();
        initializeComponents();
        setWindowProperties(800, 500);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        JTable table = new JTable();

        try (Conn conn = new Conn()) {
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}