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
import com.yjnb.farm.domain.NbFarmMarket;
import com.yjnb.farm.service.INbFarmMarketService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 农贸市场Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@RestController
@RequestMapping("/farm/market")
public class NbFarmMarketController extends BaseController
{
    @Autowired
    private INbFarmMarketService nbFarmMarketService;

    /**
     * 查询农贸市场列表
     */
    @PreAuthorize("@ss.hasPermi('farm:market:list')")
    @GetMapping("/list")
    public TableDataInfo list(NbFarmMarket nbFarmMarket)
    {
        startPage();
        List<NbFarmMarket> list = nbFarmMarketService.selectNbFarmMarketList(nbFarmMarket);
        return getDataTable(list);
    }

    /**
     * 导出农贸市场列表
     */
    @PreAuthorize("@ss.hasPermi('farm:market:export')")
    @Log(title = "农贸市场", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbFarmMarket nbFarmMarket)
    {
        List<NbFarmMarket> list = nbFarmMarketService.selectNbFarmMarketList(nbFarmMarket);
        ExcelUtil<NbFarmMarket> util = new ExcelUtil<NbFarmMarket>(NbFarmMarket.class);
        util.exportExcel(response, list, "农贸市场数据");
    }

    /**
     * 获取农贸市场详细信息
     */
    @PreAuthorize("@ss.hasPermi('farm:market:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbFarmMarketService.selectNbFarmMarketById(id));
    }

    /**
     * 新增农贸市场
     */
    @PreAuthorize("@ss.hasPermi('farm:market:add')")
    @Log(title = "农贸市场", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NbFarmMarket nbFarmMarket)
    {
        return toAjax(nbFarmMarketService.insertNbFarmMarket(nbFarmMarket));
    }

    /**
     * 修改农贸市场
     */
    @PreAuthorize("@ss.hasPermi('farm:market:edit')")
    @Log(title = "农贸市场", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NbFarmMarket nbFarmMarket)
    {
        return toAjax(nbFarmMarketService.updateNbFarmMarket(nbFarmMarket));
    }

    /**
     * 删除农贸市场
     */
    @PreAuthorize("@ss.hasPermi('farm:market:remove')")
    @Log(title = "农贸市场", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmMarketService.deleteNbFarmMarketByIds(ids));
    }
}
