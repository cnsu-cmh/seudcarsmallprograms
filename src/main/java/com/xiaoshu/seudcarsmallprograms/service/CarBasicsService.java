package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.dto.CarBasicsDto;
import com.xiaoshu.seudcarsmallprograms.dto.CarSellerDto;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;
import com.xiaoshu.seudcarsmallprograms.model.CarBody;
import com.xiaoshu.seudcarsmallprograms.model.CarEngine;
import com.xiaoshu.seudcarsmallprograms.model.SellerInformation;
import com.xiaoshu.seudcarsmallprograms.vo.CarBasicsVo;
import org.springframework.web.multipart.MultipartFile;

public interface CarBasicsService {

    CarBasics saveCarBasics(CarBasics carBasics);

    CarBasics getById(Long id);

    CarBasics updateCarBasics(CarBasics carBasics);

    Integer selectConditionCount(Map<String,Object> params);

    List<CarBasics> selectConditionList(Map<String,Object> params);

    void delete(Long id);

    CarBody selectCarBodyByCarId(Long id);

    CarEngine selectCarEngineByCarId(Long id);

    SellerInformation selectSellerInfoByCarId(Long id);

    CarBasics saveCarBasicsSeller(CarSellerDto carSellerDto);

    CarBasics under(Long id);

    void importCarBasics(MultipartFile file) throws Exception;

    List<CarBasicsVo> selectListCondition(CarBasicsDto carBasicsDto);
}
