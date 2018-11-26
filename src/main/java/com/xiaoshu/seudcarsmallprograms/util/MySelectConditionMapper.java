package com.xiaoshu.seudcarsmallprograms.util;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

@RegisterMapper
public interface MySelectConditionMapper<T> {

    @SelectProvider(type = MySelectConditionProvider.class,method = "dynamicSQL")
    Integer selectConditionCount(T record);

    @SelectProvider(type = MySelectConditionProvider.class,method = "dynamicSQL")
    List<T> selectConditionList(T record);
}
