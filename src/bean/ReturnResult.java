package bean;

public enum ReturnResult {

    SUCCESS(1,"成功"),
    FAIL(0,"失败");

    private int code;
    private String message;
    private Object data;

    ReturnResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ReturnResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
