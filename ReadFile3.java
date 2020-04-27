import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile3 {

    public String loader(String FilePath) {
        BufferedReader br = null;
        String str = null;
        StringBuilder sb = new StringBuilder();
    
        try {
            br = new BufferedReader(new FileReader(FilePath));
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        } catch (FileNotFoundException f) {
            System.out.println(FilePath + " does not exist");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try{
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public String loader1(String FilePath) {
        String str = null;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            while ((str = br.readLine()) != null) {
                sb.append(str).append("\n");
            }
        } catch (FileNotFoundException f) {
            System.out.println(FilePath + " does not exist");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}