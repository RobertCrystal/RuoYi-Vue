package com.yjnb.farm.mapper;

import java.util.List;
import com.yjnb.farm.domain.NbCreditLoan;

/**
 * 信贷信息Mapper接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface NbCreditLoanMapper 
{
    /**
     * 查询信贷信息
     * 
     * @param id 信贷信息主键
     * @return 信贷信息
     */
    public NbCreditLoan selectNbCreditLoanById(Long id);

    /**
     * 查询信贷信息列表
     * 
     * @param nbCreditLoan 信贷信息
     * @return 信贷信息集合
     */
    public List<NbCreditLoan> selectNbCreditLoanList(NbCreditLoan nbCreditLoan);

    /**
     * 新增信贷信息
     * 
     * @param nbCreditLoan 信贷信息
     * @return 结果
     */
    public int insertNbCreditLoan(NbCreditLoan nbCreditLoan);

    /**
     * 修改信贷信息
     * 
     * @param nbCreditLoan 信贷信息
     * @return 结果
     */
    public int updateNbCreditLoan(NbCreditLoan nbCreditLoan);

    /**
     * 删除信贷信息
     * 
     * @param id 信贷信息主键
     * @return 结果
     */
    public int deleteNbCreditLoanById(Long id);

    /**
     * 批量删除信贷信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNbCreditLoanByIds(Long[] ids);
}
