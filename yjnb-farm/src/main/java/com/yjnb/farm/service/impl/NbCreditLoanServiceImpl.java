package com.yjnb.farm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbCreditLoanMapper;
import com.yjnb.farm.domain.NbCreditLoan;
import com.yjnb.farm.service.INbCreditLoanService;

/**
 * 信贷信息Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbCreditLoanServiceImpl implements INbCreditLoanService 
{
    @Autowired
    private NbCreditLoanMapper nbCreditLoanMapper;

    /**
     * 查询信贷信息
     * 
     * @param id 信贷信息主键
     * @return 信贷信息
     */
    @Override
    public NbCreditLoan selectNbCreditLoanById(Long id)
    {
        return nbCreditLoanMapper.selectNbCreditLoanById(id);
    }

    /**
     * 查询信贷信息列表
     * 
     * @param nbCreditLoan 信贷信息
     * @return 信贷信息
     */
    @Override
    public List<NbCreditLoan> selectNbCreditLoanList(NbCreditLoan nbCreditLoan)
    {
        return nbCreditLoanMapper.selectNbCreditLoanList(nbCreditLoan);
    }

    /**
     * 新增信贷信息
     * 
     * @param nbCreditLoan 信贷信息
     * @return 结果
     */
    @Override
    public int insertNbCreditLoan(NbCreditLoan nbCreditLoan)
    {
        return nbCreditLoanMapper.insertNbCreditLoan(nbCreditLoan);
    }

    /**
     * 修改信贷信息
     * 
     * @param nbCreditLoan 信贷信息
     * @return 结果
     */
    @Override
    public int updateNbCreditLoan(NbCreditLoan nbCreditLoan)
    {
        return nbCreditLoanMapper.updateNbCreditLoan(nbCreditLoan);
    }

    /**
     * 批量删除信贷信息
     * 
     * @param ids 需要删除的信贷信息主键
     * @return 结果
     */
    @Override
    public int deleteNbCreditLoanByIds(Long[] ids)
    {
        return nbCreditLoanMapper.deleteNbCreditLoanByIds(ids);
    }

    /**
     * 删除信贷信息信息
     * 
     * @param id 信贷信息主键
     * @return 结果
     */
    @Override
    public int deleteNbCreditLoanById(Long id)
    {
        return nbCreditLoanMapper.deleteNbCreditLoanById(id);
    }
}
