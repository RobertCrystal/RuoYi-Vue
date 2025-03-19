package com.yjnb.farm.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "农贸市场管理")
@RestController
@RequestMapping("/farm/market")
public class NbFarmMarketController extends BaseController
{
    @Autowired
    private INbFarmMarketService nbFarmMarketService;

    /**
     * 查询农贸市场列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:market:list')")
    @ApiOperation(value = "查询农贸市场列表")
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
    //@PreAuthorize("@ss.hasPermi('farm:market:export')")
    @Log(title = "农贸市场", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出农贸市场列表")
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
    //@PreAuthorize("@ss.hasPermi('farm:market:query')")
    @ApiOperation(value = "获取农贸市场详细信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbFarmMarketService.selectNbFarmMarketById(id));
    }

    /**
     * 新增农贸市场
     */
    //@PreAuthorize("@ss.hasPermi('farm:market:add')")
    @Log(title = "农贸市场", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增农贸市场")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "农贸市场名称", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "regionId", value = "所属区域", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    })
    @PostMapping
    public AjaxResult add(@RequestBody NbFarmMarket nbFarmMarket)
    {
        return toAjax(nbFarmMarketService.insertNbFarmMarket(nbFarmMarket));
    }

    /**
     * 修改农贸市场
     */
    //@PreAuthorize("@ss.hasPermi('farm:market:edit')")
    @Log(title = "农贸市场", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改农贸市场")
    @PutMapping
    public AjaxResult edit(@RequestBody NbFarmMarket nbFarmMarket)
    {
        return toAjax(nbFarmMarketService.updateNbFarmMarket(nbFarmMarket));
    }

    /**
     * 删除农贸市场
     */
    //@PreAuthorize("@ss.hasPermi('farm:market:remove')")
    @Log(title = "农贸市场", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除农贸市场")
    @ApiImplicitParam(name = "ids", value = "主键ID串", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmMarketService.deleteNbFarmMarketByIds(ids));
    }
}
