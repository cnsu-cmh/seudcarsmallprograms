package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.ImsAutopartsCarBrandService;
import com.xiaoshu.seudcarsmallprograms.mapper.ImsAutopartsCarBrandMapper;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class ImsAutopartsCarBrandServiceImpl implements ImsAutopartsCarBrandService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private ImsAutopartsCarBrandMapper imsAutopartsCarBrandMapper;

    @Override
    @Transactional
    public ImsAutopartsCarBrand saveImsAutopartsCarBrand(ImsAutopartsCarBrand imsAutopartsCarBrand) {

        imsAutopartsCarBrandMapper.insertSelective(imsAutopartsCarBrand);

        log.debug("新增ImsAutopartsCarBrand", imsAutopartsCarBrand.getId());
        return imsAutopartsCarBrand;
    }

    public ImsAutopartsCarBrand getById(Long id) {
        return imsAutopartsCarBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public ImsAutopartsCarBrand updateImsAutopartsCarBrand(ImsAutopartsCarBrand imsAutopartsCarBrand) {

        imsAutopartsCarBrandMapper.updateByPrimaryKeySelective(imsAutopartsCarBrand);

        log.debug("修改ImsAutopartsCarBrand", imsAutopartsCarBrand.getId());
        return imsAutopartsCarBrand;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        ImsAutopartsCarBrand imsAutopartsCarBrand = (ImsAutopartsCarBrand)ObjectUtils.mapToObject(params, ImsAutopartsCarBrand.class);
        return imsAutopartsCarBrandMapper.selectConditionCount(imsAutopartsCarBrand);
    }

    @Override
    public List<ImsAutopartsCarBrand> selectConditionList(Map<String, Object> params) {
       ImsAutopartsCarBrand imsAutopartsCarBrand = (ImsAutopartsCarBrand)ObjectUtils.mapToObject(params, ImsAutopartsCarBrand.class);
       return imsAutopartsCarBrandMapper.selectConditionList(imsAutopartsCarBrand);
    }

    @Override
    public void delete(Long id) {
        imsAutopartsCarBrandMapper.deleteByPrimaryKey(id);
        log.debug("删除ImsAutopartsCarBrand", id);
    }

    @Override
    public List<ImsAutopartsCarBrand>  getByNameLike(String name) {
        Example example = new Example(ImsAutopartsCarBrand.class);
        example.createCriteria().andLike("name", "%"+name+"%");
        example.orderBy("id").asc();
        return imsAutopartsCarBrandMapper.selectByExample(example);
    }

    @Override
    public ImsAutopartsCarBrand getByName(String name) {
        ImsAutopartsCarBrand brand = new ImsAutopartsCarBrand();
        brand.setName(name);
        return imsAutopartsCarBrandMapper.selectOne(brand);
    }

}
