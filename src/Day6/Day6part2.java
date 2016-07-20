package Day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day6part2 {
    public static void main(String args[]){
        File file = new File("src/Day6/Day6.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int brightness[][] = new int[1000][1000];
        int i, j, k, count=0, initialx, initialy, finalx, finaly;
        String a;

        for (i=0;i<lines.size();i++){
            a=lines.get(i);
            String[] str = a.split(",| through |turn on |turn off |toggle ");
            initialx = Integer.parseInt(str[1]);
            initialy = Integer.parseInt(str[2]);
            finalx = Integer.parseInt(str[3]);
            finaly = Integer.parseInt(str[4]);

            if (a.substring(0, 6).equals("turn o")){
                if (a.charAt(6)=='n'){
                    for (j=initialx;j<=finalx;j++){
                        for (k=initialy;k<=finaly;k++){
                            brightness[j][k]++;
                        }
                    }
                }else if (a.charAt(6)=='f'){
                    for (j=initialx;j<=finalx;j++){
                        for (k=initialy;k<=finaly;k++){
                            if(brightness[j][k]!=0)brightness[j][k]--;
                        }
                    }
                }
            } else if (a.substring(0, 6).equals("toggle")){
                for (j=initialx;j<=finalx;j++){
                    for (k=initialy;k<=finaly;k++){
                        brightness[j][k] += 2;
                    }
                }
            }
        }

        //check how many lights are on
        for (i=0;i<1000;i++){
            for (j=0;j<1000;j++){
                count += brightness[i][j];
            }
        }
        System.out.println(count);
    }
}
