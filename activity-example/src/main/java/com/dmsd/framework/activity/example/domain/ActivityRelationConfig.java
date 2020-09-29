package com.dmsd.framework.activity.example.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 活动组件之间的关系
 * @author cao xueliang
 * @date 2020/9/29 16:43
*/
@Data
@ToString
public class ActivityRelationConfig {
    private String from;
    private String to;
}
