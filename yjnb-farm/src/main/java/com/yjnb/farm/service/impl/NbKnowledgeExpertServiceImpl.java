package com.yjnb.farm.service.impl;

import java.util.Date;
import java.util.List;

import com.yjnb.common.utils.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbKnowledgeExpertMapper;
import com.yjnb.farm.domain.NbKnowledgeExpert;
import com.yjnb.farm.service.INbKnowledgeExpertService;

/**
 * 知识专家Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbKnowledgeExpertServiceImpl implements INbKnowledgeExpertService 
{
    @Autowired
    private NbKnowledgeExpertMapper nbKnowledgeExpertMapper;

    /**
     * 查询知识专家
     * 
     * @param id 知识专家主键
     * @return 知识专家
     */
    @Override
    public NbKnowledgeExpert selectNbKnowledgeExpertById(Long id)
    {
        return nbKnowledgeExpertMapper.selectNbKnowledgeExpertById(id);
    }

    /**
     * 查询知识专家列表
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 知识专家
     */
    @Override
    public List<NbKnowledgeExpert> selectNbKnowledgeExpertList(NbKnowledgeExpert nbKnowledgeExpert)
    {
        return nbKnowledgeExpertMapper.selectNbKnowledgeExpertList(nbKnowledgeExpert);
    }

    /**
     * 新增知识专家
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 结果
     */
    @Override
    public int insertNbKnowledgeExpert(NbKnowledgeExpert nbKnowledgeExpert)
    {
        nbKnowledgeExpert.setId(UniqueIdGenerator.generateUniqueId());
        nbKnowledgeExpert.setCreatedTime(new Date());
        return nbKnowledgeExpertMapper.insertNbKnowledgeExpert(nbKnowledgeExpert);
    }

    /**
     * 修改知识专家
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 结果
     */
    @Override
    public int updateNbKnowledgeExpert(NbKnowledgeExpert nbKnowledgeExpert)
    {
        nbKnowledgeExpert.setUpdatedTime(new Date());
        return nbKnowledgeExpertMapper.updateNbKnowledgeExpert(nbKnowledgeExpert);
    }

    /**
     * 批量删除知识专家
     * 
     * @param ids 需要删除的知识专家主键
     * @return 结果
     */
    @Override
    public int deleteNbKnowledgeExpertByIds(Long[] ids)
    {
        return nbKnowledgeExpertMapper.deleteNbKnowledgeExpertByIds(ids);
    }

    /**
     * 删除知识专家信息
     * 
     * @param id 知识专家主键
     * @return 结果
     */
    @Override
    public int deleteNbKnowledgeExpertById(Long id)
    {
        return nbKnowledgeExpertMapper.deleteNbKnowledgeExpertById(id);
    }
}
