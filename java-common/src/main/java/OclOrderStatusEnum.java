import lombok.Getter;

/**
 * 枚举类 试验
 * @author ydfind
 * @date 2019.10.12
 */
@Getter
public enum OclOrderStatusEnum {

    /**
     * 成功
     */
    SUCCESS("S", "成功"),

    /**
     * 失败
     */
    FAIL("F", "失败"),

    /**
     * 初始化
     */
    INITAL("I", "初始化"),

    /**
     * 渠道
     */
    CHANNEL("0", "渠道"),

    /**
     * 缓存
     */
    CACHE("1", "缓存");


    OclOrderStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;

    private String msg;

}
