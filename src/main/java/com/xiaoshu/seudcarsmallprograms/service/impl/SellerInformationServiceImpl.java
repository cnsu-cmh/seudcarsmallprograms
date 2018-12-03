package com.xiaoshu.seudcarsmallprograms.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoshu.seudcarsmallprograms.service.SellerInformationService;
import com.xiaoshu.seudcarsmallprograms.mapper.SellerInformationMapper;
import com.xiaoshu.seudcarsmallprograms.model.SellerInformation;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerInformationServiceImpl implements SellerInformationService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private SellerInformationMapper sellerInformationMapper;

    @Override
    @Transactional
    public SellerInformation saveSellerInformation(SellerInformation sellerInformation) {

        sellerInformationMapper.insertSelective(sellerInformation);

        log.debug("新增SellerInformation", sellerInformation.getId());
        return sellerInformation;
    }

    public SellerInformation getById(Long id) {
        return sellerInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public SellerInformation updateSellerInformation(SellerInformation sellerInformation) {

        sellerInformationMapper.updateByPrimaryKeySelective(sellerInformation);

        log.debug("修改SellerInformation", sellerInformation.getId());
        return sellerInformation;
    }

     @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        SellerInformation sellerInformation = (SellerInformation)ObjectUtils.mapToObject(params, SellerInformation.class);
        return sellerInformationMapper.selectConditionCount(sellerInformation);
    }

    @Override
    public List<SellerInformation> selectConditionList(Map<String, Object> params) {
       SellerInformation sellerInformation = (SellerInformation)ObjectUtils.mapToObject(params, SellerInformation.class);
       return sellerInformationMapper.selectConditionList(sellerInformation);
    }

    @Override
    public void delete(Long id) {
        sellerInformationMapper.deleteByPrimaryKey(id);
        log.debug("删除SellerInformation", id);
    }

    @Override
    public List<SellerInformation> selectAll() {
        return sellerInformationMapper.selectAll();
    }

}
