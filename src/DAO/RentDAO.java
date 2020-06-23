/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Book;
import Model.User;
import Model.Rent;
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
public class RentDAO {

    private Connection connection;
    private String sql;
    private static Rent selectedRent;
    private String imageName;
    
    public boolean insert(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "INSERT INTO tb_rent (rented_date, id_of_book, id_of_student, id_of_client, rent_returned, rent_penality, rent_observation) VALUES (?,?,?,?,?,?,?);";

        try {

            statement = connection.prepareStatement(sql);

            statement.setDate(1, rent.getRented().getDateSql());
            statement.setInt(2, rent.getBook().getId().intValue());
            statement.setInt(3, rent.getStudent().getId().intValue());
            statement.setInt(4, rent.getClient().getId().intValue());
            statement.setDate(6, rent.getReturnDate().getDateSql());
            statement.setBoolean(7, rent.isReturned());
            statement.setDouble(8, rent.getPenality());
            statement.setString(9, rent.getObrservation());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean update(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "UPDATE tb_rent SET rented_date = ?, id_of_book = ?, id_of_student = ?, id_of_client = ?, rent_returned = ?, rent_penality = ?, rent_observation = ? WHERE id_rent = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setDate(1, rent.getRented().getDateSql());
            statement.setInt(2, rent.getBook().getId().intValue());
            statement.setInt(3, rent.getStudent().getId().intValue());
            statement.setInt(4, rent.getClient().getId().intValue());
            statement.setDate(6, rent.getReturnDate().getDateSql());
            statement.setBoolean(7, rent.isReturned());
            statement.setDouble(8, rent.getPenality());
            statement.setString(9, rent.getObrservation());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public boolean delet(Rent rent) {

        connect();
        PreparedStatement statement = null;
        sql = "DELETE FROM tb_rent WHERE id_rent = ?;";

        try {

            statement = connection.prepareStatement(sql);

            statement.setInt(1, rent.getId().intValue());

            statement.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Rent> selectAll() {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view;";
        List<Rent> rents = new ArrayList<>();
        String imageName = "";

        try {

            statement = connection.prepareStatement(sql);

            result = statement.executeQuery();

            while (result.next()) {

                Rent rent = new Rent();

                rent.setId(result.getInt("id_rent"));
                rent.setRented(result.getDate("return_date"));
                rent.setReturnDate(result.getDate("return_date"));
                rent.setReturned(result.getBoolean("rent_returned"));
                rent.setPenality(result.getDouble("rent_penality"));
                rent.setObrservation(result.getString("rent_observation"));

                Book book = new Book();

                book.setId(result.getInt("id_book"));
                book.setName(result.getString("book_name"));
                book.setAuthor(result.getString("book_author"));
                book.setPublisher(result.getString("book_publisher"));
                book.setStock(result.getInt("book_stock"));

                imageName = result.getString("book_image_name");

                if (ImageFile.exist(imageName) == false) {

                    book.setImage(result.getBinaryStream("book_image_perfil"), imageName);

                }

                book.setGenre(result.getString("book_genre"));
                book.setAcquired(result.getDate("book_acquired_date"));

                rent.setBook(book);

                if (result.getInt("id_student") != 0) {
                    Student student = new Student();

                    student.setId(result.getInt("id_student"));
                    student.setName(result.getString("student_name"));
                    student.setLogin(result.getString("student_login"));
                    student.setPassword(result.getString("student_password"));
                    student.setCEP(result.getString("student_CEP"));
                    student.setAddress(result.getString("student_address"));

                    imageName = result.getString("student_image_name");

                    if (ImageFile.exist(imageName) == false) {

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

                    rent.setStudent(student);
                }

                if (result.getInt("id_student") != 0) {
                    User client = new User();

                    client.setId(result.getInt("id_client"));
                    client.setName(result.getString("client_name"));
                    client.setLogin(result.getString("client_login"));
                    client.setPassword(result.getString("client_password"));
                    client.setAccessLevel(result.getInt("client_access_level"));

                    imageName = result.getString("client_image_name");

                    if (ImageFile.exist(imageName) == false) {

                        client.setPerfilImage(result.getBinaryStream("client_image_perfil"), imageName);

                    }

                    client.setEmail(result.getString("client_email"));
                    client.setAddress(result.getString("client_address"));
                    client.setCEP(result.getString("client_cep"));
                    client.setPhone(result.getString("client_phone"));
                    client.setAccessLevel(User.ACCESS_MIN);

                    rent.setClient(client);
                }

                rents.add(rent);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return rents;
    }

    public List<Rent> search(String method, String search) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view WHERE " + method + " LIKE ?;";
        List<Rent> rents = new ArrayList<>();

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            result = statement.executeQuery();

            while (result.next()) {

                Rent rent = new Rent();

                rent.setId(result.getInt("id_rent"));
                rent.setRented(result.getDate("return_date"));
                rent.setReturnDate(result.getDate("return_date"));
                rent.setReturned(result.getBoolean("rent_returned"));
                rent.setPenality(result.getDouble("rent_penality"));
                rent.setObrservation(result.getString("rent_observation"));

                Book book = new Book();

                book.setId(result.getInt("id_book"));
                book.setName(result.getString("book_name"));
                book.setAuthor(result.getString("book_author"));
                book.setPublisher(result.getString("book_publisher"));
                book.setStock(result.getInt("book_stock"));

                imageName = result.getString("book_image_name");

                if (ImageFile.exist(imageName) == false) {

                    book.setImage(result.getBinaryStream("book_image_perfil"), imageName);

                }

                book.setGenre(result.getString("book_genre"));
                book.setAcquired(result.getDate("book_acquired_date"));

                rent.setBook(book);

                if (result.getInt("id_student") != 0) {
                    Student student = new Student();

                    student.setId(result.getInt("id_student"));
                    student.setName(result.getString("student_name"));
                    student.setLogin(result.getString("student_login"));
                    student.setPassword(result.getString("student_password"));
                    student.setCEP(result.getString("student_CEP"));
                    student.setAddress(result.getString("student_address"));

                    imageName = result.getString("student_image_name");

                    if (ImageFile.exist(imageName) == false) {

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

                    rent.setStudent(student);
                }

                if (result.getInt("id_student") != 0) {
                    User client = new User();

                    client.setId(result.getInt("id_client"));
                    client.setName(result.getString("client_name"));
                    client.setLogin(result.getString("client_login"));
                    client.setPassword(result.getString("client_password"));
                    client.setAccessLevel(result.getInt("client_access_level"));

                    imageName = result.getString("client_image_name");

                    if (ImageFile.exist(imageName) == false) {

                        client.setPerfilImage(result.getBinaryStream("client_image_perfil"), imageName);

                    }

                    client.setEmail(result.getString("client_email"));
                    client.setAddress(result.getString("client_address"));
                    client.setCEP(result.getString("client_cep"));
                    client.setPhone(result.getString("client_phone"));
                    client.setAccessLevel(User.ACCESS_MIN);

                    rent.setClient(client);
                }

                rents.add(rent);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesqisar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return rents;
    }

    public boolean exist(String search) {

        connect();
        PreparedStatement statement = null;
        ResultSet result = null;
        sql = "SELECT * FROM data_of_rents_view WHERE book_name LIKE ? or student_name LIKE ? or client_name LIKE ?;";
        boolean exist = false;

        try {

            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            result = statement.executeQuery();

            exist = result.next();

        } catch (SQLException ex) {
            Logger.getLogger(RentDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return exist;
    }

    private void connect() {

        connection = ConnectionFactory.getConnection();

    }

}
