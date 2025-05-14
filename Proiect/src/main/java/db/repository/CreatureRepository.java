package db.repository;

import db.DB;
import model.Creature;
import model.Dragon;
import model.Golem;
import model.Phoenix;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatureRepository {

    public static List<Creature> loadAll() throws SQLException {
        List<Creature> creatures = new ArrayList<>();

        Connection conn = DB.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM creatures");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            int rank = rs.getInt("rank");
            int maxHealth = rs.getInt("max_health");
            int currentHealth = rs.getInt("current_health");
            int power = rs.getInt("power");
            int defense = rs.getInt("defense");

            Creature creature = switch (type.toLowerCase()) {
                case "dragon" -> new Dragon(name, rank, maxHealth, power, defense);
                case "golem" -> new Golem(name, rank, maxHealth, power, defense);
                case "phoenix" -> new Phoenix(name, rank, maxHealth, power, defense);
                default -> throw new IllegalArgumentException("Unknown creature type: " + type);
            };

            creature.setId(id);
            creature.receiveDamage(maxHealth - currentHealth); // set current health
            creatures.add(creature);
        }

        return creatures;
    }

    public static void saveAll(List<Creature> creatures) throws SQLException {
        Connection conn = DB.getConnection();

        for (Creature creature : creatures) {
            if (creature.getId() == null) {
                insert(conn, creature);
            } else {
                update(conn, creature);
            }
        }
    }

    public static void save(Creature creature) throws SQLException {
        Connection conn = DB.getConnection();
        insert(conn, creature);
    }

    private static void insert(Connection conn, Creature c) throws SQLException {
        String sql = """
                    INSERT INTO creatures (name, type, `rank`, max_health, current_health, power, defense, status)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fillStatement(ps, c);// current_health
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    c.setId(keys.getInt(1));
                }
            }
        }
    }

    private static void update(Connection conn, Creature c) throws SQLException {
        String sql = """
                    UPDATE creatures SET name=?, type=?, `rank`=?, max_health=?, current_health=?, power=?, defense=? 
                    WHERE id=?
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            fillStatement(ps, c);
            ps.setInt(8, c.getId());
            ps.executeUpdate();
        }
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM creatures WHERE id = ?";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to delete creature: " + e.getMessage());
        }
    }


    private static void fillStatement(PreparedStatement ps, Creature c) throws SQLException {
        ps.setString(1, c.getName());
        ps.setString(2, c.getType());
        ps.setInt(3, c.getRank());
        ps.setInt(4, c.getMaxHealth());
        ps.setInt(5, c.getCurrentHealth()); // also set in update
        ps.setInt(6, c.getPower());
        ps.setInt(7, c.getDefense());
        ps.setString(8, "active");
    }
}
