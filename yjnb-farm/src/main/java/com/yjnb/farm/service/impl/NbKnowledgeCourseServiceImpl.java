package com.yjnb.farm.service.impl;

import java.util.Date;
import java.util.List;
import com.yjnb.common.utils.DateUtils;
import com.yjnb.common.utils.UniqueIdGenerator;
import com.yjnb.farm.domain.vo.NbKnowledgeCourseVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbKnowledgeCourseMapper;
import com.yjnb.farm.domain.NbKnowledgeCourse;
import com.yjnb.farm.service.INbKnowledgeCourseService;

/**
 * 知识课程Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbKnowledgeCourseServiceImpl implements INbKnowledgeCourseService 
{
    @Autowired
    private NbKnowledgeCourseMapper nbKnowledgeCourseMapper;

    /**
     * 查询知识课程
     * 
     * @param id 知识课程主键
     * @return 知识课程
     */
    @Override
    public NbKnowledgeCourse selectNbKnowledgeCourseById(Long id)
    {
        return nbKnowledgeCourseMapper.selectNbKnowledgeCourseById(id);
    }

    /**
     * 查询知识课程列表
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 知识课程
     */
    @Override
    public List<NbKnowledgeCourse> selectNbKnowledgeCourseList(NbKnowledgeCourse nbKnowledgeCourse)
    {
        return nbKnowledgeCourseMapper.selectNbKnowledgeCourseList(nbKnowledgeCourse);
    }

    public List<NbKnowledgeCourseVo> selectNbKnowledgeCourseVoList(NbKnowledgeCourse nbKnowledgeCourse)
    {
        return nbKnowledgeCourseMapper.selectNbKnowledgeCourseVoList(nbKnowledgeCourse);
    }

    /**
     * 新增知识课程
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 结果
     */
    @Override
    public int insertNbKnowledgeCourse(NbKnowledgeCourse nbKnowledgeCourse)
    {
        nbKnowledgeCourse.setId(UniqueIdGenerator.generateUniqueId());
        nbKnowledgeCourse.setCreateTime(DateUtils.getNowDate());
        return nbKnowledgeCourseMapper.insertNbKnowledgeCourse(nbKnowledgeCourse);
    }

    /**
     * 修改知识课程
     * 
     * @param nbKnowledgeCourse 知识课程
     * @return 结果
     */
    @Override
    public int updateNbKnowledgeCourse(NbKnowledgeCourse nbKnowledgeCourse)
    {
        nbKnowledgeCourse.setUpdateTime(DateUtils.getNowDate());
        return nbKnowledgeCourseMapper.updateNbKnowledgeCourse(nbKnowledgeCourse);
    }

    /**
     * 批量删除知识课程
     * 
     * @param ids 需要删除的知识课程主键
     * @return 结果
     */
    @Override
    public int deleteNbKnowledgeCourseByIds(Long[] ids)
    {
        return nbKnowledgeCourseMapper.deleteNbKnowledgeCourseByIds(ids);
    }

    /**
     * 删除知识课程信息
     * 
     * @param id 知识课程主键
     * @return 结果
     */
    @Override
    public int deleteNbKnowledgeCourseById(Long id)
    {
        return nbKnowledgeCourseMapper.deleteNbKnowledgeCourseById(id);
    }
}
