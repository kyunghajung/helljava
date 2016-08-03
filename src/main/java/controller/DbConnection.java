package main.java.controller;

import java.sql.*;

/**
 * Created by junghk on 2016. 8. 2..
 */
public class DbConnection {


    public static Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/hell;MVCC=TRUE", "sa", "");

        return connection;
    }

    public static void closeConnection(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement){
        if(preparedStatement != null) try {preparedStatement.close();} catch (SQLException e){}
        if(resultSet != null) try {resultSet.close();} catch (SQLException e){}
        if(connection != null) try {connection.close();} catch (SQLException e){}
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement){
        if(preparedStatement != null) try {preparedStatement.close();} catch (SQLException e){}
        if(connection != null) try {connection.close();} catch (SQLException e){}
    }

}
