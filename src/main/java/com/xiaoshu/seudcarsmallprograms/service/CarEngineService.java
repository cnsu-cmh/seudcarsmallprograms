package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.CarEngine;

public interface CarEngineService {

    CarEngine saveCarEngine(CarEngine carEngine);

    CarEngine getById(Long id);

    CarEngine updateCarEngine(CarEngine carEngine);

    Integer selectConditionCount(Map<String,Object> params);

    List<CarEngine> selectConditionList(Map<String,Object> params);

    void delete(Long id);

}
