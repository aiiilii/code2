import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile2 {

    public static void main(String[] args) {
        ArrayList<String> rows = new ArrayList<String>();

        FileReader file = null;
        try {
            file = new FileReader("file");
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(file);

        String s;

        try {
            while ((s = reader.readLine()) != null) {
                rows.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(rows);

        FileWriter writer = null;
        try {
            writer = new FileWriter("/file1.txt");
            for (String cur : rows) {
                writer.write(cur + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}