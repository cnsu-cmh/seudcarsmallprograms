package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;
import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.util.Base64Img;
import com.xiaoshu.seudcarsmallprograms.vo.CarBrandVo;
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
    public List<CarBrandVo> listAll() {
        List<ImsAutopartsCarBrand> carBrands = imsAutopartsCarBrandService.selectAll();
        List<CarBrandVo.CarBrandInfo> isHotBrands = carBrands.stream().filter(cb -> cb.getIsHot()).map(b -> imsAutopartsCarBrand2CarBrandInfo(b)).collect(Collectors.toList());
        CarBrandVo isHotBrand = new CarBrandVo(0,"热门品牌",isHotBrands);
        CarBrandVo noBrand = new CarBrandVo(1,"*",new ArrayList<CarBrandVo.CarBrandInfo>(){{add(new CarBrandVo.CarBrandInfo(0L,"不限品牌", ""));}});
        Map<String, List<ImsAutopartsCarBrand>> carBrandMap = carBrands.stream().collect(Collectors.groupingBy(ImsAutopartsCarBrand::getInitials,LinkedHashMap::new,Collectors.toCollection(LinkedList::new)));
        List<CarBrandVo> result = new LinkedList<>();
        result.add(isHotBrand);
        result.add(noBrand);
        carBrandMap.forEach((k,v) -> {
            LinkedList<CarBrandVo.CarBrandInfo> carBrandInfos = v.parallelStream().map(b -> imsAutopartsCarBrand2CarBrandInfo(b)).collect(Collectors.toCollection(LinkedList::new));
            result.add(new CarBrandVo(result.size(),k,carBrandInfos));
        });
        return result;
    }

    private CarBrandVo.CarBrandInfo imsAutopartsCarBrand2CarBrandInfo(ImsAutopartsCarBrand carBrand) {
        return new CarBrandVo.CarBrandInfo(carBrand.getId(), carBrand.getName(),Base64Img.getBase64ImageStr(filesPath , carBrand.getPicUrl()));
    }

}
