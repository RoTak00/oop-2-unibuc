public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Creature Garden!");

        // Create 3 creatures of different types with various ranks
        Creature dragon = BeingFactory.createCreature(CreatureType.DRAGON, 3);
        Creature golem = BeingFactory.createCreature(CreatureType.GOLEM, 2);
        Creature phoenix = BeingFactory.createCreature(CreatureType.PHOENIX, 4);

        // Create 2 random monsters
        Monster monster1 = BeingFactory.createRandomMonster(3);
        Monster monster2 = BeingFactory.createRandomMonster(5);

        // Show initial status
        System.out.println("\n Creatures:");
        printStatus(dragon);
        printStatus(golem);
        printStatus(phoenix);

        System.out.println("\n Monsters:");
        printStatus(monster1);
        printStatus(monster2);

        // Simulate some damage
        System.out.println("\n The dragon takes 50 damage!");
        dragon.receiveDamage(50);
        printStatus(dragon);

        // Heal the dragon
        System.out.println("Healing the dragon by 30...");
        dragon.heal(30);
        printStatus(dragon);

        // Evolve all creatures
        System.out.println("\n Evolving creatures...");
        dragon.evolve();
        golem.evolve();
        phoenix.evolve();

        printStatus(dragon);
        printStatus(golem);
        printStatus(phoenix);

        // Simulate Phoenix dying
        System.out.println("\n Phoenix takes fatal damage!");
        phoenix.receiveDamage(1000);
        printStatus(phoenix);

        // Try to evolve the dead phoenix
        System.out.println("Trying to evolve a dead phoenix...");
        phoenix.evolve();  // should do nothing
        printStatus(phoenix);

        // Revive the phoenix
        System.out.println("Reviving the phoenix...");
        phoenix.revive();
        printStatus(phoenix);
    }

    private static void printStatus(Being being) {
        System.out.println(being.getStatus());
    }
}
