/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.ImageFile;
import Model.Client;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel
 */
public class ClientDAO {
    
     private Connection connection;
    private String sql;
    private static Client loggedManeger;

    public boolean insert(Client client){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_client (client_name, client_login, client_password, client_access_level, client_image_perfil, client_image_name , client_email, client_address, client_cep, client_phone) VALUES (?,?,?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setInt(4, client.getAccessLevel());
            
            if(client.getPerfilImage() != null){
                
                statement.setBinaryStream(5, client.getPerfilImage().getInput());
                statement.setString(6, client.getPerfilImage().getFile().getName());
            }
            
            statement.setString(7, client.getEmail());
            statement.setString(8, client.getAddress());
            statement.setString(9, client.getCEP());
            statement.setString(10, client.getPhone());
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(Client client){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_client client_name = ?, client_login = ?, client_password = ?, client_access_level = ?, client_image_perfil = ?,client_image_name = ? , client_email = ?, client_address = ?, client_cep = ?, client_phone = ? WHERE id_client = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, client.getName());
            statement.setString(2, client.getLogin());
            statement.setString(3, client.getPassword());
            statement.setInt(4, client.getAccessLevel());
            
            if(client.getPerfilImage() != null){
                statement.setBinaryStream(5, client.getPerfilImage().getInput());
                statement.setString(6, client.getPerfilImage().getFile().getName());
            }
            statement.setString(7, client.getEmail());
            statement.setString(8, client.getAddress());
            statement.setString(9, client.getCEP());
            statement.setString(10, client.getPhone());
            statement.setInt(12, client.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(Client client){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_client WHERE id_client = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, client.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<Client> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_client;";
        List<Client> clients = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Client client = new Client();
                
                client.setId(result.getInt("id_client"));
                client.setName(result.getString("client_name"));
                client.setLogin(result.getString("client_login"));
                client.setPassword(result.getString("client_password"));
                client.setAccessLevel(result.getInt("client_access_level"));
               
                String imageName = result.getString("client_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    client.setPerfilImage(result.getBinaryStream("client_image_perfil"), imageName);
                              
                }
               
                client.setEmail(result.getString("client_email"));
                client.setAddress(result.getString("client_address"));
                client.setCEP(result.getString("client_cep"));
                client.setPhone(result.getString("client_phone"));
                
                clients.add(client);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return clients;
    }
    
    public List<Client> search(String pesquisa){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_client WHERE client_name LIKE ? or login LIKE ?;";
        List<Client> clients = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               Client client = new Client();
                
                client.setId(result.getInt("id_client"));
                client.setName(result.getString("client_name"));
                client.setLogin(result.getString("client_login"));
                client.setPassword(result.getString("client_password"));
                client.setAccessLevel(result.getInt("client_access_level"));
               
                String imageName = result.getString("client_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    client.setPerfilImage(result.getBinaryStream("client_image_perfil"), imageName);
                              
                }
               
                client.setEmail(result.getString("client_email"));
                client.setAddress(result.getString("client_address"));
                client.setCEP(result.getString("client_cep"));
                client.setPhone(result.getString("client_phone"));
                
                clients.add(client);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return clients;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_client WHERE client_name LIKE ? or login LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            statement.setString(2, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public Client exist(Client client){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_client WHERE client_password LIKE ? and login LIKE ?;";
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+client.getPassword()+"%");
            statement.setString(2, "%"+client.getLogin()+"%");
            
             result = statement.executeQuery();
            
            while(result.next()){
                
 
                
                client.setId(result.getInt("id_client"));
                client.setName(result.getString("client_name"));
                client.setLogin(result.getString("client_login"));
                client.setPassword(result.getString("client_password"));
                client.setAccessLevel(result.getInt("client_access_level"));
               
                String imageName = result.getString("client_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    client.setPerfilImage(result.getBinaryStream("client_image_perfil"), imageName);
                              
                }
               
                client.setEmail(result.getString("client_email"));
                client.setAddress(result.getString("client_address"));
                client.setCEP(result.getString("client_cep"));
                client.setPhone(result.getString("client_phone"));

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }
    
}
