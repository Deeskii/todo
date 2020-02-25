import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

import com.littleworld.todo.model.*;

public class TodoJDBCService {

    // create singleton
    private static TodoJDBCService instance = new TodoJDBCService();

    public static TodoJDBCService getInstance() {
        return instance;
    }

    private TodoJDBCService() {}

    Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Todo create(Todo todo ) {
        String sql = "INSERT INTO TODO " + "(id, task) VALUES (NULL, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, todo.getTask());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    public List<Todo> findAll() {
        String sql = "SELECT * FROM TODO";
        List<Todo> todos = new ArrayList<Todo>();
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                todos.add(new Todo(rs.getInt("id"), rs.getString("task") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public Todo findById(int id) {
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM TODO WHERE ID = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}