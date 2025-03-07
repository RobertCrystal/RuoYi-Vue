package com.yjnb.farm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbAllowancePolicyMapper;
import com.yjnb.farm.domain.NbAllowancePolicy;
import com.yjnb.farm.service.INbAllowancePolicyService;

/**
 * 补贴政策Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbAllowancePolicyServiceImpl implements INbAllowancePolicyService 
{
    @Autowired
    private NbAllowancePolicyMapper nbAllowancePolicyMapper;

    /**
     * 查询补贴政策
     * 
     * @param id 补贴政策主键
     * @return 补贴政策
     */
    @Override
    public NbAllowancePolicy selectNbAllowancePolicyById(Long id)
    {
        return nbAllowancePolicyMapper.selectNbAllowancePolicyById(id);
    }

    /**
     * 查询补贴政策列表
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 补贴政策
     */
    @Override
    public List<NbAllowancePolicy> selectNbAllowancePolicyList(NbAllowancePolicy nbAllowancePolicy)
    {
        return nbAllowancePolicyMapper.selectNbAllowancePolicyList(nbAllowancePolicy);
    }

    /**
     * 新增补贴政策
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 结果
     */
    @Override
    public int insertNbAllowancePolicy(NbAllowancePolicy nbAllowancePolicy)
    {
        return nbAllowancePolicyMapper.insertNbAllowancePolicy(nbAllowancePolicy);
    }

    /**
     * 修改补贴政策
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 结果
     */
    @Override
    public int updateNbAllowancePolicy(NbAllowancePolicy nbAllowancePolicy)
    {
        return nbAllowancePolicyMapper.updateNbAllowancePolicy(nbAllowancePolicy);
    }

    /**
     * 批量删除补贴政策
     * 
     * @param ids 需要删除的补贴政策主键
     * @return 结果
     */
    @Override
    public int deleteNbAllowancePolicyByIds(Long[] ids)
    {
        return nbAllowancePolicyMapper.deleteNbAllowancePolicyByIds(ids);
    }

    /**
     * 删除补贴政策信息
     * 
     * @param id 补贴政策主键
     * @return 结果
     */
    @Override
    public int deleteNbAllowancePolicyById(Long id)
    {
        return nbAllowancePolicyMapper.deleteNbAllowancePolicyById(id);
    }
}
