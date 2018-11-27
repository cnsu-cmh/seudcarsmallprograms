package com.xiaoshu.seudcarsmallprograms.controller;

import java.util.List;

import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;


@RestController
@RequestMapping("/imsAutopartsCarBrands")
public class ImsAutopartsCarBrandController {

    @Autowired
    private ImsAutopartsCarBrandService imsAutopartsCarBrandService;

    @LogAnnotation(module = "保存")
    @PostMapping
    public ImsAutopartsCarBrand save(@RequestBody ImsAutopartsCarBrand imsAutopartsCarBrand) {
        imsAutopartsCarBrandService.saveImsAutopartsCarBrand(imsAutopartsCarBrand);

        return imsAutopartsCarBrand;
    }

    @GetMapping("/{id}")
    public ImsAutopartsCarBrand get(@PathVariable Long id) {
        return imsAutopartsCarBrandService.getById(id);
    }

    @LogAnnotation(module = "修改")
    @PutMapping
    public ImsAutopartsCarBrand update(@RequestBody ImsAutopartsCarBrand imsAutopartsCarBrand) {
        imsAutopartsCarBrandService.updateImsAutopartsCarBrand(imsAutopartsCarBrand);

        return imsAutopartsCarBrand;
    }

    @GetMapping
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> imsAutopartsCarBrandService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> imsAutopartsCarBrandService.selectConditionList(r.getParams());

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @LogAnnotation(module = "删除车品牌")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imsAutopartsCarBrandService.delete(id);
    }

    /**
     * 根据品牌名称模糊查询
     * @param name
     * @return
     */
    @GetMapping("/like/{name}")
    public List<ImsAutopartsCarBrand>  getByNameLike(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByNameLike(name);
    }

    /**
     * 根据品牌名称精确查询
     * @param name
     * @return
     */
    @GetMapping("/equals/{name}")
    public ImsAutopartsCarBrand  get(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByName(name);
    }
}
