import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDb {
//    step2: connection  is interface
    Connection c;

//    step3: creating statement
    Statement s;
    ConnectionDb(){
//                            to connect database
//                  1. Register the Driver Class
//                  2. Creating the connection Sting
//                  3. Creating Statement
//                  4. Executing Mysql queries
//                  5. Closing the connections


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection("jdbc:mysql:///employmanagementsystem","root","Prem@123");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
