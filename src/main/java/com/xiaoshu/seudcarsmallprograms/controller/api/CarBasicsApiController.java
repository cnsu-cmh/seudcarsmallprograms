package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.dto.CarBasicsDto;
import com.xiaoshu.seudcarsmallprograms.model.*;
import com.xiaoshu.seudcarsmallprograms.service.*;
import com.xiaoshu.seudcarsmallprograms.util.Base64Img;
import com.xiaoshu.seudcarsmallprograms.util.ResponseEntity;
import com.xiaoshu.seudcarsmallprograms.vo.CarBasicsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "车信息接口")
@RestController
public class CarBasicsApiController extends ApiController {

    @Autowired
    private CarBasicsService carBasicsService;

    @Autowired
    private FileService fileService;

    /**
     * 上传文件根路径
     */
    @Value("${files.path}")
    private String filesPath;

    @ApiOperation(value = "列表")
    @GetMapping("/carBasics/carBasicsSearch")
    public ResponseEntity list(@ModelAttribute @ApiParam(name = "carBasics", value = "", required = true)CarBasicsDto carBasicsDto) {
        List<CarBasicsVo> carBasicsVos = carBasicsService.selectListCondition(carBasicsDto);
        carBasicsVos.forEach(car -> car.setWelPic(Base64Img.getBase64ImageStr(filesPath , car.getWelPic())));
        ResponseEntity responseEntity = ResponseEntity.success();
        responseEntity.setAny("data",carBasicsVos);
        responseEntity.setAny("params",carBasicsDto);
        return responseEntity;
    }

    @ApiOperation(value = "根据id获取详情")
    @GetMapping("/carBasics/carBasicsById")
    public ResponseEntity carBasicsById(Long id) {
        CarBasics carBasics = carBasicsService.getById(id);
        SellerInformation seller = carBasicsService.selectSellerInfoByCarId(id);
        List<FileInfo> files = fileService.getByCIdAndCType(id, FileInfo.CType.car);
        files.forEach(f -> f.setPath(Base64Img.getBase64ImageStr(filesPath , f.getUrl())));
        ResponseEntity responseEntity = ResponseEntity.success();
        responseEntity.setAny("data",carBasics);
        responseEntity.setAny("seller",seller);
        responseEntity.setAny("files",files);
        return responseEntity;
    }

    @ApiOperation(value = "根据id获取基础信息")
    @GetMapping("/carBasics/carInfoById")
    public ResponseEntity carInfoById(Long id) {
        CarBasics carBasics = carBasicsService.getById(id);
        CarBody carBody = carBasicsService.selectCarBodyByCarId(id);
        CarEngine carEngine = carBasicsService.selectCarEngineByCarId(id);
        ResponseEntity responseEntity = ResponseEntity.success();
        responseEntity.setAny("carBasics",carBasics);
        responseEntity.setAny("carBody",carBody);
        responseEntity.setAny("carEngine",carEngine);
        return responseEntity;
    }

}
