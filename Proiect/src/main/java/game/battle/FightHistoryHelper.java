package game.battle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Creature;
import model.Monster;

import java.util.List;

public class FightHistoryHelper {

    public static String generateFightHistoryJson(Creature creature, Monster monster, List<RoundLog> rounds) {
        Gson gson = new Gson();

        JsonObject history = new JsonObject();

        JsonArray roundsArray = new JsonArray();
        for (RoundLog round : rounds) {
            JsonObject roundObj = new JsonObject();
            roundObj.addProperty("round", round.roundNumber());
            roundObj.addProperty("creatureAction", round.creatureAction());
            roundObj.addProperty("monsterAction", round.monsterAction());
            roundsArray.add(roundObj);
        }

        history.add("rounds", roundsArray);

        JsonObject finalStatus = new JsonObject();
        finalStatus.addProperty("creatureHP", creature.getCurrentHealth());
        finalStatus.addProperty("monsterHP", monster.getCurrentHealth());

        history.add("finalStatus", finalStatus);

        return gson.toJson(history);
    }

    // Simple record class for per-round log
    public static record RoundLog(int roundNumber, String creatureAction, String monsterAction) {}
}
