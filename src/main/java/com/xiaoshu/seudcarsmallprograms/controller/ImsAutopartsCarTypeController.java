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


@RestController
@RequestMapping("/imsAutopartsCarTypes")
public class ImsAutopartsCarTypeController {

    @Autowired
    private ImsAutopartsCarTypeService imsAutopartsCarTypeService;

    @LogAnnotation(module = "保存")
    @PostMapping
    public ImsAutopartsCarType save(@RequestBody ImsAutopartsCarType imsAutopartsCarType) {
        imsAutopartsCarTypeService.saveImsAutopartsCarType(imsAutopartsCarType);

        return imsAutopartsCarType;
    }

    @GetMapping("/{id}")
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

    /**
     *  根据类型名称模糊查询
     * @param name
     * @return
     */
    @GetMapping("/like/{name}")
    public List<ImsAutopartsCarType> getByNameLike(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByNameLike(name);
    }

    /**
     * 根据类型名称精确查询
     * @param name
     * @return
     */
    @GetMapping("/equals/{name}")
    public ImsAutopartsCarType getByName(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByName(name);
    }

    /**
     * 根据品牌ID查询
     * @param brandId
     * @return
     */
    @GetMapping("/brandId/{brandId}")
    public List<ImsAutopartsCarType> getByBrandId(@PathVariable Long brandId) {
        return imsAutopartsCarTypeService.getByBrandId(brandId);
    }
}
