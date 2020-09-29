package com.dmsd.framework.activity.example.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 流程配置
 * @author cao xueliang
 * @date 2020/9/29 16:38
*/
@Data
@ToString
public class ActivityConfig {
    private String name;
    private List<ActivityComponentConfig> nodeList;
    private List<ActivityRelationConfig> lineList;
}
