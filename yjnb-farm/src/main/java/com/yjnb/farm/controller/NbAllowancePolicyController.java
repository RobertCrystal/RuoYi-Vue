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
import com.yjnb.farm.domain.NbAllowancePolicy;
import com.yjnb.farm.service.INbAllowancePolicyService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 补贴政策Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@Api(tags = "补贴政策管理")
@RestController
@RequestMapping("/farm/policy")
public class NbAllowancePolicyController extends BaseController
{
    @Autowired
    private INbAllowancePolicyService nbAllowancePolicyService;

    /**
     * 查询补贴政策列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:list')")
    @ApiOperation(value = "查询补贴政策列表")
    @GetMapping("/list")
    public TableDataInfo list(NbAllowancePolicy nbAllowancePolicy)
    {
        startPage();
        List<NbAllowancePolicy> list = nbAllowancePolicyService.selectNbAllowancePolicyList(nbAllowancePolicy);
        return getDataTable(list);
    }

    /**
     * 导出补贴政策列表
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:export')")
    @Log(title = "补贴政策", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出补贴政策列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbAllowancePolicy nbAllowancePolicy)
    {
        List<NbAllowancePolicy> list = nbAllowancePolicyService.selectNbAllowancePolicyList(nbAllowancePolicy);
        ExcelUtil<NbAllowancePolicy> util = new ExcelUtil<NbAllowancePolicy>(NbAllowancePolicy.class);
        util.exportExcel(response, list, "补贴政策数据");
    }

    /**
     * 获取补贴政策详细信息
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:query')")
    @ApiOperation(value = "获取补贴政策详细信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbAllowancePolicyService.selectNbAllowancePolicyById(id));
    }

    /**
     * 新增补贴政策
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:add')")
    @Log(title = "补贴政策", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增补贴政策")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "author", value = "作者/来源", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "resume", value = "文章摘要", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "content", value = "正文内容", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishTime", value = "发布时间", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishStatus", value = "发布状态（1发布 2未发布）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "recommend", value = "是否推荐（1推荐 2不推荐）", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "browseNum", value = "浏览数量", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)
    })
    @PostMapping
    public AjaxResult add(@RequestBody NbAllowancePolicy nbAllowancePolicy)
    {
        return toAjax(nbAllowancePolicyService.insertNbAllowancePolicy(nbAllowancePolicy));
    }

    /**
     * 修改补贴政策
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:edit')")
    @Log(title = "补贴政策", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改补贴政策")
    @PutMapping
    public AjaxResult edit(@RequestBody NbAllowancePolicy nbAllowancePolicy)
    {
        return toAjax(nbAllowancePolicyService.updateNbAllowancePolicy(nbAllowancePolicy));
    }

    /**
     * 删除补贴政策
     */
    //@PreAuthorize("@ss.hasPermi('farm:policy:remove')")
    @Log(title = "补贴政策", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除补贴政策")
    @ApiImplicitParam(name = "ids", value = "主键ID串", required = true, dataType = "int", paramType = "path", dataTypeClass = Integer.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbAllowancePolicyService.deleteNbAllowancePolicyByIds(ids));
    }
}