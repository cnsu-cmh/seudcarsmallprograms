package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "车类型接口")
@RestController
public class CarTypeApiController extends ApiController{

    @Autowired
    private ImsAutopartsCarTypeService imsAutopartsCarTypeService;

    @GetMapping("/carType/carTypesByNameLike/{name}")
    @ApiOperation(value = "根据车类型名称模糊查询，比如“宝马8系")
    public List<ImsAutopartsCarType> getCarTypesByNameLike(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByNameLike(name);
    }

    @GetMapping("/carType/carTypesByName/{name}")
    @ApiOperation(value = "根据类型名称精确查询，比如“宝马8系")
    public ImsAutopartsCarType getCarTypesByName(@PathVariable String name) {
        return imsAutopartsCarTypeService.getByName(name);
    }

    @GetMapping("/carType/carTypesByBrandId/{brandId}")
    @ApiOperation(value = "根据车品牌ID查询车类型，比如“185")
    public List<ImsAutopartsCarType> getCarTypesByBrandId(@PathVariable Long brandId) {
        return imsAutopartsCarTypeService.getByBrandId(brandId);
    }
}
