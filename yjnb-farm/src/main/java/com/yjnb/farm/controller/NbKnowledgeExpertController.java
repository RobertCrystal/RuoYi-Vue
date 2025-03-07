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
@RestController
@RequestMapping("/farm/expert")
public class NbKnowledgeExpertController extends BaseController
{
    @Autowired
    private INbKnowledgeExpertService nbKnowledgeExpertService;

    /**
     * 查询知识专家列表
     */
    @PreAuthorize("@ss.hasPermi('farm:expert:list')")
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
    @PreAuthorize("@ss.hasPermi('farm:expert:export')")
    @Log(title = "知识专家", businessType = BusinessType.EXPORT)
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
    @PreAuthorize("@ss.hasPermi('farm:expert:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbKnowledgeExpertService.selectNbKnowledgeExpertById(id));
    }

    /**
     * 新增知识专家
     */
    @PreAuthorize("@ss.hasPermi('farm:expert:add')")
    @Log(title = "知识专家", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NbKnowledgeExpert nbKnowledgeExpert)
    {
        return toAjax(nbKnowledgeExpertService.insertNbKnowledgeExpert(nbKnowledgeExpert));
    }

    /**
     * 修改知识专家
     */
    @PreAuthorize("@ss.hasPermi('farm:expert:edit')")
    @Log(title = "知识专家", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NbKnowledgeExpert nbKnowledgeExpert)
    {
        return toAjax(nbKnowledgeExpertService.updateNbKnowledgeExpert(nbKnowledgeExpert));
    }

    /**
     * 删除知识专家
     */
    @PreAuthorize("@ss.hasPermi('farm:expert:remove')")
    @Log(title = "知识专家", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbKnowledgeExpertService.deleteNbKnowledgeExpertByIds(ids));
    }
}
