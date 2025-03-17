package com.yjnb.farm.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.yjnb.farm.domain.vo.NbKnowledgeCourseVo;
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
import com.yjnb.farm.domain.NbKnowledgeCourse;
import com.yjnb.farm.service.INbKnowledgeCourseService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 知识课程Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@Api(tags = "知识课程管理")
@RestController
@RequestMapping("/farm/course")
public class NbKnowledgeCourseController extends BaseController
{
    @Autowired
    private INbKnowledgeCourseService nbKnowledgeCourseService;

    /**
     * 查询知识课程列表
     */
    @PreAuthorize("@ss.hasPermi('farm:course:list')")
    @ApiOperation(value = "查询知识课程列表")
    @GetMapping("/list")
    public TableDataInfo list(NbKnowledgeCourse nbKnowledgeCourse)
    {
        startPage();
//        List<NbKnowledgeCourse> list = nbKnowledgeCourseService.selectNbKnowledgeCourseList(nbKnowledgeCourse);
        List<NbKnowledgeCourseVo> list = nbKnowledgeCourseService.selectNbKnowledgeCourseVoList(nbKnowledgeCourse);
        return getDataTable(list);
    }

    /**
     * 导出知识课程列表
     */
    @PreAuthorize("@ss.hasPermi('farm:course:export')")
    @Log(title = "知识课程", businessType = BusinessType.EXPORT)
    @ApiOperation(value = "导出知识课程列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbKnowledgeCourse nbKnowledgeCourse)
    {
        List<NbKnowledgeCourse> list = nbKnowledgeCourseService.selectNbKnowledgeCourseList(nbKnowledgeCourse);
        ExcelUtil<NbKnowledgeCourse> util = new ExcelUtil<NbKnowledgeCourse>(NbKnowledgeCourse.class);
        util.exportExcel(response, list, "知识课程数据");
    }

    /**
     * 获取知识课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('farm:course:query')")
    @ApiOperation(value = "获取知识课程详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbKnowledgeCourseService.selectNbKnowledgeCourseById(id));
    }

    /**
     * 新增知识课程
     */
    @PreAuthorize("@ss.hasPermi('farm:course:add')")
    @Log(title = "知识课程", businessType = BusinessType.INSERT)
    @ApiOperation(value = "新增知识课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "resume", value = "文章摘要", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "expertId", value = "专家ID", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "fieldCode", value = "所属领域", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "image", value = "图片", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "content", value = "正文内容", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "serviceCatgoryId", value = "所属分类", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "produceCategoryId", value = "所属品类", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "video", value = "视频文件", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "type", value = "课程类型", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "recommend", value = "是否推荐", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishTime", value = "发布时间", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "publishStatus", value = "发布状态", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class),
            @ApiImplicitParam(name = "browseNum", value = "浏览数量", required = true, dataType = "String", paramType = "path", dataTypeClass = String.class)

    })
    @PostMapping
    public AjaxResult add(@RequestBody NbKnowledgeCourse nbKnowledgeCourse)
    {
        return toAjax(nbKnowledgeCourseService.insertNbKnowledgeCourse(nbKnowledgeCourse));
    }

    /**
     * 修改知识课程
     */
    @PreAuthorize("@ss.hasPermi('farm:course:edit')")
    @Log(title = "知识课程", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "修改知识课程")
    @PutMapping
    public AjaxResult edit(@RequestBody NbKnowledgeCourse nbKnowledgeCourse)
    {
        return toAjax(nbKnowledgeCourseService.updateNbKnowledgeCourse(nbKnowledgeCourse));
    }

    /**
     * 删除知识课程
     */
    @PreAuthorize("@ss.hasPermi('farm:course:remove')")
    @Log(title = "知识课程", businessType = BusinessType.DELETE)
    @ApiOperation(value = "删除知识课程")
    @ApiImplicitParam(name = "ids", value = "主键串", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbKnowledgeCourseService.deleteNbKnowledgeCourseByIds(ids));
    }
}
