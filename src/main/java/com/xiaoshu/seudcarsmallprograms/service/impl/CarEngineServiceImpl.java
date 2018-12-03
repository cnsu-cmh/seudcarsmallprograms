package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.CarEngineService;
import com.xiaoshu.seudcarsmallprograms.mapper.CarEngineMapper;
import com.xiaoshu.seudcarsmallprograms.model.CarEngine;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarEngineServiceImpl implements CarEngineService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private CarEngineMapper carEngineMapper;

    @Override
    @Transactional
    public CarEngine saveCarEngine(CarEngine carEngine) {

        if(carEngine.getId() != null) {
            carEngineMapper.updateByPrimaryKey(carEngine);
        } else {
            carEngineMapper.insertSelective(carEngine);
        }

        log.debug("新增CarEngine", carEngine.getId());
        return carEngine;
    }

    public CarEngine getById(Long id) {
        return carEngineMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public CarEngine updateCarEngine(CarEngine carEngine) {

        carEngineMapper.updateByPrimaryKeySelective(carEngine);

        log.debug("修改CarEngine", carEngine.getId());
        return carEngine;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        CarEngine carEngine = (CarEngine)ObjectUtils.mapToObject(params, CarEngine.class);
        return carEngineMapper.selectConditionCount(carEngine);
    }

    @Override
    public List<CarEngine> selectConditionList(Map<String, Object> params) {
       CarEngine carEngine = (CarEngine)ObjectUtils.mapToObject(params, CarEngine.class);
       return carEngineMapper.selectConditionList(carEngine);
    }

    @Override
    public void delete(Long id) {
        carEngineMapper.deleteByPrimaryKey(id);
        log.debug("删除CarEngine", id);
    }

}
