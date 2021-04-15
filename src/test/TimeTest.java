package test;

import com.lpmas.framework.util.DateKit;
import org.junit.Test;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;

public class TimeTest {


    @Test
    public void tets() {
        Calendar calendar = Calendar.getInstance();

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime dateTime = localDateTime.plusHours(-1);
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(localDate.atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        long toEpochMilli = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(toEpochMilli);
        System.out.println(DateKit.toLong(localDate.atStartOfDay()));
    }

    @Test
    public void getTime() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        String startTime = DateKit.formatDate(monday, DateKit.DEFAULT_DATE_FORMAT);

        System.out.println(today.toString());
        System.out.println(monday.toString());
        System.out.println(sunday.toString());
        System.out.println(startTime);
    }

    @Test
    public void getTestResult() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        String str = s.charAt(0) + "";
        StringBuilder result = new StringBuilder(s);
        if (result.toString().equals(result.reverse().toString())) {
            return result.toString();
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result = new StringBuilder(s.substring(i, j + 1));
                    if (result.toString().equals(result.reverse().toString()) && result.length() > str.length()) {
                        str = result.toString();
                    }
                }
            }
        }
        return str;
    }
}
