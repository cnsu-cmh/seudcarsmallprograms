package com.xiaoshu.seudcarsmallprograms.service;

import java.util.List;
import java.util.Map;

import com.xiaoshu.seudcarsmallprograms.model.SellerInformation;

public interface SellerInformationService {

    SellerInformation saveSellerInformation(SellerInformation sellerInformation);

    SellerInformation getById(Long id);

    SellerInformation updateSellerInformation(SellerInformation sellerInformation);

    Integer selectConditionCount(Map<String,Object> params);

    List<SellerInformation> selectConditionList(Map<String,Object> params);

    void delete(Long id);

    List<SellerInformation> selectAll();

}
