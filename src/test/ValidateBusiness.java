package test;

import bean.Validate;
import com.lpmas.framework.config.Constants;
import com.lpmas.framework.web.ReturnMessageBean;

import java.lang.reflect.Field;

public class ValidateBusiness {




    public static ReturnMessageBean check(Object obj) {

        ReturnMessageBean messageBean = new ReturnMessageBean();
        if (obj == null) {
            throw new NullPointerException("校验对象为空");
        }

        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            // 如果属性有注解，就进行校验
            if (!field.isAnnotationPresent(Validate.class)) {
                continue;
            }

            Validate validate = field.getAnnotation(Validate.class);
            Class<?> type = field.getType();
            if (type == Integer.class) {

            } else if (type == String.class) {

            } else if (type == Boolean.class) {

            } else if (type == long.class) {

            }



        }

        messageBean.setCode(Constants.STATUS_VALID);
        return messageBean;
    }

}
