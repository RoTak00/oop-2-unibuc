package db.repository;

import db.DB;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void create(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getName());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    user.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
    }

    public static void update(User user) {
        if (user.getId() == null) {
            System.err.println("Cannot update user without ID.");
            return;
        }

        String sql = "UPDATE users SET name = ? WHERE id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to update user: " + e.getMessage());
        }
    }

    public static List<User> loadAll() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(rs.getString("name"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("Failed to load users: " + e.getMessage());
        }

        return users;
    }
}
