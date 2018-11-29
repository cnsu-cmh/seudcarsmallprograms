package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DictMapper extends MyMapper<Dict> {

    @Select("select distinct type,type_name from dict ")
    List<Map<String, String>> selectAllType();
}
