package test;

import bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMapperTest {

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        //在反序列化时忽略在 JSON 中存在但 Java 对象不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    }

    @Test
    public void testMapper() throws IOException {

        User user = new User("2","lisy","boy");

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println("对象转json:"+jsonStr);

        User result = mapper.readValue(jsonStr,User.class);
        System.out.println("json转对象:"+result);

        List<User> list = new ArrayList<>();
        User user1 = new User("3","qweer","boy");
        list.add(user);
        list.add(user1);

        jsonStr = mapper.writeValueAsString(list);
        System.out.println("List转json:"+jsonStr);

        JavaType jsonType = mapper.getTypeFactory().constructCollectionType(ArrayList.class,User.class);
        List<User> list1 = mapper.readValue(jsonStr,jsonType);
        System.out.println("json转List:"+list1);

        Map<String,User> map = new HashMap<>();
        map.put(user.getId(),user);
        map.put(user1.getId(),user1);

        jsonStr = mapper.writeValueAsString(map);
        System.out.println("Map转json:"+jsonStr);

        MapType mapType = mapper.getTypeFactory().constructMapType(HashMap.class,String.class,User.class);

//        Map<String,User> map1 = mapper.readValues(jsonStr,mapType);
//        Map<String,User> map2 = mapper.readValues(jsonStr,  new TypeReference<Map<String, User>>() {});

        System.out.println(~1);
    }
}
