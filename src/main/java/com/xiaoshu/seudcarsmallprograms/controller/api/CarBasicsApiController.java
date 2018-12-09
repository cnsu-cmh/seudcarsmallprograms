package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.dto.CarBasicsDto;
import com.xiaoshu.seudcarsmallprograms.service.CarBasicsService;
import com.xiaoshu.seudcarsmallprograms.util.Base64Img;
import com.xiaoshu.seudcarsmallprograms.vo.CarBasicsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Api(tags = "车信息接口")
@RestController
public class CarBasicsApiController extends ApiController {

    @Autowired
    private CarBasicsService carBasicsService;

    /**
     * 上传文件根路径
     */
    @Value("${files.path}")
    private String filesPath;

    @ApiOperation(value = "列表")
    @GetMapping("/carBasics/carBasicsSearch")
    public List<CarBasicsVo> list(@ModelAttribute @ApiParam(name = "carBasics", value = "", required = true)CarBasicsDto carBasicsDto) {
        List<CarBasicsVo> carBasicsVos = carBasicsService.selectListCondition(carBasicsDto);
        carBasicsVos.forEach(car -> car.setWelPic(Base64Img.getBase64ImageStr(filesPath + car.getWelPic())));
        return  carBasicsVos;
    }

}
