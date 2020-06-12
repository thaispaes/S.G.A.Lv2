/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.User;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDAO {
    
    private Connection connection;
    private String sql;

    public boolean insert(User user){
        
        conectar();
        PreparedStatement statement = null;
        sql = "INSERT INTO tbusuario (nome, loguin, senha, tipo) VALUES (?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAccessLevel());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(User user){
        
    conectar();
        PreparedStatement statement = null;
        sql = "UPDATE tbusuario nome = ?, loguin = ?, senha = ?, tipo = ? WHERE id = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAccessLevel());
            statement.setInt(5, user.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(User user){
            
    conectar();
        PreparedStatement statement = null;
        sql = "DELETE FROM tbusuario WHERE id = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, user.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<User> selectAll(){
      
        conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tbusuario;";
        List<User> users = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                User user = new User();
                
                user.setId(result.getInt("id"));
                user.setName(result.getString("nome"));
                user.setLogin(result.getString("loguin"));
                user.setPassword(result.getString("senha"));
                user.setAccessLevel(result.getString("tipo"));
                
                users.add(user);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    public List<User> search(String pesquisa){
      
        conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tbusuario WHERE nome LIKE ? or loguin LIKE ?;";
        List<User> users = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               User user = new User();
                
                user.setId(result.getInt("id"));
                user.setName(result.getString("nome"));
                user.setLogin(result.getString("loguin"));
                user.setPassword(result.getString("senha"));
                user.setAccessLevel(result.getString("tipo"));
                
                users.add(user);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    private void conectar() {
     
        connection = ConnectionFactory.getConnection();

    }
    
}
