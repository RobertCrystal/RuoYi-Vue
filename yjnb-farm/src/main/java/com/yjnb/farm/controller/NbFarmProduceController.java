package com.yjnb.farm.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yjnb.common.annotation.Log;
import com.yjnb.common.core.controller.BaseController;
import com.yjnb.common.core.domain.AjaxResult;
import com.yjnb.common.enums.BusinessType;
import com.yjnb.farm.domain.NbFarmProduce;
import com.yjnb.farm.service.INbFarmProduceService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 农产品Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@RestController
@RequestMapping("/farm/produce")
public class NbFarmProduceController extends BaseController
{
    @Autowired
    private INbFarmProduceService nbFarmProduceService;

    /**
     * 查询农产品列表
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:list')")
    @GetMapping("/list")
    public TableDataInfo list(NbFarmProduce nbFarmProduce)
    {
        startPage();
        List<NbFarmProduce> list = nbFarmProduceService.selectNbFarmProduceList(nbFarmProduce);
        return getDataTable(list);
    }

    /**
     * 导出农产品列表
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:export')")
    @Log(title = "农产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbFarmProduce nbFarmProduce)
    {
        List<NbFarmProduce> list = nbFarmProduceService.selectNbFarmProduceList(nbFarmProduce);
        ExcelUtil<NbFarmProduce> util = new ExcelUtil<NbFarmProduce>(NbFarmProduce.class);
        util.exportExcel(response, list, "农产品数据");
    }

    /**
     * 获取农产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbFarmProduceService.selectNbFarmProduceById(id));
    }

    /**
     * 新增农产品
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:add')")
    @Log(title = "农产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NbFarmProduce nbFarmProduce)
    {
        return toAjax(nbFarmProduceService.insertNbFarmProduce(nbFarmProduce));
    }

    /**
     * 修改农产品
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:edit')")
    @Log(title = "农产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NbFarmProduce nbFarmProduce)
    {
        return toAjax(nbFarmProduceService.updateNbFarmProduce(nbFarmProduce));
    }

    /**
     * 删除农产品
     */
    @PreAuthorize("@ss.hasPermi('farm:produce:remove')")
    @Log(title = "农产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmProduceService.deleteNbFarmProduceByIds(ids));
    }
}
