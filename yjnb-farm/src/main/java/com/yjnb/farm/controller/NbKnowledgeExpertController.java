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
import com.yjnb.farm.domain.NbKnowledgeExpert;
import com.yjnb.farm.service.INbKnowledgeExpertService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 知识专家Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@Api(tags = "知识专家管理")
@RestController
@RequestMapping("/farm/expert")
public class NbKnowledgeExpertController extends BaseController
{
    @Autowired
    private INbKnowledgeExpertService nbKnowledgeExpertService;

    /**
     * 查询知识专家列表
     */
    ////@PreAuthorize("@ss.hasPermi('farm:expert:list')")
    @ApiOperation(value = "查询知识专家列表")
    @GetMapping("/list")
    public TableDataInfo list(NbKnowledgeExpert nbKnowledgeExpert)
    {
        startPage();
        List<NbKnowledgeExpert> list = nbKnowledgeExpertService.selectNbKnowledgeExpertList(nbKnowledgeExpert);
        return getDataTable(list);
    }

    /**
     * 导出知识专家列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:expert:export')")
    @Log(title = "知识专家", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出知识专家列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbKnowledgeExpert nbKnowledgeExpert)
    {
        List<NbKnowledgeExpert> list = nbKnowledgeExpertService.selectNbKnowledgeExpertList(nbKnowledgeExpert);
        ExcelUtil<NbKnowledgeExpert> util = new ExcelUtil<NbKnowledgeExpert>(NbKnowledgeExpert.class);
        util.exportExcel(response, list, "知识专家数据");
    }

    /**
     * 获取知识专家详细信息
     */
    //@PreAuthorize("@ss.hasPermi('farm:expert:query')")
    @ApiOperation(value = "获取知识专家详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbKnowledgeExpertService.selectNbKnowledgeExpertById(id));
    }

    /**
     * 新增知识专家
     */
    //@PreAuthorize("@ss.hasPermi('farm:expert:add')")
    @Log(title = "知识专家", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增知识专家")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "专家姓名", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "fieldCode", value = "所属领域", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "description", value = "专家简介", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "image", value = "专家头像", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "organization", value = "所属机构", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "levelCode", value = "专家级别", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishTime", value = "发布时间", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishStatus", value = "发布状态（1发布 2未发布）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "recommend", value = "是否推荐（1推荐 2不推荐）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "browseNum", value = "浏览数量", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    })
    @PostMapping
    public AjaxResult add(@RequestBody NbKnowledgeExpert nbKnowledgeExpert)
    {
        return toAjax(nbKnowledgeExpertService.insertNbKnowledgeExpert(nbKnowledgeExpert));
    }

    /**
     * 修改知识专家
     */
    //@PreAuthorize("@ss.hasPermi('farm:expert:edit')")
    @Log(title = "知识专家", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改知识专家")
    @PutMapping
    public AjaxResult edit(@RequestBody NbKnowledgeExpert nbKnowledgeExpert)
    {
        return toAjax(nbKnowledgeExpertService.updateNbKnowledgeExpert(nbKnowledgeExpert));
    }

    /**
     * 删除知识专家
     */
    //@PreAuthorize("@ss.hasPermi('farm:expert:remove')")
    @Log(title = "知识专家", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除知识专家")
    @ApiImplicitParam(name = "ids", value = "主键ID串", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbKnowledgeExpertService.deleteNbKnowledgeExpertByIds(ids));
    }
}
