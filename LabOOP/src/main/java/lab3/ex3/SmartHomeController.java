package lab3.ex3;

public class SmartHomeController {

    private Appliance[] appliances;
    private static SmartHomeController instance;

    public static SmartHomeController getInstance(Appliance[] appliances){
        if(instance == null){
            instance = new SmartHomeController(appliances);
        }
        return instance;
    }
    private SmartHomeController(Appliance[] appliances) {
        this.appliances = appliances;
    }

    public void masterOn() {
        for (Appliance a : appliances) a.turnOn();
    }

    public void masterOff() {
        for (Appliance a : appliances) a.turnOff();
    }

    public int countActive() {
        int count = 0;
        for (Appliance a : appliances) {
            if (a.getStatus()) count++;
        }
        return count;
    }

    public int totalPowerConsumption() {
        int total = 0;
        for (Appliance a : appliances) {
            if (a.getStatus()) total += a.power;
        }
        return total;
    }

    public void printStatusReport() {
        System.out.println("<-- Smart Home -->");
        System.out.println("<--   Report -->");
        for (Appliance a : appliances) {
            System.out.println(a.getType() + " - Power: " + a.power + "W - Status: " + (a.getStatus() ? "ON" : "OFF"));
        }
        System.out.println("Count ON: " + countActive());
        System.out.println("Power Consumption: " + totalPowerConsumption() + "W");
    }
}

