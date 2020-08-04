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
        while (count > 6604300 || count < 6604200) {
            list = Lists.newArrayList();
            count = 0;
            for (int i = 0; i < 1216; i++) {
                int random = ThreadLocalRandom.current().nextInt(2432, 32586);
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

    @Test
    public void test5() {
        int count = 0;
        List<Integer> list = Lists.newArrayList();
        int target = 6604212;
        int left = 2432;
        int right = 32586;
        int num = 1216;
        for (int i = 0; i < num; i++) {
            int random = ThreadLocalRandom.current().nextInt(left, right);
            list.add(random);
            count += random;
        }

        System.out.println(count);
        while (count > 6604300 || count < 6604200) {
            int i = ThreadLocalRandom.current().nextInt(num);
            int original = list.get(i);
            int max = original - left;
            int min = max > left ? left : 0;
            int subValue  = ThreadLocalRandom.current().nextInt(min, max);
            if(original - subValue < left) {
                continue;
            }
            list.set(i, original - subValue);
            count -= subValue;
        }
        count = 0;
        for (Integer integer : list) {
            count+=integer;
        }
        System.out.println(count);
//        Collections.sort(list);
        System.out.println(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test6() {
        int count = 0;
        List<Integer> list = Lists.newArrayList();
        int target = 6604212;
        int left = 2432;
        int right = 32586;
        int num = 1216;
        for (int i = 0; i < num; i++) {
            int random = ThreadLocalRandom.current().nextInt(left, right);
            list.add(random);
            count += random;
        }

        System.out.println(count);
        if (count > target) {
            count = count - target;
            while (count > 0) {
                int i = ThreadLocalRandom.current().nextInt(num);
                int original = list.get(i);
                int max = original - left;
                int min = max > left ? left : 0;
                int subValue = ThreadLocalRandom.current().nextInt(min, max);
                if (count < max) {
                    subValue = count;
                }
                if (original - subValue < left) {
                    continue;
                }
                list.set(i, original - subValue);
                count -= subValue;
            }
        }else if (count < target) {
            count = target - count;
            while (count > 0) {
                int i = ThreadLocalRandom.current().nextInt(num);
                int original = list.get(i);
                int max = right - original;
                int addValue = ThreadLocalRandom.current().nextInt(0, max);
                if (count < max) {
                    addValue = count;
                }
                if (original + addValue > right) {
                    continue;
                }
                list.set(i, original + addValue);
                count -= addValue;
            }
        }
        count = 0;
        for (Integer integer : list) {
            count+=integer;
        }
        System.out.println("总数：" + count);
        System.out.println();
        System.out.println("列表：");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
