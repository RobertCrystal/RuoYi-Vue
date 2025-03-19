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
@Api(tags = "农产品管理")
@RestController
@RequestMapping("/farm/produce")
public class NbFarmProduceController extends BaseController
{
    @Autowired
    private INbFarmProduceService nbFarmProduceService;

    /**
     * 查询农产品列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:produce:list')")
    @ApiOperation(value = "查询农产品列表")
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
    //@PreAuthorize("@ss.hasPermi('farm:produce:export')")
    @Log(title = "农产品", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出农产品列表")
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
    //@PreAuthorize("@ss.hasPermi('farm:produce:query')")
    @ApiOperation(value = "获取农产品详细信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbFarmProduceService.selectNbFarmProduceById(id));
    }

    /**
     * 新增农产品
     */
    //@PreAuthorize("@ss.hasPermi('farm:produce:add')")
    @Log(title = "农产品", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增农产品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "农产品名称",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "image", value = "农产品图片", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "resume", value = "卖点摘要",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "catgory", value = "所属品类", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "produceType", value = "农产品类型",required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "provideName", value = "所属商户", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "price", value = "价格", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "pushStatus", value = "上架状态（1上架 2下架）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "recommend", value = "推荐状态（1推荐 2不推荐）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "description", value = "产品详情", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "accountId", value = "创建人", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "browseNum", value = "浏览量", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
    })
    @PostMapping
    public AjaxResult add(@RequestBody NbFarmProduce nbFarmProduce)
    {
        return toAjax(nbFarmProduceService.insertNbFarmProduce(nbFarmProduce));
    }

    /**
     * 修改农产品
     */
    //@PreAuthorize("@ss.hasPermi('farm:produce:edit')")
    @Log(title = "农产品", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改农产品")
    @PutMapping
    public AjaxResult edit(@RequestBody NbFarmProduce nbFarmProduce)
    {
        return toAjax(nbFarmProduceService.updateNbFarmProduce(nbFarmProduce));
    }

    /**
     * 删除农产品
     */
    //@PreAuthorize("@ss.hasPermi('farm:produce:remove')")
    @Log(title = "农产品", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除农产品")
    @ApiImplicitParam(name = "ids", value = "主键ID串", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmProduceService.deleteNbFarmProduceByIds(ids));
    }

    /**
     * 推荐农产品
     */
    @ApiOperation(value = "推荐农产品")
    @PutMapping("/recommend/{ids}")
    public AjaxResult recommendProduce(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmProduceService.recommendProduceByIds(ids));
    }

    /**
     * 取消推荐农产品
     */
    @ApiOperation(value = "取消推荐农产品")
    @PutMapping("/not-recommend/{ids}")
    public AjaxResult notRecommendProduce(@PathVariable Long[] ids)
    {
        return toAjax(nbFarmProduceService.notRecommendProduceByIds(ids));
    }
}
