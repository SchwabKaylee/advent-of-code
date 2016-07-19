package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Day2 {
    public static void main(String args[]){
        int i, j, height, length, width, min, area = 0, ribbon = 0;

        File file = new File("src/Day2/Day2.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i=0;i<lines.size();i++){
            String[] str = lines.get(i).split("x");
            length = Integer.parseInt(str[0]);
            width = Integer.parseInt(str[1]);
            height = Integer.parseInt(str[2]);

            int[] faces = new int[3];
            faces[0] = length*width;
            faces[1] = width*height;
            faces[2] = height*length;
            min = faces[0];

            for(j=0;j<3;j++) {
                area += 2*faces[j];
                if (faces[j]<min) min = faces[j];
            }
            area += min;

            if (min==faces[0])
                ribbon += 2*(length+width);
            else if (min==faces[1])
                ribbon += 2*(width+height);
            else if (min==faces[2])
                ribbon += 2*(height+length);
            ribbon += length*width*height;
        }
        System.out.println(area);
        System.out.println(ribbon);
    }
}
