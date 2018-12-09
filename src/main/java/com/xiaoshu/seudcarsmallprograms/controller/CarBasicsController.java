package com.xiaoshu.seudcarsmallprograms.controller;


import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.dto.CarSellerDto;
import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import com.xiaoshu.seudcarsmallprograms.service.FileService;
import com.xiaoshu.seudcarsmallprograms.util.ResponseEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.CarBasicsService;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/carBasicss")
public class CarBasicsController {

    @Autowired
    private CarBasicsService carBasicsService;

    @Autowired
    private FileService fileService;

    @PostMapping
    @ApiOperation(value = "保存")
    @RequiresPermissions({"car:add"})
    public CarBasics save(@RequestBody CarBasics carBasics) {
        carBasicsService.saveCarBasics(carBasics);

        return carBasics;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    @RequiresPermissions({"car:query"})
    public CarBasics get(@PathVariable Long id) {
        return carBasicsService.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    @RequiresPermissions({"car:edit"})
    public CarBasics update(@RequestBody CarBasics carBasics) {
        carBasicsService.updateCarBasics(carBasics);

        return carBasics;
    }

    @GetMapping
    @ApiOperation(value = "列表")
    @RequiresPermissions({"car:query"})
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

    @PostMapping("/carSeller")
    @ApiOperation(value = "保存商家信息")
    @RequiresPermissions({"car:add","car:edit"})
    public CarBasics save(@RequestBody CarSellerDto carSellerDto) {
        CarBasics carBasics = carBasicsService.saveCarBasicsSeller(carSellerDto);
        return carBasics;
    }

    @PostMapping("/under/{id}")
    @ApiOperation(value = "根据id获取")
    @RequiresPermissions({"car:under"})
    public CarBasics under(@PathVariable Long id) {
        return carBasicsService.under(id);
    }


    @LogAnnotation(module = "图片上传")
    @PostMapping("/{carId}/uploadImages")
    public FileInfo uploadFile(MultipartFile file, @PathVariable Long carId) throws IOException {
        if(carId == null ) {
            return null;
        }
        FileInfo fileInfo = fileService.multipartFile2FileInfo(file,carId,FileInfo.CType.car);
        return fileInfo;
    }

    @PostMapping("/import")
    @RequiresPermissions({"car:import"})
    public ResponseEntity importCarBasics(MultipartFile file) {
        try{
            carBasicsService.importCarBasics(file);
            return ResponseEntity.success();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.failure();
    }

}
