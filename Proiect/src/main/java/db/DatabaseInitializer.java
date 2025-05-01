package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() throws SQLException {
        Connection conn = DB.getConnection();
        Statement stmt = conn.createStatement();

        // Creatures
        stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS creatures (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100),
                        type ENUM('Dragon', 'Golem', 'Phoenix'),
                        `rank` INT,
                        max_health INT,
                        current_health INT,
                        power INT,
                        defense INT,
                        status ENUM('active', 'kicked_out', 'buried', 'evolved')
                    )
                """);

// Monsters
        stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS monsters (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100),
                        `rank` INT,
                        max_health INT,
                        power INT,
                        defense INT
                    )
                """);

// Inventory Items
        stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS inventory_items (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100),
                        description TEXT,
                        type ENUM('food', 'evolution_amulet', 'revival_amulet'),
                        power_buff INT DEFAULT 0,
                        defense_buff INT DEFAULT 0,
                        max_health_buff INT DEFAULT 0,
                        heal_amount INT DEFAULT 0,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status ENUM('active', 'discarded', 'used'),
                        creature_id INT DEFAULT NULL,
                        FOREIGN KEY (creature_id) REFERENCES creatures(id)
                    )
                """);

// Actions
        stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS actions (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        type VARCHAR(100),
                        creature_id INT DEFAULT NULL,
                        item_id INT DEFAULT NULL,
                        timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (creature_id) REFERENCES creatures(id),
                        FOREIGN KEY (item_id) REFERENCES inventory_items(id)
                    )
                """);

// Fights
        stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS fights (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        creature_id INT,
                        monster_id INT,
                        victory BOOLEAN,
                        history JSON,
                               timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (creature_id) REFERENCES creatures(id),
                        FOREIGN KEY (monster_id) REFERENCES monsters(id)
                    )
                """);


    }

    public static void reset() throws SQLException
    {
        Connection conn = DB.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM actions");
        stmt.executeUpdate("DELETE FROM fights");
        stmt.executeUpdate("DELETE FROM inventory_items");
        stmt.executeUpdate("DELETE FROM creatures");
        stmt.executeUpdate("DELETE FROM monsters");
    }
}
