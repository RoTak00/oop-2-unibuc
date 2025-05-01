package db.repository;

import db.DB;
import model.items.EvolutionAmulet;
import model.items.FoodItem;
import model.items.InventoryItem;
import model.items.RevivalAmulet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryItemRepository {

    public static List<InventoryItem> loadAll() throws SQLException, IllegalArgumentException {
        List<InventoryItem> items = new ArrayList<>();

        Connection conn = DB.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM inventory_items");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String type = rs.getString("type");
            int powerBuff = rs.getInt("power_buff");
            int defenseBuff = rs.getInt("defense_buff");
            int maxHealthBuff = rs.getInt("max_health_buff");
            int healAmount = rs.getInt("heal_amount");

            InventoryItem item;

            switch (type) {
                case "food" -> {
                    FoodItem food = new FoodItem(name, description, healAmount, powerBuff, defenseBuff, maxHealthBuff);
                    item = food;
                }
                case "evolution_amulet" -> item = new EvolutionAmulet(name, description);
                case "revival_amulet" -> item = new RevivalAmulet(name, description);
                default -> throw new IllegalArgumentException("Unknown item type: " + type);
            }

            item.setId(id);
            items.add(item);
        }


        return items;
    }

    public static void saveAll(List<InventoryItem> items) throws SQLException {
        Connection conn = DB.getConnection();
        for (InventoryItem item : items) {
            if (item.getId() == null) {
                insert(conn, item);
            } else {
                update(conn, item);
            }
        }

    }

    private static void insert(Connection conn, InventoryItem item) throws SQLException {
        String sql = """
                    INSERT INTO inventory_items (name, description, type, power_buff, defense_buff, max_health_buff, heal_amount, status)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            fillStatement(ps, item);
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getInt(1));
                }
            }
        }
    }

    private static void update(Connection conn, InventoryItem item) throws SQLException {
        String sql = """
                    UPDATE inventory_items SET name=?, description=?, type=?, power_buff=?, defense_buff=?, max_health_buff=?, heal_amount=?, status=?
                    WHERE id=?
                """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            fillStatement(ps, item);
            ps.setInt(9, item.getId());
            ps.executeUpdate();
        }
    }

    private static void fillStatement(PreparedStatement ps, InventoryItem item) throws SQLException {
        ps.setString(1, item.getName());
        ps.setString(2, item.getDescription());
        ps.setString(3, item.getType());

        if (item instanceof FoodItem food) {
            ps.setInt(4, food.getPowerBuff());
            ps.setInt(5, food.getDefenseBuff());
            ps.setInt(6, food.getMaxHealthBuff());
            ps.setInt(7, food.getHealAmount());
        } else {
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
        }

        ps.setString(8, "active");
    }
}
