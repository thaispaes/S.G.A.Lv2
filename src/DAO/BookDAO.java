/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.ImageFile;
import Model.Book;
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
public class BookDAO {
    
     private Connection connection;
    private String sql;
    private static Book selectedBook;

    public boolean insert(Book book){
        
        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_book (book_name, book_author, book_publisher, book_stock, book_image, book_image_name, book_genre, book_acquired_date) VALUES (?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setInt(4, book.getStock());
            
            if(book.getImage()!= null){
                
                statement.setBinaryStream(5, book.getImage().getInput());
                statement.setString(6, book.getImage().getFile().getName());
            }
            
            statement.setString(7, book.getGenre());
            statement.setString(8, book.getAcquired());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(book book){
        
    connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_book book_name = ?, book_login = ?, book_password = ?, book_access_level = ?, book_image_perfil = ?,book_image_name = ? , book_email = ?, book_address = ?, book_cep = ?, book_phone = ? WHERE id_book = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, book.getName());
            statement.setString(2, book.getLogin());
            statement.setString(3, book.getPassword());
            statement.setInt(4, book.getAccessLevel());
            
            if(book.getPerfilImage() != null){
                statement.setBinaryStream(5, book.getPerfilImage().getInput());
                statement.setString(6, book.getPerfilImage().getFile().getName());
            }
            statement.setString(7, book.getEmail());
            statement.setString(8, book.getAddress());
            statement.setString(9, book.getCEP());
            statement.setString(10, book.getPhone());
            statement.setInt(12, book.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(book book){
            
    connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_book WHERE id_book = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, book.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<book> selectAll(){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book;";
        List<book> books = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                book book = new book();
                
                book.setId(result.getInt("id_book"));
                book.setName(result.getString("book_name"));
                book.setLogin(result.getString("book_login"));
                book.setPassword(result.getString("book_password"));
                book.setAccessLevel(result.getInt("book_access_level"));
               
                String imageName = result.getString("book_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    book.setPerfilImage(result.getBinaryStream("book_image_perfil"), imageName);
                              
                }
               
                book.setEmail(result.getString("book_email"));
                book.setAddress(result.getString("book_address"));
                book.setCEP(result.getString("book_cep"));
                book.setPhone(result.getString("book_phone"));
                
                books.add(book);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
    
    public List<Book> search(String method, String pesquisa){
      
        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_book WHERE book_"+method+" LIKE ?;";
        List<Book> books = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
               book book = new book();
                
                book.setId(result.getInt("id_book"));
                book.setName(result.getString("book_name"));
                book.setLogin(result.getString("book_login"));
                book.setPassword(result.getString("book_password"));
                book.setAccessLevel(result.getInt("book_access_level"));
               
                String imageName = result.getString("book_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    book.setPerfilImage(result.getBinaryStream("book_image_perfil"), imageName);
                              
                }
               
                book.setEmail(result.getString("book_email"));
                book.setAddress(result.getString("book_address"));
                book.setCEP(result.getString("book_cep"));
                book.setPhone(result.getString("book_phone"));
                
                books.add(book);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return books;
    }
    
    public boolean exist(String search){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_book WHERE book_name LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+search+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    public book exist(book book){
      
            connect();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_book WHERE book_password LIKE ? and login LIKE ?;";
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+book.getPassword()+"%");
            statement.setString(2, "%"+book.getLogin()+"%");
            
             result = statement.executeQuery();
            
            while(result.next()){
                
 
                
                book.setId(result.getInt("id_book"));
                book.setName(result.getString("book_name"));
                book.setLogin(result.getString("book_login"));
                book.setPassword(result.getString("book_password"));
                book.setAccessLevel(result.getInt("book_access_level"));
               
                String imageName = result.getString("book_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    book.setPerfilImage(result.getBinaryStream("book_image_perfil"), imageName);
                              
                }
               
                book.setEmail(result.getString("book_email"));
                book.setAddress(result.getString("book_address"));
                book.setCEP(result.getString("book_cep"));
                book.setPhone(result.getString("book_phone"));

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    private void connect() {
     
        connection = ConnectionFactory.getConnection();

    }
    
}
