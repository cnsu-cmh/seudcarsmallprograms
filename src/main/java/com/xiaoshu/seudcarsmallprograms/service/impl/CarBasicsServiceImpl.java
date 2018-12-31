package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.dto.CarBasicsDto;
import com.xiaoshu.seudcarsmallprograms.dto.CarSellerDto;
import com.xiaoshu.seudcarsmallprograms.vo.CarBasicsVo;
import com.xiaoshu.seudcarsmallprograms.mapper.CarBodyMapper;
import com.xiaoshu.seudcarsmallprograms.mapper.CarEngineMapper;
import com.xiaoshu.seudcarsmallprograms.mapper.SellerInformationMapper;
import com.xiaoshu.seudcarsmallprograms.model.CarBody;
import com.xiaoshu.seudcarsmallprograms.model.CarEngine;
import com.xiaoshu.seudcarsmallprograms.model.SellerInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.CarBasicsService;
import com.xiaoshu.seudcarsmallprograms.mapper.CarBasicsMapper;
import com.xiaoshu.seudcarsmallprograms.model.CarBasics;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

@Service
public class CarBasicsServiceImpl implements CarBasicsService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private CarBasicsMapper carBasicsMapper;

    @Autowired
    private CarBodyMapper carBodyMapper;

    @Autowired
    private CarEngineMapper carEngineMapper;

    @Autowired
    private SellerInformationMapper sellerInformationMapper;


    @Override
    @Transactional
    public CarBasics saveCarBasics(CarBasics carBasics) {

        if(carBasics.getId() != null) {
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

    @Override
    public CarBody selectCarBodyByCarId(Long id) {
        CarBody carBody = new CarBody(id);
        return carBodyMapper.selectOne(carBody);
    }

    @Override
    public CarEngine selectCarEngineByCarId(Long id) {
        CarEngine carEngine = new CarEngine(id);
        return carEngineMapper.selectOne(carEngine);
    }

    @Override
    public SellerInformation selectSellerInfoByCarId(Long id) {
        return sellerInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public CarBasics saveCarBasicsSeller(CarSellerDto carSellerDto) {
        carBasicsMapper.saveCarBasicsSeller(carSellerDto.getCarId(),carSellerDto.getSellerId());
        return carBasicsMapper.selectByPrimaryKey(carSellerDto.getCarId());
    }

    @Override
    public CarBasics under(Long id) {
        carBasicsMapper.under(id);
        return carBasicsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void importCarBasics(MultipartFile file) throws Exception {
        InputStream is = null;
    }

    @Override
    public List<CarBasicsVo> selectListCondition(CarBasicsDto carBasicsDto) {
        return carBasicsMapper.selectListCondition(carBasicsDto);
    }

    @Override
    public List<CarBasicsVo> selectAnyListCondition(CarBasicsDto carBasicsDto) {
        return carBasicsMapper.selectAnyListCondition(carBasicsDto);
    }

    @Override
    public Number countOnline() {
        Example example = new Example(CarBasics.class);
        example.createCriteria().andNotEqualTo("status",-1);
        return carBasicsMapper.selectCountByExample(example);
    }
}
