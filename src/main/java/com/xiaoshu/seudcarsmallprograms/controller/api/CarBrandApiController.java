package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.dto.CarBrandDto;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.util.Base64Img;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "车品牌接口")
@RestController
public class CarBrandApiController extends ApiController{
    /**
     * 上传文件根路径
     */
    @Value("${files.path}")
    private String filesPath;


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

    @GetMapping(value = "/carBrand/allBrand")
    @ApiOperation(value = "所有车品牌")
    public List<CarBrandDto> listAll() {
        List<ImsAutopartsCarBrand> carBrands = imsAutopartsCarBrandService.selectAll();
        List<CarBrandDto.CarBrandInfo> isHotBrands = carBrands.stream().filter(cb -> cb.getIsHot()).map(b -> imsAutopartsCarBrand2CarBrandInfo(b)).collect(Collectors.toList());
        CarBrandDto isHotBrand = new CarBrandDto(0,"热门品牌",isHotBrands);
        CarBrandDto noBrand = new CarBrandDto(1,"*",new ArrayList<CarBrandDto.CarBrandInfo>(){{add(new CarBrandDto.CarBrandInfo(0L,"不限品牌", ""));}});
        Map<String, List<ImsAutopartsCarBrand>> carBrandMap = carBrands.stream().collect(Collectors.groupingBy(ImsAutopartsCarBrand::getInitials,LinkedHashMap::new,Collectors.toCollection(LinkedList::new)));
        List<CarBrandDto> result = new LinkedList<>();
        result.add(isHotBrand);
        result.add(noBrand);
        carBrandMap.forEach((k,v) -> {
            LinkedList<CarBrandDto.CarBrandInfo> carBrandInfos = v.parallelStream().map(b -> imsAutopartsCarBrand2CarBrandInfo(b)).collect(Collectors.toCollection(LinkedList::new));
            result.add(new CarBrandDto(result.size(),k,carBrandInfos));
        });
        return result;
    }

    private CarBrandDto.CarBrandInfo imsAutopartsCarBrand2CarBrandInfo(ImsAutopartsCarBrand carBrand) {
        return new CarBrandDto.CarBrandInfo(carBrand.getId(), carBrand.getName(),Base64Img.getBase64ImageStr(filesPath + carBrand.getPicUrl()));
    }

}
