package com.yjnb.farm.service;

import java.util.List;
import com.yjnb.farm.domain.NbKnowledgeCourse;

/**
 * 知识课程Service接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface INbKnowledgeCourseService 
{
    /**
     * 查询知识课程
     * 
     * @param id 知识课程主键
     * @return 知识课程
     */
    public NbKnowledgeCourse selectNbKnowledgeCourseById(Long id);

    /**
     * 查询知识课程列表
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 知识课程集合
     */
    public List<NbKnowledgeCourse> selectNbKnowledgeCourseList(NbKnowledgeCourse nbKnowledgeCourse);

    /**
     * 新增知识课程
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 结果
     */
    public int insertNbKnowledgeCourse(NbKnowledgeCourse nbKnowledgeCourse);

    /**
     * 修改知识课程
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 结果
     */
    public int updateNbKnowledgeCourse(NbKnowledgeCourse nbKnowledgeCourse);

    /**
     * 批量删除知识课程
     * 
     * @param ids 需要删除的知识课程主键集合
     * @return 结果
     */
    public int deleteNbKnowledgeCourseByIds(Long[] ids);

    /**
     * 删除知识课程信息
     * 
     * @param id 知识课程主键
     * @return 结果
     */
    public int deleteNbKnowledgeCourseById(Long id);
}
