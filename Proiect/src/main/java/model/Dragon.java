package model;

public class Dragon extends Creature {

    public Dragon(String name, int rank, int maxHealth, int power, int defense) {
        super(name, rank, maxHealth, power, defense);
    }

    @Override
    public void evolve() {
        if (!isAlive()) return;

        rank += 2;
        maxHealth += 30;
        power += 10;
        defense += 5;
    }

    @Override
    public String getType() {
        return "Dragon";
    }

}
