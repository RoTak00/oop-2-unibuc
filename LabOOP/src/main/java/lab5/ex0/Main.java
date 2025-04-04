package lab5.ex0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("./assets/file.txt");

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

    public static String StringReadCharByChar(File file) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;


        fileReader = new FileReader(file);

        int c;

        while((c = fileReader.read()) != -1) {
            sb.append((char)c);
        }

        fileReader.close();
        return sb.toString();
    }


}
