package JDBC;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ConnectionFactory {

         // a linha abaixo "chama" o driver
      private static final String DRIVER = "com.mysql.jdbc.Driver";
        // Armazenando informações referente ao banco
      private static final String URL = "jdbc:mysql://localhost:3308/dbbiblio";
      private static final String USER = "root";
      private static final String PASSWORD = "";
    
    // método responsável por estabelcer a conexão com o banco de dados
    public static Connection getConnection() {// estabelecendo a conexão com o banco
        
        try {
            
        Class.forName(DRIVER);
        return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel realizar conexao com o banco: " + ex); // error message if it occurs / mensagem de erro se ocorrer /
            throw new RuntimeException("Nao foi possivel realizar conexao com o banco: " + ex);
        }
    }
    
     public static void closeConnection(Connection connection) { // method to close the connection / metodo para encerrar a conexao /

        try {

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel encerrar conexao com o banco: " + ex); // error message if it occurs / mensagem de erro se ocorrer /
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement ){ // method to close the connection / metodo para encerrar a conexao /

        closeConnection(connection);

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel encerrar conexao com o banco: " + ex); // error message if it occurs / mensagem de erro se ocorrer /
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet result) { // method to close the connection / metodo para encerrar a conexao /

        closeConnection(connection, statement);

        try {

            if (result != null) {
                result.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel encerrar conexao com o banco: " + ex); // error message if it occurs / mensagem de erro se ocorrer /
        }

    }
}
