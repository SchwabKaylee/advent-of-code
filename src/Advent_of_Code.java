import java.util.Scanner;

/**
 * Created by Tyler on 7/18/2016.
 */
public class Advent_of_Code {
    public static void main(String args[]){
        int i, floor = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter target number:\t");
        String map = scanner.nextLine();
        for (i=0;i<map.length();i++){
            if (map.charAt(i)=='('){
                floor++;
            } else if (map.charAt(i)==')'){
                floor--;
            }
        }
        System.out.println(floor);
    }
}
