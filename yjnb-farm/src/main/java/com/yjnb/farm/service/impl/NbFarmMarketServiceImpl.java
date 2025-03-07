package com.yjnb.farm.service.impl;

import java.util.Date;
import java.util.List;

import com.yjnb.common.utils.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbFarmMarketMapper;
import com.yjnb.farm.domain.NbFarmMarket;
import com.yjnb.farm.service.INbFarmMarketService;

/**
 * 农贸市场Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbFarmMarketServiceImpl implements INbFarmMarketService 
{
    @Autowired
    private NbFarmMarketMapper nbFarmMarketMapper;

    /**
     * 查询农贸市场
     * 
     * @param id 农贸市场主键
     * @return 农贸市场
     */
    @Override
    public NbFarmMarket selectNbFarmMarketById(Long id)
    {
        return nbFarmMarketMapper.selectNbFarmMarketById(id);
    }

    /**
     * 查询农贸市场列表
     * 
     * @param nbFarmMarket 农贸市场
     * @return 农贸市场
     */
    @Override
    public List<NbFarmMarket> selectNbFarmMarketList(NbFarmMarket nbFarmMarket)
    {
        return nbFarmMarketMapper.selectNbFarmMarketList(nbFarmMarket);
    }

    /**
     * 新增农贸市场
     * 
     * @param nbFarmMarket 农贸市场
     * @return 结果
     */
    @Override
    public int insertNbFarmMarket(NbFarmMarket nbFarmMarket)
    {
        nbFarmMarket.setId(UniqueIdGenerator.generateUniqueId());
        nbFarmMarket.setCreatedTime(new Date());
        return nbFarmMarketMapper.insertNbFarmMarket(nbFarmMarket);
    }

    /**
     * 修改农贸市场
     * 
     * @param nbFarmMarket 农贸市场
     * @return 结果
     */
    @Override
    public int updateNbFarmMarket(NbFarmMarket nbFarmMarket)
    {
        nbFarmMarket.setUpdatedTime(new Date());
        return nbFarmMarketMapper.updateNbFarmMarket(nbFarmMarket);
    }

    /**
     * 批量删除农贸市场
     * 
     * @param ids 需要删除的农贸市场主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmMarketByIds(Long[] ids)
    {
        return nbFarmMarketMapper.deleteNbFarmMarketByIds(ids);
    }

    /**
     * 删除农贸市场信息
     * 
     * @param id 农贸市场主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmMarketById(Long id)
    {
        return nbFarmMarketMapper.deleteNbFarmMarketById(id);
    }
}
