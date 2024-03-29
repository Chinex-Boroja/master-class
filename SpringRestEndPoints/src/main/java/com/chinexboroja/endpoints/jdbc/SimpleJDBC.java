package com.chinexboroja.endpoints.jdbc;

import java.sql.*;

public class SimpleJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javabook", "scott", "tiger");
        System.out.println("Database connected");

        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        ResultSet resultSet = statement.executeQuery(
                "SELECT firstName, mi, lastName FROM Student WHERE lastName = 'Smith'"
        );

        // Check through the result and display the student name
        while (resultSet.next())
            System.out.println(resultSet.getString(1)
                    + "\t" + resultSet.getString(2)
                    + "\t" + resultSet.getString(3));

        // Close the connection
        connection.close();

    }
}
