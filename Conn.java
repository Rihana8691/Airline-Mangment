package gitairlines;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class Conn implements DatabaseOperations, AutoCloseable {
    Connection c;
    Statement s;

    public Conn() {
        connect();
    }

    @Override
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airline6", "root", "pam.1719");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (s != null) {
            s.close();
        }
        if (c != null) {
            c.close();
        }
    }
}
    
    
    