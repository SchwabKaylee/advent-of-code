import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Day3 {
    ArrayList<String> lines = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader("Day3.txt"))){
        String line;
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
