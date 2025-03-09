package com.yjnb.farm.domain.vo;

import com.yjnb.farm.domain.NbKnowledgeCourse;
import lombok.Data;

@Data
public class NbKnowledgeCourseVo extends NbKnowledgeCourse {

    // 知识专家名称
    private String expertName;

    // 知识专家所属领域
    private String expertField;


}
