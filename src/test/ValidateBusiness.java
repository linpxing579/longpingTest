package test;

import bean.Validate;
import com.lpmas.framework.config.Constants;
import com.lpmas.framework.util.ListKit;
import com.lpmas.framework.util.StringKit;
import com.lpmas.framework.web.ReturnMessageBean;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.List;

public class ValidateBusiness {

    private static final String IS_NULL_MESSAGE_FORMAT = "{0}不能为空";
    private static final String MIN_MESSAGE_FORMAT = "{0}不能小于{1}";
    private static final String MAX_MESSAGE_FORMAT = "{0}不能大于{1}";
    private static final String MIN_LENGTH_MESSAGE_FORMAT = "{0}不能少于{1}字符";
    private static final String MAX_LENGTH_MESSAGE_FORMAT = "{0}不能超过{1}字符";
    private static final String VALID_MESSAGE_FORMAT = "{0}不合法";

    private static ReturnMessageBean checkInteger(Object obj, Field field) throws IllegalAccessException {
        ReturnMessageBean messageBean = new ReturnMessageBean();
        Validate validate = field.getAnnotation(Validate.class);
        Integer value = (Integer) field.get(obj);
        String fieldName = validate.name();
        if (value < validate.min() && validate.min() != Integer.MIN_VALUE) {
            messageBean.setMessage(MessageFormat.format(MIN_MESSAGE_FORMAT, fieldName, validate.min()));
            return messageBean;
        }
        if (value > validate.max() && validate.min() != Integer.MAX_VALUE) {
            messageBean.setMessage(MessageFormat.format(MAX_MESSAGE_FORMAT, fieldName, validate.min()));
            return messageBean;
        }
        return messageBean;
    }

    private static ReturnMessageBean checkString(Object obj, Field field) throws IllegalAccessException {
        ReturnMessageBean messageBean = new ReturnMessageBean();
        Validate validate = field.getAnnotation(Validate.class);
        String value = (String) field.get(obj);
        String fieldName = validate.name();
        if (validate.isNotNull() && !StringKit.isValid(value)) {
            messageBean.setMessage(MessageFormat.format(IS_NULL_MESSAGE_FORMAT, fieldName));
            return messageBean;
        }

        if (StringKit.isValid(value)) {
            if (validate.minLength() != -1 && value.length() < validate.minLength()) {
                messageBean.setMessage(MessageFormat.format(MIN_LENGTH_MESSAGE_FORMAT, fieldName, validate.minLength()));
                return messageBean;
            }

            if (validate.maxLength() != -1 && value.length() > validate.maxLength()) {
                messageBean.setMessage(MessageFormat.format(MAX_LENGTH_MESSAGE_FORMAT, fieldName, validate.maxLength()));
                return messageBean;
            }

            if (StringKit.isValid(validate.validValue())) {
                List<String> validList = ListKit.string2List(validate.validValue(), ",");
                if (!validList.contains(value)) {
                    messageBean.setMessage(MessageFormat.format(VALID_MESSAGE_FORMAT, fieldName));
                    return messageBean;
                }
            }
        }
        return messageBean;
    }

    public static ReturnMessageBean check(Object obj) {
        if (obj == null) {
            throw new NullPointerException("校验对象为空");
        }

        ReturnMessageBean messageBean = new ReturnMessageBean();
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Validate.class)) {
                    continue;
                }
                Class<?> type = field.getType();
                if (type == Integer.class) {
                    messageBean = checkInteger(obj, field);
                } else if (type == String.class) {
                    messageBean = checkString(obj, field);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        messageBean.setCode(Constants.STATUS_VALID);
        return messageBean;
    }
}
