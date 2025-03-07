package com.yjnb.farm.mapper;

import java.util.List;
import com.yjnb.farm.domain.NbKnowledgeExpert;

/**
 * 知识专家Mapper接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface NbKnowledgeExpertMapper 
{
    /**
     * 查询知识专家
     * 
     * @param id 知识专家主键
     * @return 知识专家
     */
    public NbKnowledgeExpert selectNbKnowledgeExpertById(Long id);

    /**
     * 查询知识专家列表
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 知识专家集合
     */
    public List<NbKnowledgeExpert> selectNbKnowledgeExpertList(NbKnowledgeExpert nbKnowledgeExpert);

    /**
     * 新增知识专家
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 结果
     */
    public int insertNbKnowledgeExpert(NbKnowledgeExpert nbKnowledgeExpert);

    /**
     * 修改知识专家
     * 
     * @param nbKnowledgeExpert 知识专家
     * @return 结果
     */
    public int updateNbKnowledgeExpert(NbKnowledgeExpert nbKnowledgeExpert);

    /**
     * 删除知识专家
     * 
     * @param id 知识专家主键
     * @return 结果
     */
    public int deleteNbKnowledgeExpertById(Long id);

    /**
     * 批量删除知识专家
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNbKnowledgeExpertByIds(Long[] ids);
}
