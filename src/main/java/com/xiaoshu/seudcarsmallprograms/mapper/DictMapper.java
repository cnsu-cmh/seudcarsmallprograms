package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DictMapper extends MyMapper<Dict> {

    @Select("select distinct type,type_name typeName from dict ")
    List<Map<String, String>> selectAllType();

    @Select("select distinct val from dict where type = #{type} order by id asc")
    List<String> selectAllValType(@Param("type") String type);
}
