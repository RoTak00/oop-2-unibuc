package lab11.ex1;
import java.util.List;

public class Main {

    public static void main (String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        numbers.stream()
                .filter(n -> n % 3 != 0) // Pastram doar elementele care nu sunt multiplu de 3
                .map(n -> n % 5) // Aplicam modulo 5 pe toate elementele
                .distinct() // Eliminam duplicatele
                .limit(3) // Pastram doar 3 rezultate
                .toList().forEach(System.out::println); // Afisam
    }
}
