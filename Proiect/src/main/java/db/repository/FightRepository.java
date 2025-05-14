package db.repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import db.DB;
import model.Creature;
import model.FightLogEntry;
import model.Monster;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FightRepository {

    public static void logFight(Creature creature, Monster monster, boolean victory, String historyJson) {
        String sql = """
            INSERT INTO fights (creature_id, monster_id, victory, history)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, creature.getId());
            ps.setInt(2, monster.getId());
            ps.setBoolean(3, victory);
            ps.setString(4, historyJson);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log fight: " + e.getMessage());
        }
    }

    public static List<FightLogEntry> loadAll() {
        List<FightLogEntry> fightLogs = new ArrayList<>();
        Gson gson = new Gson();

        String sql = """
            SELECT f.id, c.name AS creatureName, m.name AS monsterName, f.victory, f.history
            FROM fights f
            JOIN creatures c ON f.creature_id = c.id
            JOIN monsters m ON f.monster_id = m.id
            ORDER BY f.id DESC
        """;

        try (Connection conn = DB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String creatureName = rs.getString("creatureName");
                String monsterName = rs.getString("monsterName");
                boolean victory = rs.getBoolean("victory");
                String historyJson = rs.getString("history");

                // Parse JSON history field
                JsonObject history = gson.fromJson(historyJson, JsonObject.class);

                // Final HPs
                JsonObject finalStatus = history.getAsJsonObject("finalStatus");
                int finalCreatureHP = finalStatus.get("creatureHP").getAsInt();
                int finalMonsterHP = finalStatus.get("monsterHP").getAsInt();

                // Rounds log
                JsonArray roundsArray = history.getAsJsonArray("rounds");
                List<FightLogEntry.RoundLog> rounds = new ArrayList<>();

                for (int i = 0; i < roundsArray.size(); i++) {
                    JsonObject roundObj = roundsArray.get(i).getAsJsonObject();

                    int roundNumber = roundObj.get("round").getAsInt();
                    String creatureAction = roundObj.get("creatureAction").getAsString();
                    String monsterAction = roundObj.get("monsterAction").getAsString();

                    rounds.add(new FightLogEntry.RoundLog(roundNumber, creatureAction, monsterAction));
                }

                // Create FightLogEntry record
                FightLogEntry logEntry = new FightLogEntry(
                        id, creatureName, monsterName, victory, finalCreatureHP, finalMonsterHP, rounds);

                fightLogs.add(logEntry);
            }

        } catch (Exception e) {
            System.err.println("Failed to load fights: " + e.getMessage());
        }

        return fightLogs;
    }
}
