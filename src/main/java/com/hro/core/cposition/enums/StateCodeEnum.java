package com.hro.core.cposition.enums;

/**
 * 状态码枚举
 */
public enum StateCodeEnum {

    FAILURE(-100, "操作失败"),
    ERROR(-101, "发生异常"),
    SUCCESS(100, "操作成功");

    private int value;
    private String remark;

    StateCodeEnum(int value, String remark) {
        this.value = value;
        this.remark = remark;
    }


    private static StateCodeEnum[] values = values();

    public static StateCodeEnum getCode(int code) {
        for (StateCodeEnum a : values) {
            if (code == a.getValue()) return a;
        }
        return FAILURE;
    }

    public int getValue() {
        return value;
    }

    public String getRemark() {
        return remark;
    }
}
