import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class task4 {
    public static void main(String[] args) {
        File myfile = new File("filecreate.txt");
        try {
            myfile.createNewFile(); // File create karo agar pehle se nahi hai
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            // FileWriter ka use karke file mein likhna
            FileWriter fileWriter = new FileWriter("filecreate.txt");
            fileWriter.write("this is my first file\nmy name is anurag shaw");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            // ✅ BufferedReader ka use karke file read karna
            FileReader fr = new FileReader("filecreate.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("📄 File content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Line-by-line print karo
            }

            br.close(); // BufferedReader band karo
            fr.close(); // FileReader band karo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


