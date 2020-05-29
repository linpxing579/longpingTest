package test;

import bean.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdalTest {

    private static List<Integer> list = new ArrayList<>();

    private void test(){
        list.stream().map(String::valueOf).collect(Collectors.toList());
        list.stream().map(item -> { return String.valueOf(item); }).collect(Collectors.toList());
        list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        list.stream().filter(integer -> integer != 0).collect(Collectors.toList());
    }

    public static void test1(){
        List<Integer> list = new ArrayList<>();
        list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        System.out.println(list.stream().findFirst().get());
    }

    public static void main(String[] args) {
        test1();
    }
}
