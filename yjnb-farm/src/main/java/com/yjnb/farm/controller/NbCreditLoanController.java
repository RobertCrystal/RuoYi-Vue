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
import com.yjnb.farm.domain.NbCreditLoan;
import com.yjnb.farm.service.INbCreditLoanService;
import com.yjnb.common.utils.poi.ExcelUtil;
import com.yjnb.common.core.page.TableDataInfo;

/**
 * 信贷信息Controller
 * 
 * @author rob
 * @date 2025-03-06
 */
@RestController
@RequestMapping("/farm/loan")
public class NbCreditLoanController extends BaseController
{
    @Autowired
    private INbCreditLoanService nbCreditLoanService;

    /**
     * 查询信贷信息列表
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:list')")
    @GetMapping("/list")
    public TableDataInfo list(NbCreditLoan nbCreditLoan)
    {
        startPage();
        List<NbCreditLoan> list = nbCreditLoanService.selectNbCreditLoanList(nbCreditLoan);
        return getDataTable(list);
    }

    /**
     * 导出信贷信息列表
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:export')")
    @Log(title = "信贷信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NbCreditLoan nbCreditLoan)
    {
        List<NbCreditLoan> list = nbCreditLoanService.selectNbCreditLoanList(nbCreditLoan);
        ExcelUtil<NbCreditLoan> util = new ExcelUtil<NbCreditLoan>(NbCreditLoan.class);
        util.exportExcel(response, list, "信贷信息数据");
    }

    /**
     * 获取信贷信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(nbCreditLoanService.selectNbCreditLoanById(id));
    }

    /**
     * 新增信贷信息
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:add')")
    @Log(title = "信贷信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NbCreditLoan nbCreditLoan)
    {
        return toAjax(nbCreditLoanService.insertNbCreditLoan(nbCreditLoan));
    }

    /**
     * 修改信贷信息
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:edit')")
    @Log(title = "信贷信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NbCreditLoan nbCreditLoan)
    {
        return toAjax(nbCreditLoanService.updateNbCreditLoan(nbCreditLoan));
    }

    /**
     * 删除信贷信息
     */
    @PreAuthorize("@ss.hasPermi('farm:loan:remove')")
    @Log(title = "信贷信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nbCreditLoanService.deleteNbCreditLoanByIds(ids));
    }
}
