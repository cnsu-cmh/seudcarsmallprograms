package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;

import io.swagger.annotations.ApiOperation;

@Api(tags = "车品牌")
@RestController
@RequestMapping("/imsAutopartsCarBrands")
public class ImsAutopartsCarBrandController {

    @Autowired
    private ImsAutopartsCarBrandService imsAutopartsCarBrandService;

    @LogAnnotation(module = "save")
    @PostMapping
    public ImsAutopartsCarBrand save(@RequestBody ImsAutopartsCarBrand imsAutopartsCarBrand) {
        imsAutopartsCarBrandService.saveImsAutopartsCarBrand(imsAutopartsCarBrand);

        return imsAutopartsCarBrand;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public ImsAutopartsCarBrand get(@PathVariable Long id) {
        return imsAutopartsCarBrandService.getById(id);
    }

    @LogAnnotation(module = "update")
    @PutMapping
    public ImsAutopartsCarBrand update(@RequestBody ImsAutopartsCarBrand imsAutopartsCarBrand) {
        imsAutopartsCarBrandService.updateImsAutopartsCarBrand(imsAutopartsCarBrand);

        return imsAutopartsCarBrand;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> imsAutopartsCarBrandService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> imsAutopartsCarBrandService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @LogAnnotation(module = "delete id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imsAutopartsCarBrandService.delete(id);
    }

    @GetMapping("/like/{name}")
    @ApiOperation(value = "根据品牌名称模糊查询，比如“宝马")
    public List<ImsAutopartsCarBrand>  getByNameLike(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByNameLike(name);
    }

    @GetMapping("/equals/{name}")
    @ApiOperation(value = "根据品牌名称精确查询，比如“宝马")
    public ImsAutopartsCarBrand  get(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByName(name);
    }
}
