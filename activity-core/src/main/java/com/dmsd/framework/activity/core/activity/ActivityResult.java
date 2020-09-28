package com.dmsd.framework.activity.core.activity;

import lombok.ToString;

/**
 * 活动结果
 * @author cao xueliang
 * @date 2020/9/26 21:03
*/
@ToString
public class ActivityResult<T> {
    /**
     * 结果编码
     */
    private int code;
    /**
     * 错误提示
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public ActivityResult(int code, T data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ActivityResult OK(Object data){
        return new ActivityResult(Status.OK,data,"success");
    }

    public static ActivityResult OK(){
        return OK("success");
    }

    public static ActivityResult Failed(String message){
        return new ActivityResult(Status.Failed,"",message);
    }

    public static ActivityResult Failed(){
        return new ActivityResult(Status.Failed,"","");
    }

    public static class Status{
        public static int OK=0;
        public static int Failed=1;
    }
}
