package com.yjnb.farm.mapper;

import java.util.List;
import com.yjnb.farm.domain.NbFarmMarket;

/**
 * 农贸市场Mapper接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface NbFarmMarketMapper 
{
    /**
     * 查询农贸市场
     * 
     * @param id 农贸市场主键
     * @return 农贸市场
     */
    public NbFarmMarket selectNbFarmMarketById(Long id);

    /**
     * 查询农贸市场列表
     * 
     * @param nbFarmMarket 农贸市场
     * @return 农贸市场集合
     */
    public List<NbFarmMarket> selectNbFarmMarketList(NbFarmMarket nbFarmMarket);

    /**
     * 新增农贸市场
     * 
     * @param nbFarmMarket 农贸市场
     * @return 结果
     */
    public int insertNbFarmMarket(NbFarmMarket nbFarmMarket);

    /**
     * 修改农贸市场
     * 
     * @param nbFarmMarket 农贸市场
     * @return 结果
     */
    public int updateNbFarmMarket(NbFarmMarket nbFarmMarket);

    /**
     * 删除农贸市场
     * 
     * @param id 农贸市场主键
     * @return 结果
     */
    public int deleteNbFarmMarketById(Long id);

    /**
     * 批量删除农贸市场
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNbFarmMarketByIds(Long[] ids);
}
