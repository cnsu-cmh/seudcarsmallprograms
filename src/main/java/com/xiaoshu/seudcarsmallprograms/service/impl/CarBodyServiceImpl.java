package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.CarBodyService;
import com.xiaoshu.seudcarsmallprograms.mapper.CarBodyMapper;
import com.xiaoshu.seudcarsmallprograms.model.CarBody;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarBodyServiceImpl implements CarBodyService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private CarBodyMapper carBodyMapper;

    @Override
    @Transactional
    public CarBody saveCarBody(CarBody carBody) {

        carBodyMapper.insertSelective(carBody);

        log.debug("新增CarBody", carBody.getId());
        return carBody;
    }

    public CarBody getById(Long id) {
        return carBodyMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public CarBody updateCarBody(CarBody carBody) {

        carBodyMapper.updateByPrimaryKeySelective(carBody);

        log.debug("修改CarBody", carBody.getId());
        return carBody;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        CarBody carBody = (CarBody)ObjectUtils.mapToObject(params, CarBody.class);
        return carBodyMapper.selectConditionCount(carBody);
    }

    @Override
    public List<CarBody> selectConditionList(Map<String, Object> params) {
       CarBody carBody = (CarBody)ObjectUtils.mapToObject(params, CarBody.class);
       return carBodyMapper.selectConditionList(carBody);
    }

    @Override
    public void delete(Long id) {
        carBodyMapper.deleteByPrimaryKey(id);
        log.debug("删除CarBody", id);
    }

}
