package src;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "121531";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = createConnectionToMySQL();

        if(conn!=null){
            System.out.println("Conectado!");
            conn.close();
        }
    }
}