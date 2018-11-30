package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.CarBasics;

public interface CarBasicsService {

    CarBasics saveCarBasics(CarBasics carBasics);

    CarBasics getById(Long id);

    CarBasics updateCarBasics(CarBasics carBasics);

    Integer selectConditionCount(Map<String,Object> params);

    List<CarBasics> selectConditionList(Map<String,Object> params);

    void delete(Long id);

}
