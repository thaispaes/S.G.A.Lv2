/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ManagerFactory;
import JDBC.ConnectionFactory;
import Model.ImageFile;
import Model.Manager;
import com.mysql.jdbc.Connection;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManagerDAO {
    
    private Connection connection;
    private String sql;
    private static Manager loggedManeger;

    public boolean insert(Manager user){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_user (user_name, user_login, user_password, user_access_level, user_image_perfil, user_image_name , user_email, user_address, user_cep, user_phone, user_school) VALUES (?,?,?,?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getAccessLevel());
            
            if(user.getPerfilImage() != null){
                
                statement.setBinaryStream(5, user.getPerfilImage().getInput());
                statement.setString(6, user.getPerfilImage().getFile().getName());
            }
            
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getAddress());
            statement.setString(9, user.getCEP());
            statement.setString(10, user.getPhone());
            statement.setString(11, user.getSchool());
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(Manager user){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_user SET user_name = ?, user_login = ?, user_password = ?, user_access_level = ?, user_image_perfil = ?,user_image_name = ? , user_email = ?, user_address = ?, user_cep = ?, user_phone = ?, user_school = ? WHERE id_user = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getAccessLevel());
            
            if(user.getPerfilImage() != null){
                statement.setBinaryStream(5, user.getPerfilImage().getInput());
                statement.setString(6, user.getPerfilImage().getFile().getName());
            }
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getAddress());
            statement.setString(9, user.getCEP());
            statement.setString(10, user.getPhone());
            statement.setString(11, user.getSchool());
            statement.setInt(12, user.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(Manager user){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_user WHERE id_user = ?;";
        

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
    

    public List<Manager> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_user;";
        List<Manager> users = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Manager user = ManagerFactory.generateManager(result);
                
                users.add(user);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    public List<Manager> search(String pesquisa){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_user WHERE user_name LIKE ? or login LIKE ?;";
        List<Manager> users = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               Manager user = ManagerFactory.generateManager(result);
                
                users.add(user);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return users;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_user WHERE user_name LIKE ? or login LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public Manager exist(Manager user){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_user WHERE user_password LIKE ? and login LIKE ?;";
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+user.getPassword()+"%");
            statement.setString(2, "%"+user.getLogin()+"%");
            
             result = statement.executeQuery();
            
            while(result.next()){
                
 
                
                user.setId(result.getInt("id_user"));
                user.setName(result.getString("user_name"));
                user.setLogin(result.getString("user_login"));
                user.setPassword(result.getString("user_password"));
                user.setAccessLevel(result.getInt("user_access_level"));
               
                String imageName = result.getString("user_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    user.setPerfilImage(result.getBinaryStream("user_image_perfil"), imageName);
                              
                }
               
                user.setEmail(result.getString("user_email"));
                user.setAddress(result.getString("user_address"));
                user.setCEP(result.getString("user_cep"));
                user.setPhone(result.getString("user_phone"));
                user.setSchool(result.getString("user_school"));

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }
    
}
