package begin;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Start {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.h2.Driver");
            /** установка соединения*/
            connection = DriverManager.getConnection("jdbc:h2:file:C:\\Users\\max\\DBh2\\H2Intro", "", "");

            /** создание statement*/
            statement = connection.createStatement();

            /** выполнение запроса*/
            resultSet = statement.executeQuery("select * from LESSON");

            while (resultSet.next()) {
                System.out.println("id = " +resultSet.getLong("id")+
                        ", name = " +resultSet.getString("name")+
                        ", code = " + resultSet.getString("code"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE,null, e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE,null, e);
            }
        }
    }
}
