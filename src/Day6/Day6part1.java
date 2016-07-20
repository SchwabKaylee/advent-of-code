package Day6;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day6part1 {
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

        boolean on[][] = new boolean[1000][1000];
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
                            on[j][k]=true;

                        }
                    }
                }else if (a.charAt(6)=='f'){
                    for (j=initialx;j<=finalx;j++){
                        for (k=initialy;k<=finaly;k++){
                            on[j][k]=false;

                        }
                    }
                }
            } else if (a.substring(0, 6).equals("toggle")){
                for (j=initialx;j<=finalx;j++){
                    for (k=initialy;k<=finaly;k++){
                        if (on[j][k]) on[j][k] = false; else on[j][k] = true;
                    }
                }
            }
        }

        //check how many lights are on
        for (i=0;i<1000;i++){
            for (j=0;j<1000;j++){
                if (on[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
