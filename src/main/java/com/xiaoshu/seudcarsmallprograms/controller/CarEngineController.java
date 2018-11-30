package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.CarEngineService;
import com.xiaoshu.seudcarsmallprograms.model.CarEngine;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/carEngines")
public class CarEngineController {

    @Autowired
    private CarEngineService carEngineService;

    @PostMapping
    @ApiOperation(value = "保存")
    public CarEngine save(@RequestBody CarEngine carEngine) {
        carEngineService.saveCarEngine(carEngine);

        return carEngine;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public CarEngine get(@PathVariable Long id) {
        return carEngineService.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public CarEngine update(@RequestBody CarEngine carEngine) {
        carEngineService.updateCarEngine(carEngine);

        return carEngine;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> carEngineService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> carEngineService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        carEngineService.delete(id);
    }
}
