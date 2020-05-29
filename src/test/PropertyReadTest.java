package test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.logging.SimpleFormatter;

public class PropertyReadTest {


    public final static String FILE_NAME = "config/set";

    @Test
    public void test(){
        try {
            PropertyResourceBundle config = (PropertyResourceBundle) PropertyResourceBundle.getBundle(FILE_NAME);
            String result = config.getString("name");
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取出错"+"name");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE,1);
        calendar.add(Calendar.DATE,330/6);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(dateFormat.format(calendar.getTime()));
    }
}
