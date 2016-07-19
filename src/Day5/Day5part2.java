package Day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day5part2 {
    public static void main(String args[]){
        File file = new File("src/Day5/Day5.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String a;
        int i, j, nice=0;
        boolean req1, req2;

        for (i=0;i<lines.size();i++){
            a=lines.get(i);
            req1=false;
            req2=false;
            //check first requirement
            for(j=0;j<a.length()-3;j++){
                if (a.substring(j+2,a.length()).contains(a.substring(j,j+2))){
                    req1 = true;
                }
            }
            //check second requirement
            for(j=0;j<a.length()-2;j++){
                if(a.charAt(j)==a.charAt(j+2)) {
                    req2 = true;
                }
            }

            if(req1&&req2){
                nice++;
            }
        }
        System.out.println(nice);
    }
}
