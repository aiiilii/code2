import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {

    public static void main(String[] args) throws Exception {
        ArrayList<String> rows = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("/home/aili/a.txt"));
        
        String s;
        while ((s = reader.readLine()) != null) {
            rows.add(s);
        }
        Collections.sort(rows);

        FileWriter writer = new FileWriter("/home/aili/b.txt");
        for (String cur : rows) {
            writer.write(cur + "\n");
        }

        reader.close();
        writer.close();
    }
}