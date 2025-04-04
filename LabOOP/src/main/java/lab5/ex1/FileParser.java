package lab5.ex1;

public class FileParser {
    public static Product parseProduct(String line) throws FileLineMalformedException, PriceInvalidException {
        String[] parts = line.split(",");

        if (parts.length != 3) {
            throw new FileLineMalformedException(line);
        }

        String id = parts[0];
        String name = parts[1];
        float price = Float.parseFloat(parts[2]);

        if(price < 0){
            throw new PriceInvalidException(id);
        }

        return new Product(id, name, price);
    }
}
