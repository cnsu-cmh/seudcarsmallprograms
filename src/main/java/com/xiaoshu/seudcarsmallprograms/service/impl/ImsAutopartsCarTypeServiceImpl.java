package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarTypeService;
import com.xiaoshu.seudcarsmallprograms.mapper.ImsAutopartsCarTypeMapper;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class ImsAutopartsCarTypeServiceImpl implements ImsAutopartsCarTypeService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private ImsAutopartsCarTypeMapper imsAutopartsCarTypeMapper;

    @Override
    @Transactional
    public ImsAutopartsCarType saveImsAutopartsCarType(ImsAutopartsCarType imsAutopartsCarType) {

        imsAutopartsCarTypeMapper.insertSelective(imsAutopartsCarType);

        log.debug("新增ImsAutopartsCarType", imsAutopartsCarType.getId());
        return imsAutopartsCarType;
    }

    public ImsAutopartsCarType getById(Long id) {
        return imsAutopartsCarTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public ImsAutopartsCarType updateImsAutopartsCarType(ImsAutopartsCarType imsAutopartsCarType) {

        imsAutopartsCarTypeMapper.updateByPrimaryKeySelective(imsAutopartsCarType);

        log.debug("修改ImsAutopartsCarType", imsAutopartsCarType.getId());
        return imsAutopartsCarType;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        ImsAutopartsCarType imsAutopartsCarType = (ImsAutopartsCarType)ObjectUtils.mapToObject(params, ImsAutopartsCarType.class);
        return imsAutopartsCarTypeMapper.selectConditionCount(imsAutopartsCarType);
    }

    @Override
    public List<ImsAutopartsCarType> selectConditionList(Map<String, Object> params) {
       ImsAutopartsCarType imsAutopartsCarType = (ImsAutopartsCarType)ObjectUtils.mapToObject(params, ImsAutopartsCarType.class);
       return imsAutopartsCarTypeMapper.selectConditionList(imsAutopartsCarType);
    }

    @Override
    public void delete(Long id) {
        imsAutopartsCarTypeMapper.deleteByPrimaryKey(id);
        log.debug("删除ImsAutopartsCarType", id);
    }

    @Override
    public List<ImsAutopartsCarType> getByNameLike(String name) {
        Example example = new Example(ImsAutopartsCarType.class);
        example.createCriteria().andLike("name", "%" +name + "%");
        example.orderBy("id").asc();
        return imsAutopartsCarTypeMapper.selectByExample(example);
    }

    @Override
    public ImsAutopartsCarType getByName(String name) {
        ImsAutopartsCarType type = new ImsAutopartsCarType();
        type.setName(name);
        return imsAutopartsCarTypeMapper.selectOne(type);
    }

    @Override
    public List<ImsAutopartsCarType> getByBrandId(Long brandId) {
        Example example = new Example(ImsAutopartsCarType.class);
        example.createCriteria().andEqualTo("brandId", brandId);
        example.orderBy("id").asc();
        return imsAutopartsCarTypeMapper.selectByExample(example);
    }

}
