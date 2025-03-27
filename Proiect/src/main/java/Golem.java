public class Golem extends Creature {

    public Golem(String name, int rank, int maxHealth, int power, int defense) {
        super(name, rank, maxHealth, power, defense);
    }

    @Override
    public void evolve() {
        if (!isAlive()) return;

        rank += 2;
        maxHealth += 40;
        power += 2;
        defense += 15;
    }

    @Override
    public String getType() {
        return "Golem";
    }

}
