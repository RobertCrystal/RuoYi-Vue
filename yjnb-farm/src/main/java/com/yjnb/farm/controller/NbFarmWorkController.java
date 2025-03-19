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
import com.yjnb.farm.domain.NbFarmWork;
import com.yjnb.farm.service.INbFarmWorkService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 农事服务Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@Api(tags = "农事服务管理")
@RestController
@RequestMapping("/farm/work")
public class NbFarmWorkController extends BaseController
{
    @Autowired
    private INbFarmWorkService nbFarmWorkService;

    /**
     * 查询农事服务列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:list')")
    @ApiOperation(value = "查询农事服务列表")
    @GetMapping("/list")
    public TableDataInfo list(NbFarmWork nbFarmWork)
    {
        startPage();
        List<NbFarmWork> list = nbFarmWorkService.selectNbFarmWorkList(nbFarmWork);
        return getDataTable(list);
    }

    /**
     * 导出农事服务列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:export')")
    @Log(title = "农事服务", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出农事服务列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbFarmWork nbFarmWork)
    {
        List<NbFarmWork> list = nbFarmWorkService.selectNbFarmWorkList(nbFarmWork);
        ExcelUtil<NbFarmWork> util = new ExcelUtil<NbFarmWork>(NbFarmWork.class);
        util.exportExcel(response, list, "农事服务数据");
    }

    /**
     * 获取农事服务详细信息
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:query')")
    @ApiOperation(value = "获取农事服务详细信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbFarmWorkService.selectNbFarmWorkById(id));
    }

    /**
     * 新增农事服务
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:add')")
    @Log(title = "农事服务", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增农事服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "image", value = "图片", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "price", value = "价格", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "catgory", value = "分类", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "resume", value = "摘要", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "phone", value = "电话", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "weChat", value = "微信", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "providerName", value = "服务商名称", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "description", value = "描述", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "pubAccountId",value = "发布人", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "pushStatus", value = "发布状态（1发布 2未发布）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "recommend", value = "是否推荐（1推荐 2不推荐）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "browseNum", value = "浏览数量", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    })
    @PostMapping
    public AjaxResult add(@RequestBody NbFarmWork nbFarmWork)
    {
        return toAjax(nbFarmWorkService.insertNbFarmWork(nbFarmWork));
    }

    /**
     * 修改农事服务
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:edit')")
    @Log(title = "农事服务", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改农事服务")
    @PutMapping
    public AjaxResult edit(@RequestBody NbFarmWork nbFarmWork)
    {
        return toAjax(nbFarmWorkService.updateNbFarmWork(nbFarmWork));
    }

    /**
     * 删除农事服务
     */
    //@PreAuthorize("@ss.hasPermi('farm:work:remove')")
    @Log(title = "农事服务", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除农事服务")
    @ApiImplicitParam(name = "ids", value = "主键ID串", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmWorkService.deleteNbFarmWorkByIds(ids));
    }
}
