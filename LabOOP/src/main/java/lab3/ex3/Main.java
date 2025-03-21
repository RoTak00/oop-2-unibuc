package lab3.ex3;

public class Main {
    public static void main(String[] args) {
        Appliance[] devices = new Appliance[] {
                new Fan(50),
                new Heating(2000),
                new AC(1700),
                new SmartLock(22),
                new LightBulb(50, "green"),
                new LightBulb(50, "red"),
                new LightBulb(25, "purple")
        };

        SmartHomeController controller = SmartHomeController.getInstance(devices);
        controller.masterOn();
        controller.printStatusReport();
        controller.masterOff();
        controller.printStatusReport();
    }
}
