package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarTypeService;
import com.xiaoshu.seudcarsmallprograms.util.Base64Img;
import com.xiaoshu.seudcarsmallprograms.vo.CarTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "车类型接口")
@RestController
public class CarTypeApiController extends ApiController{
    /**
     * 上传文件根路径
     */
    @Value("${files.path}")
    private String filesPath;


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
    public List<CarTypeVo> getCarTypesByBrandId(@PathVariable Long brandId) {
        List<ImsAutopartsCarType> autopartsCarTypes = imsAutopartsCarTypeService.getByBrandId(brandId);
        return autopartsCarTypes.parallelStream().map(t -> imsAutopartsCarType2CarTypeInfo(t)).collect(Collectors.toCollection(LinkedList::new));
    }

    private CarTypeVo imsAutopartsCarType2CarTypeInfo(ImsAutopartsCarType carType) {
        return new CarTypeVo(carType.getId(),carType.getName(),Base64Img.getBase64ImageStr(filesPath + carType.getPicUrl()));
    }
}
