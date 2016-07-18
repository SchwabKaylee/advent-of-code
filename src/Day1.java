import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Day1 {
    public static void main(String args[]){
        int i, floor = 0, c = 0;
        boolean basement = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter text:\t");
        String text = scanner.nextLine();

        for (i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                floor++;
            } else if (text.charAt(i) == ')') {
                floor--;
            }
            c++;
            while(floor==-1&&!basement){
                System.out.println(c);
                basement=true;
            }
        }
        System.out.println(floor);
    }

}