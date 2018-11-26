package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarTypeService;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;

import io.swagger.annotations.ApiOperation;

@Api(tags = "车类型")
@RestController
@RequestMapping("/imsAutopartsCarTypes")
public class ImsAutopartsCarTypeController {

    @Autowired
    private ImsAutopartsCarTypeService imsAutopartsCarTypeService;

    @LogAnnotation(module = "save")
    @PostMapping
    public ImsAutopartsCarType save(@RequestBody ImsAutopartsCarType imsAutopartsCarType) {
        imsAutopartsCarTypeService.saveImsAutopartsCarType(imsAutopartsCarType);

        return imsAutopartsCarType;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public ImsAutopartsCarType get(@PathVariable Long id) {
        return imsAutopartsCarTypeService.getById(id);
    }

    @LogAnnotation(module = "update")
    @PutMapping
    public ImsAutopartsCarType update(@RequestBody ImsAutopartsCarType imsAutopartsCarType) {
        imsAutopartsCarTypeService.updateImsAutopartsCarType(imsAutopartsCarType);

        return imsAutopartsCarType;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> imsAutopartsCarTypeService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> imsAutopartsCarTypeService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @LogAnnotation(module = "根据Id删除")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imsAutopartsCarTypeService.delete(id);
    }

    @GetMapping("/like/{name}")
    @ApiOperation(value = "根据类型名称模糊查询，比如“宝马8系")
    public List<ImsAutopartsCarType> getByNameLike(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByNameLike(name);
    }

    @GetMapping("/equals/{name}")
    @ApiOperation(value = "根据类型名称精确查询，比如“宝马8系")
    public ImsAutopartsCarType getByName(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByName(name);
    }

    @GetMapping("/brandId/{brandId}")
    @ApiOperation(value = "根据品牌ID查询，比如“185")
    public List<ImsAutopartsCarType> getByBrandId(@PathVariable Long brandId) {
        return imsAutopartsCarTypeService.getByBrandId(brandId);
    }
}
