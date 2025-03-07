package com.yjnb.farm.mapper;

import java.util.List;
import com.yjnb.farm.domain.NbAllowancePolicy;

/**
 * 补贴政策Mapper接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface NbAllowancePolicyMapper 
{
    /**
     * 查询补贴政策
     * 
     * @param id 补贴政策主键
     * @return 补贴政策
     */
    public NbAllowancePolicy selectNbAllowancePolicyById(Long id);

    /**
     * 查询补贴政策列表
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 补贴政策集合
     */
    public List<NbAllowancePolicy> selectNbAllowancePolicyList(NbAllowancePolicy nbAllowancePolicy);

    /**
     * 新增补贴政策
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 结果
     */
    public int insertNbAllowancePolicy(NbAllowancePolicy nbAllowancePolicy);

    /**
     * 修改补贴政策
     * 
     * @param nbAllowancePolicy 补贴政策
     * @return 结果
     */
    public int updateNbAllowancePolicy(NbAllowancePolicy nbAllowancePolicy);

    /**
     * 删除补贴政策
     * 
     * @param id 补贴政策主键
     * @return 结果
     */
    public int deleteNbAllowancePolicyById(Long id);

    /**
     * 批量删除补贴政策
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNbAllowancePolicyByIds(Long[] ids);
}
