package com.xiaoshu.seudcarsmallprograms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.xiaoshu.seudcarsmallprograms.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.SellerInformationService;
import com.xiaoshu.seudcarsmallprograms.model.SellerInformation;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sellerInformations")
public class SellerInformationController {

    @Autowired
    private SellerInformationService sellerInformationService;

    @PostMapping
    @ApiOperation(value = "保存")
    @RequiresPermissions("seller:add")
    public SellerInformation save(@RequestBody SellerInformation sellerInformation) {
        sellerInformationService.saveSellerInformation(sellerInformation);
        return sellerInformation;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public SellerInformation get(@PathVariable Long id) {
        SellerInformation information = sellerInformationService.getById(id);
        return information;

    }

    @PutMapping
    @ApiOperation(value = "修改")
    @RequiresPermissions("seller:edit")
    public SellerInformation update(@RequestBody SellerInformation sellerInformation) {
        sellerInformationService.updateSellerInformation(sellerInformation);

        return sellerInformation;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    @RequiresPermissions("seller:query")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> sellerInformationService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> sellerInformationService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    @RequiresPermissions("seller:del")
    public void delete(@PathVariable Long id) {
        sellerInformationService.delete(id);
    }
}
