package model;

import java.util.List;

public record FightLogEntry(
        int id,
        String creatureName,
        String monsterName,
        boolean victory,
        int finalCreatureHP,
        int finalMonsterHP,
        List<RoundLog> rounds
) {
    public record RoundLog(int roundNumber, String creatureAction, String monsterAction) {}
}
