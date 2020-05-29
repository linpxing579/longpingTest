package test;

import com.lpmas.framework.util.DateKit;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
}
