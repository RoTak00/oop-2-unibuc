package lab4.ex3;

public class CinemaHall {

    Seat[][] seats;

    public CinemaHall() {
        seats = new Seat[6][6];

        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[0].length; j++) {

                char letter = (char)('A' + i);
                seats[i][j] = new Seat(false, Character.toString(letter) + (j + 1), null);
            }
        }
    }

    public void bookSeat(int row, int col, Customer customer)
    {
        if(!seats[row][col].isBooked())
        {
            char letter = (char)('A' + row);

            seats[row][col] = new Seat(true, Character.toString(letter) + (col + 1), customer);
        }
    }


}
