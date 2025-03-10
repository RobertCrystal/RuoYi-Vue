package com.yjnb.farm.service;

import java.util.List;
import com.yjnb.farm.domain.NbFarmProduce;

/**
 * 农产品Service接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface INbFarmProduceService 
{
    /**
     * 查询农产品
     * 
     * @param id 农产品主键
     * @return 农产品
     */
    public NbFarmProduce selectNbFarmProduceById(Long id);

    /**
     * 查询农产品列表
     * 
     * @param nbFarmProduce 农产品
     * @return 农产品集合
     */
    public List<NbFarmProduce> selectNbFarmProduceList(NbFarmProduce nbFarmProduce);

    /**
     * 新增农产品
     * 
     * @param nbFarmProduce 农产品
     * @return 结果
     */
    public int insertNbFarmProduce(NbFarmProduce nbFarmProduce);

    /**
     * 修改农产品
     * 
     * @param nbFarmProduce 农产品
     * @return 结果
     */
    public int updateNbFarmProduce(NbFarmProduce nbFarmProduce);

    /**
     * 批量删除农产品
     * 
     * @param ids 需要删除的农产品主键集合
     * @return 结果
     */
    public int deleteNbFarmProduceByIds(Long[] ids);

    /**
     * 删除农产品信息
     * 
     * @param id 农产品主键
     * @return 结果
     */
    public int deleteNbFarmProduceById(Long id);

    /**
     * 批量推荐
     * @param ids 农产品
     * @return
     */
    public int recommendProduceByIds(Long[] ids);

    /**
     * 推荐
     * @param id
     * @return
     */
    public int recommendProduceById(Long id);
}
