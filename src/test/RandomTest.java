package test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    @Test
    public void test3() {
        int count = 0;
        List<Integer> list = Lists.newArrayList();
        while (count > 510015 || count < 510010) {
            list = Lists.newArrayList();
            count = 0;
            for (int i = 0; i < 20; i++) {
                int random = ThreadLocalRandom.current().nextInt(9000, 39001);
                list.add(random);
                count += random;
            }
        }
        System.out.println(count);
//        Collections.sort(list);
        System.out.println(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test4() {
        int count = 0;
        List<Integer> list = Lists.newArrayList(18965, 32951, 26537, 26318, 10310, 30725, 36083, 32665, 26913, 23015, 27973, 22674, 31105, 24692, 34221, 30686, 34398, 20061, 9999, 9721);
        for (Integer integer : list) {
            count += integer;
        }
        System.out.println(count);
    }
}
