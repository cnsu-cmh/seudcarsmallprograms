package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.CarBodyService;
import com.xiaoshu.seudcarsmallprograms.model.CarBody;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/carBodys")
public class CarBodyController {

    @Autowired
    private CarBodyService carBodyService;

    @PostMapping
    @ApiOperation(value = "保存")
    @RequiresPermissions({"car:add"})
    public CarBody save(@RequestBody CarBody carBody) {
        carBodyService.saveCarBody(carBody);

        return carBody;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    @RequiresPermissions({"car:query"})
    public CarBody get(@PathVariable Long id) {
        return carBodyService.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    @RequiresPermissions({"car:edit"})
    public CarBody update(@RequestBody CarBody carBody) {
        carBodyService.updateCarBody(carBody);

        return carBody;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    @RequiresPermissions({"car:query"})
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> carBodyService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> carBodyService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        carBodyService.delete(id);
    }
}
