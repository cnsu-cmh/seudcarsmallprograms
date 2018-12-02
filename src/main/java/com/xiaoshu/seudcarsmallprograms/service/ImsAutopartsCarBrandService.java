package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarBrand;

public interface ImsAutopartsCarBrandService {

    ImsAutopartsCarBrand saveImsAutopartsCarBrand(ImsAutopartsCarBrand imsAutopartsCarBrand);

    ImsAutopartsCarBrand getById(Long id);

    ImsAutopartsCarBrand updateImsAutopartsCarBrand(ImsAutopartsCarBrand imsAutopartsCarBrand);

    Integer selectConditionCount(Map<String,Object> params);

    List<ImsAutopartsCarBrand> selectConditionList(Map<String,Object> params);

    void delete(Long id);

    List<ImsAutopartsCarBrand>  getByNameLike(String name);

    ImsAutopartsCarBrand getByName(String name);

    List<ImsAutopartsCarBrand> selectAll();
}
