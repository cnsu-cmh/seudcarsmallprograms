package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.CarBody;

public interface CarBodyService {

    CarBody saveCarBody(CarBody carBody);

    CarBody getById(Long id);

    CarBody updateCarBody(CarBody carBody);

    Integer selectConditionCount(Map<String,Object> params);

    List<CarBody> selectConditionList(Map<String,Object> params);

    void delete(Long id);

}
