package test;

import com.lpmas.framework.util.DateKit;
import com.lpmas.framework.util.NumberKit;

import java.util.Random;

public class OrderIdUtil {


    private static String genernate(String type, int userId, int serialNumber){
        String currentDateTime = DateKit.getCurrentDateTime("yyyyMMddHHmm");

        Random random = new Random();
        int rand = random.nextInt(999);

        String userIdStr = NumberKit.fillPreZero(userId << 2, 8);
        String serialNumberStr = NumberKit.fillPreZero(serialNumber, 2);
        return type + currentDateTime + userIdStr + serialNumberStr + NumberKit.fillPreZero(rand, 3);
    }

    public static void main(String[] args) {
        System.out.println(genernate("A",578, 1));
        System.out.println(578 << 2);
        System.out.println(2312 << 2);
        System.out.println(20000000 << 2);
    }
}
