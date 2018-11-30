package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.CarBasicsService;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/carBasicss")
public class CarBasicsController {

    @Autowired
    private CarBasicsService carBasicsService;

    @PostMapping
    @ApiOperation(value = "保存")
    public CarBasics save(@RequestBody CarBasics carBasics) {
        carBasicsService.saveCarBasics(carBasics);

        return carBasics;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public CarBasics get(@PathVariable Long id) {
        return carBasicsService.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public CarBasics update(@RequestBody CarBasics carBasics) {
        carBasicsService.updateCarBasics(carBasics);

        return carBasics;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> carBasicsService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> carBasicsService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        carBasicsService.delete(id);
    }
}
