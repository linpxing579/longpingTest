package test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class HongBao {


    //二倍均值法
    public List<Integer> test1(int totalAmount, int totalNumber){
        List<Integer> list = Lists.newArrayList();
        if (totalAmount <= 0 || totalNumber<= 0) {
            return list;
        }
        for (int i = totalNumber; i >= 2; i--) {
            int x = (totalAmount << 1) / i;
            int random = ThreadLocalRandom.current().nextInt(1, x);
            list.add(random);
            totalAmount -= random;
        }
        list.add(totalAmount);

        return list;
    }


    //线段分隔法
    public List<Integer> test2(int totalAmount, int totalNumber){
        List<Integer> list = Lists.newArrayList();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }
        Set<Integer> set = new HashSet<>();
        while (set.size() < totalNumber - 1) {
            int random = ThreadLocalRandom.current().nextInt(1, totalAmount);
            set.add(random);
        }

        Integer[] amounts = set.toArray(new Integer[0]);
        Arrays.sort(amounts);
        list.add(amounts[0]);
        for (int i = 1; i < amounts.length; i++) {
            list.add(amounts[i] - amounts[i - 1]);
        }
        list.add(totalAmount - amounts[amounts.length - 1]);
        return list;
    }


    @Test
    public void test(){
        List<Integer> list = test2(10, 9);
        System.out.println(list);
        for (Integer integer : list) System.out.println(new BigDecimal(integer).divide(new BigDecimal(100)));
    }
}
