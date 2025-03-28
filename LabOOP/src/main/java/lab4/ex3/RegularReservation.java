package lab4.ex3;

public class RegularReservation extends Reservation {

    public int row;
    public int col;
    public RegularReservation(Customer customer, int row, int col) {
        super(customer);

        this.row = row;
        this.col = col;
    }

    @Override
    public String getType() {
        return "Regular";
    }

    public void reserve(CinemaHall cinemaHall) {
        cinemaHall.bookSeat(row, col, customer);
    }
}
