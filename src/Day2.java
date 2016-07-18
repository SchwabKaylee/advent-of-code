import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Day2 {
    public static void main(String args[]){
        int i, j, h, l, w, min, area = 0, ribbon = 0;

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Day2.txt"))){
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i=0;i<lines.size();i++){
            String[] str = lines.get(i).split("x");
            l = Integer.parseInt(str[0]);
            w = Integer.parseInt(str[1]);
            h = Integer.parseInt(str[2]);

            int[] faces = new int[3];
            faces[0] = l*w;
            faces[1] = w*h;
            faces[2] = h*l;
            min = faces[0];

            for(j=0;j<3;j++) {
                area += 2*faces[j];
                if (faces[j]<min) min = faces[j];
            }
            area += min;

            if (min==faces[0])
                ribbon += 2*(l+w);
            else if (min==faces[1])
                ribbon += 2*(w+h);
            else if (min==faces[2])
                ribbon += 2*(h+l);
            ribbon += l*w*h;
        }
        System.out.println(area);
        System.out.println(ribbon);
    }
}
