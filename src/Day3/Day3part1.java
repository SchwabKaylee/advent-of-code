package Day3;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Day3part1 {

    public static void main(String args[]) throws FileNotFoundException {
        String text = new String();
        File file = new File("src/Day3/Day3.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            text = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean[][] visited = new boolean[2*text.length()][2*text.length()];
        visited[text.length()][text.length()] = true;
        int total=1, x=text.length(), y=text.length(), i;
        for (i=0;i<text.length();i++){
            if (text.charAt(i)=='^'){
                x++;
            } else if (text.charAt(i)=='v'){
                x--;
            } else if (text.charAt(i)=='>'){
                y++;
            } else if (text.charAt(i)=='<'){
                y--;
            }
            if (visited[x][y]==false){
                total++;
                visited[x][y]=true;
            }
        }
        System.out.println(total);
    }
}
