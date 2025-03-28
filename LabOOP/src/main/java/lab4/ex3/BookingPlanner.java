package lab4.ex3;

public class BookingPlanner implements Bookable {

    Reservation[] reservations;
    CinemaHall cinemaHall;
    int lastReservationIndex = 0;

    BookingPlanner(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;

        this.reservations = new Reservation[cinemaHall.seats.length * cinemaHall.seats[0].length];
    }

    public void processReservations()
    {
        for(int i = 0; i < lastReservationIndex; i++)
        {
            reservations[i].reserve(cinemaHall);
        }
    }

    public void addReservation(Reservation reservation) {
        if(lastReservationIndex == reservations.length) return;

        reservations[lastReservationIndex] = reservation;
        lastReservationIndex++;
    }

    public void printSeatingMap()
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < cinemaHall.seats.length; i++) {
            for (int j = 0; j <  cinemaHall.seats[0].length; j++) {
                builder.append("[" + ( cinemaHall.seats[i][j].isBooked() ? "X" : " ") + "] ");
            }

            builder.append("Row " + Character.toString((char)('A' + i)) + "\n");
        }

        System.out.print(builder.toString());
    }


}
