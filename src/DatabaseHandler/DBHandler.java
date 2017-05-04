package DatabaseHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ruzal on 3/30/2017.
 */
public class DBHandler {

    private Connection conn;


    public Connection getConnected(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");

        } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Connection Couldnt load");
            }


        return conn;

    }

}
