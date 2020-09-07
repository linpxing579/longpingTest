package test;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollectionsSyncTest {

    @Test
    public void test1() {
        Set<Integer> set1 = Collections.synchronizedSet(new HashSet<>());
        Set<Integer> set2 = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int start = i * 1000;
            int end = (i + 1) * 1000;
            executorService.submit(() -> {
                for (int j = start; j < end; j++) {
                    set1.add(j);
                    set2.add(j);
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("set1:" + set1.size());
        System.out.println("set2:" + set2.size());
    }

    @Test
    public void test2() {
        Map<Integer, Integer> map1 = Maps.newHashMap();
        Map<Integer, Integer> map2 = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int start = i * 1000;
            int end = (i + 1) * 1000;
            executorService.submit(() -> {
                for (int j = start; j < end; j++) {
                    map1.put(j, j);
                    map2.put(j, j);
                    map3.put(j, j);
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("map1:" + map1.size());
        System.out.println("map2:" + map2.size());
        System.out.println("map3:" + map3.size());
    }

    @Test
    public void test3() {
        Map<Integer, Integer> map1 = Maps.newHashMap();
        Map<Integer, Integer> map2 = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>();

        for (int j = 0; j < 1000; j++) {
            map1.put(j, 0);
            map2.put(j, 0);
            map3.put(j, 0);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    int orDefault = map1.getOrDefault(j, 0);
                    map1.put(j, orDefault + 1);

                    int orDefault1 = map2.getOrDefault(j, 0);
                    map2.put(j, orDefault1 + 1);

                    int orDefault2 = map3.getOrDefault(j, 0);
                    map3.put(j, orDefault2 + 1);
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collection<Integer> values = map1.values();
        values.removeAll(Collections.singletonList(10));

        Collection<Integer> values2 = map2.values();
        values2.removeAll(Collections.singletonList(10));

        Collection<Integer> values3 = map3.values();
        values3.removeAll(Collections.singletonList(10));

        System.out.println("map1:" + values.toString());
        System.out.println("map2:" + Arrays.toString(values2.toArray()));
        System.out.println("map3:" + Arrays.toString(values3.toArray()));
    }


    @Test
    public void test4() {
        Map<Integer, Integer> map1 = Maps.newHashMap();
        Map<Integer, Integer> map2 = Maps.newHashMap();

        for (int j = 0; j < 100000; j++) {
            map1.put(j, 0);
            map2.put(j, 0);
        }

        long star = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            Integer b = map1.get(i);
            if (b != null) {
                map1.put(i, b + 1);
            } else {
                map1.put(i, 1);
            }
        }
        long end = System.currentTimeMillis();
        long l = end - star;

        star = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            int orDefault = map2.getOrDefault(i, 0);
            map2.put(i, orDefault + 1);
        }
        end = System.currentTimeMillis();
        long l2 = end - star;

        System.out.println("map1:" + l);
        System.out.println("map2:" +l2);
    }


    @Test
    public void test5() {
        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    list1.add(j);
                    list2.add(j);
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list1:" + list1.size());
        System.out.println("list2:" + list2.size());
    }

    public class TempBean{
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void incr(){
            count++;
        }

        @Override
        public String toString() {
            return "TempBean{" +
                    "count=" + count +
                    '}';
        }
    }

    @Test
    public void test6(){
        Map<Integer, TempBean> map1 = new HashMap<>();

//        for (int j = 0; j < 1000; j++) {
//            map1.put(j, new TempBean());
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                int j;
                for (j = 0; j < 1000; j++) {
                    System.out.println(j);
                    TempBean integer = map1.putIfAbsent(j, new TempBean());
                    integer.incr();
//                    map1.put(j, new TempBean());
                }
                System.out.println("ss:" + j);
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = 0;
        int count1 = 0;
        for (Integer j : map1.keySet()) {
            TempBean bean = map1.get(j);
            if (bean.getCount() != 10) {
                System.out.println(j + "," +bean.toString());
                count1++;
            }
            count++;
        }
        System.out.println("map1:" + count1);
        System.out.println("map1:" + count);
        System.out.println("map1:" + map1.keySet().size());

    }
}
