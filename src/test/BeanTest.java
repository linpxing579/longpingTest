package test;

import bean.Person;
import bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BeanTest {

    @Test
    public void testCopy() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        user.setId("1234");
        user.setName("走钢丝");

        Person person = new Person();
        BeanUtils.copyProperties(person,user);
        System.out.println(person);

        Map<String, String> map = BeanUtils.describe(user);
        System.out.println(map);
    }
}
