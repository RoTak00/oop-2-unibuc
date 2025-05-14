package db.repository;

import db.DB;
import model.Monster;

import java.sql.*;

public class MonsterRepository {

    public static void create(Monster monster) {
        String sql = """
            INSERT INTO monsters (name, `rank`, max_health, power, defense)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, monster.getName());
            ps.setInt(2, monster.getRank());
            ps.setInt(3, monster.getMaxHealth());
            ps.setInt(4, monster.getPower());
            ps.setInt(5, monster.getDefense());

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    monster.setId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Failed to insert monster: " + e.getMessage());
        }
    }
}
