package Day5;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day5part1 {
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
        int i, j, nice=0, vowCount;
        boolean req1, req2, req3;

        for (i=0;i<lines.size();i++){
            vowCount=0;
            a=lines.get(i);
            req1=false;
            req2=false;
            req3=true;
            //check first requirement
            for(j=0;j<a.length();j++){
                if(a.charAt(j)=='a'||a.charAt(j)=='e'||a.charAt(j)=='i'||a.charAt(j)=='o'||a.charAt(j)=='u'){
                    vowCount++;
                }
                if(vowCount>=3){
                    req1 = true;
                }
            }
            //check second requirement
            for(j=0;j<a.length()-1;j++){
                if(a.charAt(j)==a.charAt(j+1))
                    req2 = true;
            }
            //check third requirement
            if (a.contains("ab")||a.contains("cd")||a.contains("pq")||a.contains("xy"))
                req3=false;

            if(req1&&req2&&req3){
                nice++;
            }
        }
        System.out.println(nice);
    }
}
