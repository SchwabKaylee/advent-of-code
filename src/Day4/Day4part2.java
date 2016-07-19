package Day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day4part2 {
    public static void main(String args[]) throws NoSuchAlgorithmException {
        String text = "bgvyzdsv";
        boolean exit = false;
        int i;

        for(i=0; !exit; i++){
            byte[] bytes = MessageDigest.getInstance("MD5").digest((text + Integer.toString(i)).getBytes());
            String string = toHex(bytes);

            if (string.substring(0,6).equals("000000")){
                exit = true;
                System.out.println(i);
            }
        }
    }


    public static String toHex(byte[] bytes){

        BigInteger bigInt = new BigInteger(1, bytes);
        String string = bigInt.toString(16);
        while(string.length() < 32)
            string = "0" + string;
        return string;
    }
}
