package lab5.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "./assets/products.txt";
        File file = new File(path);

        String line = "";
        StringBuilder errors = new StringBuilder();

        List<Product> products = new ArrayList<>();

        try(FileReader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader))
        {

            while((line = bufferedReader.readLine()) != null)
            {
                try
                {
                    Product p = FileParser.parseProduct(line);

                    products.add(p);
                }
                catch(FileLineMalformedException | PriceInvalidException e)
                {
                    errors.append(e.getMessage());
                    errors.append("\n");
                }
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }

        for(Product p : products)
        {
            System.out.println(p.toString());
        }

        System.err.println(errors.toString());

    }
}
