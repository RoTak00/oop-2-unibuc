package lab4.ex3;

public abstract class Reservation {

    public Customer customer;

    public abstract String getType();
    public abstract void reserve(CinemaHall cinemaHall);

    public Reservation(Customer customer) {
        this.customer = customer;
    }
}
