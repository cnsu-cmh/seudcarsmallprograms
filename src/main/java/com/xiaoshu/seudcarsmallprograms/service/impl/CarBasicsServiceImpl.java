package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.CarBasicsService;
import com.xiaoshu.seudcarsmallprograms.mapper.CarBasicsMapper;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarBasicsServiceImpl implements CarBasicsService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private CarBasicsMapper carBasicsMapper;

    @Override
    @Transactional
    public CarBasics saveCarBasics(CarBasics carBasics) {

        if(carBasics.getId() == null) {
            carBasicsMapper.updateByPrimaryKey(carBasics);
        } else {
            carBasicsMapper.insertSelective(carBasics);
        }
        log.debug("新增CarBasics", carBasics.getId());
        return carBasics;
    }

    public CarBasics getById(Long id) {
        return carBasicsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public CarBasics updateCarBasics(CarBasics carBasics) {

        carBasicsMapper.updateByPrimaryKeySelective(carBasics);

        log.debug("修改CarBasics", carBasics.getId());
        return carBasics;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        CarBasics carBasics = (CarBasics)ObjectUtils.mapToObject(params, CarBasics.class);
        return carBasicsMapper.selectConditionCount(carBasics);
    }

    @Override
    public List<CarBasics> selectConditionList(Map<String, Object> params) {
       CarBasics carBasics = (CarBasics)ObjectUtils.mapToObject(params, CarBasics.class);
       return carBasicsMapper.selectConditionList(carBasics);
    }

    @Override
    public void delete(Long id) {
        carBasicsMapper.deleteByPrimaryKey(id);
        log.debug("删除CarBasics", id);
    }

}
