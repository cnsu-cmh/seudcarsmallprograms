package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;

public interface ImsAutopartsCarTypeService {

    ImsAutopartsCarType saveImsAutopartsCarType(ImsAutopartsCarType imsAutopartsCarType);

    ImsAutopartsCarType getById(Long id);

    ImsAutopartsCarType updateImsAutopartsCarType(ImsAutopartsCarType imsAutopartsCarType);

    Integer selectConditionCount(Map<String,Object> params);

    List<ImsAutopartsCarType> selectConditionList(Map<String,Object> params);

    void delete(Long id);

    List<ImsAutopartsCarType> getByNameLike(String name);

    ImsAutopartsCarType getByName(String name);

    List<ImsAutopartsCarType> getByBrandId(Long brandId);
}
