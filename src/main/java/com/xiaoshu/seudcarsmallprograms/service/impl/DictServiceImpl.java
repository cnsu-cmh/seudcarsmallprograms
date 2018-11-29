package com.xiaoshu.seudcarsmallprograms.service.impl;

import com.xiaoshu.seudcarsmallprograms.mapper.DictMapper;
import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.service.DictService;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<Dict> selectByType(String type) {
        Dict dict = new Dict(type);
        return dictMapper.select(dict);
    }

    @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        Dict dict = (Dict)ObjectUtils.mapToObject(params, Dict.class);
        return dictMapper.selectConditionCount(dict);
    }

    @Override
    public List<Dict> selectConditionList(Map<String, Object> params) {
        Dict dict = (Dict)ObjectUtils.mapToObject(params, Dict.class);
        return dictMapper.selectConditionList(dict);
    }

    @Override
    public Dict getById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public Dict getByTypeAndK(String type, String k) {
        Dict dict = new Dict(type,k);
        return dictMapper.selectOne(dict);
    }

    @Override
    @Transactional
    public Integer save(Dict dict) {
        int keys = dictMapper.insertUseGeneratedKeys(dict);
        return keys;
    }

    @Override
    @Transactional
    public void update(Dict dict) {
        dictMapper.updateByPrimaryKeySelective(dict);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dictMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map<String, String>> selectAllType() {
        return dictMapper.selectAllType();
    }
}
