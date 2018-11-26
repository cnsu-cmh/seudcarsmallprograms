package com.xiaoshu.seudcarsmallprograms.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MyMapper<T> extends Mapper<T> , MySqlMapper<T> , MySelectConditionMapper<T> {

}
