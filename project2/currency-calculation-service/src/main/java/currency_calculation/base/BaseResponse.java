package currency_calculation.base;

public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public BaseResponse(Boolean success, String message, T data) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(true, null, data);
    }

    public static BaseResponse<Object> error(String message) {
        return new BaseResponse<>(false, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}