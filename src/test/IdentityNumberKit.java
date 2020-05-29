package test;

import java.util.Random;

public class IdentityNumberKit {

    public IdentityNumberKit() {
    }

    public static String verifyIdentityNumber(String bir) {
        Random random = new Random();
        String identityNumber = "440883" + bir + (random.nextInt(899) + 100 );

        int[] weight = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] validate = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int sum = 0;

        for (int i = 0; i < identityNumber.length(); ++i) {
            sum += Integer.parseInt(String.valueOf(identityNumber.charAt(i))) * weight[i];
        }

        int mode = sum % 11;
        return identityNumber + validate[mode];
    }


    public static void main(String[] args) {
        System.out.println(verifyIdentityNumber("19900123"));
    }
}
