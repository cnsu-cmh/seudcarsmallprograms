package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;
import com.xiaoshu.seudcarsmallprograms.service.DictService;
import com.xiaoshu.seudcarsmallprograms.service.FileService;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "接口")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DictService dictService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ImsAutopartsCarBrandService imsAutopartsCarBrandService;

    @Autowired
    private ImsAutopartsCarTypeService imsAutopartsCarTypeService;


    @GetMapping(value = "/dict", params = "type" )
    @ResponseBody
    @ApiOperation(value = "根据type获取字典")
    public List<Dict> listByType(String type) {
        return dictService.selectByType(type);
    }


    @GetMapping("/files/{id}")
    @ApiOperation(value = "根据id获取文件")
    public FileInfo getFilesById(@PathVariable Long id) {
        return fileService.getById(id);
    }

    @GetMapping("/files/{cId}")
    @ApiOperation(value = "根据车子id获取车子图片集合")
    public List<FileInfo> getByCId(@PathVariable Long cId) {
        return fileService.getByCId(cId);
    }

    @GetMapping("/files/wel/{cId}")
    @ApiOperation(value = "根据车子id获取首页展示图片")
    public FileInfo getWelByCId(@PathVariable Long cId) {
        return fileService.getWelByCId(cId);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取车品牌")
    public ImsAutopartsCarBrand getCarBrandById(@PathVariable Long id) {
        return imsAutopartsCarBrandService.getById(id);
    }

    @GetMapping("/carBrandByNameLike/{name}")
    @ApiOperation(value = "根据车品牌名称模糊查询，比如“宝马")
    public List<ImsAutopartsCarBrand>  getCarBrandByNameLike(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByNameLike(name);
    }

    @GetMapping("/carBrandByName/{name}")
    @ApiOperation(value = "根据车品牌名称精确查询，比如“宝马")
    public ImsAutopartsCarBrand  getCarBrandByName(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByName(name);
    }

    @GetMapping("/carTypesByNameLike/{name}")
    @ApiOperation(value = "根据车类型名称模糊查询，比如“宝马8系")
    public List<ImsAutopartsCarType> getCarTypesByNameLike(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByNameLike(name);
    }

    @GetMapping("/carTypesByName/{name}")
    @ApiOperation(value = "根据类型名称精确查询，比如“宝马8系")
    public ImsAutopartsCarType getCarTypesByName(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByName(name);
    }

    @GetMapping("/carTypesByBrandId/{brandId}")
    @ApiOperation(value = "根据车品牌ID查询车类型，比如“185")
    public List<ImsAutopartsCarType> getCarTypesByBrandId(@PathVariable Long brandId) {
        return imsAutopartsCarTypeService.getByBrandId(brandId);
    }

}
