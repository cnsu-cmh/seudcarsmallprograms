package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "车品牌接口")
@RestController
public class CarBrandApiController extends ApiController{

    @Autowired
    private ImsAutopartsCarBrandService imsAutopartsCarBrandService;

    @GetMapping("/carBrand/{id}")
    @ApiOperation(value = "根据id获取车品牌")
    public ImsAutopartsCarBrand getCarBrandById(@PathVariable Long id) {
        return imsAutopartsCarBrandService.getById(id);
    }

    @GetMapping("/carBrand/carBrandByNameLike/{name}")
    @ApiOperation(value = "根据车品牌名称模糊查询，比如“宝马")
    public List<ImsAutopartsCarBrand> getCarBrandByNameLike(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByNameLike(name);
    }

    @GetMapping("/carBrand/carBrandByName/{name}")
    @ApiOperation(value = "根据车品牌名称精确查询，比如“宝马")
    public ImsAutopartsCarBrand  getCarBrandByName(@PathVariable String name) {
        return imsAutopartsCarBrandService.getByName(name);
    }

}
