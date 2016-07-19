package Day4;

import java.nio.charset.StandardCharsets;

/**
 * Created by Tyler on 7/19/2016.
 */
public class Day4 {
    public static void main(String args[]) {
        String text = "bgvyzdsv";

        boolean exit = false;
        int i;
        for(i=0;exit==false;i++){
            exit = checkZeros(toHex(text+Integer.toString(i)));
        }
        System.out.println(i);
    }


    public static String toHex(String string){
        byte[] bytes = string.getBytes(StandardCharsets.US_ASCII);

        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }


    public static Boolean checkZeros(String string){
        if (string.substring(0,4)=="00000"){
            return true;
        } else {
            return false;
        }
    }
}
