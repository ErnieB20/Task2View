import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    public static void readFile(String regex) {
        try {
            int count = 0;
           // File myObj = new File(System.getProperty("user.dir")+"/2ndProject/Server.log");
            File myObj = new File("src/test/Server.log");

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(data);
                while (matcher.find())
                    count++;

            }
            myReader.close();
            System.out.println("occurrences "+count);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        readFile("500 Server Error");
        // TODO code application logic here
    }

}

