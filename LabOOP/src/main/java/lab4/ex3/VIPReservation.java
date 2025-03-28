package lab4.ex3;

public class VIPReservation extends Reservation {
    public int col;
    public VIPReservation(Customer customer, int col) {
        super(customer);

        this.col = col;
    }

    @Override
    public String getType() {
        return "VIP";
    }

    public void reserve(CinemaHall cinemaHall) {
        cinemaHall.bookSeat(0, col, customer);
    }
}
