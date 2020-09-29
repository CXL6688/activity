package com.dmsd.framework.activity.example.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 活动组件配置
 * @author cao xueliang
 * @date 2020/9/29 16:41
*/
@Data
@ToString
public class ActivityComponentConfig {
    private String id;
    private String name;
    private String beanName;
}
