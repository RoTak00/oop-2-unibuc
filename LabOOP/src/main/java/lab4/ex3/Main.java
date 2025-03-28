package lab4.ex3;

public class Main {

    public static void main(String[] args) {
        CinemaHall cinemaHall = new CinemaHall();

        Customer c1 = new Customer("Dan Popa", "danpopa@gmail.com");
        Customer c2 = new Customer("Alin Relu", "ar@gmail.com");
        Customer c3 = new Customer("Cosmin Doianu", "cos2@gmail.com");

        BookingPlanner b = new BookingPlanner(cinemaHall);

        b.addReservation(new RegularReservation(c1, 3, 4));
        b.addReservation(new VIPReservation(c2, 2));
        b.addReservation(new RegularReservation(c3, 5, 2));

        b.processReservations();
        b.printSeatingMap();

    }
}
