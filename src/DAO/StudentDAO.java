/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.ImageFile;
import Model.Student;
import Model.User;
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
public class StudentDAO {
    
    private Connection connection;
    private String sql;
    private static Student loggedstudent;

    public boolean insert(Student student){
        
        conectar();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_student (student_name, student_login, student_password, student_registration, student_image_perfil, student_image_name , student_email , student_CEP, student_phone, student_school, student_Address, student_module, student_grade, student_course, student_shift) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, student.getName());
            statement.setString(2, student.getLogin());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getRegistration());
            
            if(student.getPerfilImage()!= null){
                
                statement.setBinaryStream(5, student.getPerfilImage().getInput());
                statement.setString(6, student.getPerfilImage().getFile().getName());
            }
            
            statement.setString(7, student.getEmail());
            statement.setString(8, student.getCEP());
            statement.setString(9, student.getPhone());
            statement.setString(10, student.getSchool());
            statement.setString(11, student.getAddress());
            statement.setString(12, student.getModule());
            statement.setString(13, student.getGrade());
            statement.setString(14, student.getCourse());
            statement.setString(15, student.getShift());
                    
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
        
    }
    
    public boolean update(Student student){
        
    conectar();
        PreparedStatement statement = null;
        sql = "UPDATE tb_student student_name = ? , student_login = ?, student_password = ?, student_registration = ?, student_image_perfil = ?, student_image_name = ?, student_email = ?,  student_CEP = ?, student_phone = ?, student_school = ?, student_Address = ?, student_module = ?, student_grade = ?, student_course = ?, student_shift = ? WHERE id_student = ?;";
        
           
          try {
              
            statement = connection.prepareStatement(sql);
            
             statement.setString(1, student.getName());
            statement.setString(2, student.getLogin());
            statement.setString(3, student.getPassword());
            statement.setString(4, student.getRegistration());
            
            if(student.getPerfilImage()!= null){
                
                statement.setBinaryStream(5, student.getPerfilImage().getInput());
                statement.setString(6, student.getPerfilImage().getFile().getName());
            }
            
            statement.setString(7, student.getEmail());
            statement.setString(8, student.getCEP());
            statement.setString(9, student.getPhone());
            statement.setString(10, student.getSchool());
            statement.setString(11, student.getAddress());
            statement.setString(12, student.getModule());
            statement.setString(13, student.getGrade());
            statement.setString(14, student.getCourse());
            statement.setString(15, student.getShift());
            statement.setInt(16, student.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
        
    }

    
    public boolean delet(Student student){
            
    conectar();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_student WHERE id_student = ?;";
        

          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, student.getId().intValue());
            
            statement.execute();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex); 
          return false;
        } finally{
              ConnectionFactory.closeConnection(connection, statement);
          }
    }
    

    public List<Student> selectAll(){
      
        conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student;";
        List<Student> students = new ArrayList<>();
   
          try {
              
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Student student = new Student();
                
                student.setId(result.getInt("id_student"));
                student.setName(result.getString("student_name"));
                student.setLogin(result.getString("student_login"));
                student.setPassword(result.getString("student_password"));
                student.setCEP(result.getString("student_CEP"));
                student.setAddress(result.getString("student_address"));
               
                String imageName = result.getString("student_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    student.setPerfilImage(result.getBinaryStream("student_image_perfil"), imageName);
                              
                }
               
                student.setEmail(result.getString("student_email"));
                student.setCourse(result.getString("student_course"));
                student.setModule(result.getString("student_module"));
                student.setPhone(result.getString("student_phone"));
                student.setSchool(result.getString("student_school"));
                student.setRegistration(result.getString("student_registration"));
                student.setGrade(result.getString("student_grade"));
                student.setSchool(result.getString("student_school"));
                student.setShift(result.getString("student_shift"));
                student.setAccessLevel(User.ACCESS_MIN);
                
                students.add(student);
            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return students;
    }
    
    public List<Student> search(String pesquisa){
      
        conectar();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM tb_student WHERE nome LIKE ? or loguin LIKE ?;";
        List<Student> students = new ArrayList<>();
       
      
          try {
              
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Student student = new Student();
                
                student.setId(result.getInt("id_student"));
                student.setName(result.getString("student_name"));
                student.setLogin(result.getString("student_login"));
                student.setPassword(result.getString("student_password"));
                student.setCEP(result.getString("student_CEP"));
                student.setAddress(result.getString("student_address"));
               
                String imageName = result.getString("student_image_name");
                
                if(ImageFile.exist(imageName) == false){
                    
                    student.setPerfilImage(result.getBinaryStream("student_image_perfil"), imageName);
                              
                }
               
                student.setEmail(result.getString("student_email"));
                student.setCourse(result.getString("student_course"));
                student.setModule(result.getString("student_module"));
                student.setPhone(result.getString("student_phone"));
                student.setSchool(result.getString("student_school"));
                student.setRegistration(result.getString("student_registration"));
                student.setGrade(result.getString("student_grade"));
                student.setSchool(result.getString("student_school"));
                student.setShift(result.getString("student_shift"));
                student.setAccessLevel(User.ACCESS_MIN);
                
                students.add(student);

            }

        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex); 
        
        } finally{
              ConnectionFactory.closeConnection(connection, statement,result);
          }
       return students;
    }
    
    public boolean exist(String pesquisa){
      
            conectar();
            PreparedStatement statement = null;
            ResultSet result = null;
            sql = "SELECT * FROM tb_student WHERE nome LIKE ? or loguin LIKE ?;";
            boolean exist = false;
            
            
        try {
            
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, "%"+pesquisa+"%");
            statement.setString(2, "%"+pesquisa+"%");
            
            result = statement.executeQuery();
            
            exist = result.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }
    
    private void conectar() {
     
        connection = ConnectionFactory.getConnection();

    }
    
    
}
