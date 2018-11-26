package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.SysLogs;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysLogsMapper extends MyMapper<SysLogs> {

    void save(SysLogs sysLogs);

    Integer conditionCount(@Param("params") Map<String, Object> params);

    List<SysLogs> conditionList(@Param("params") Map<String, Object> params,
                                @Param("offset") Integer offset,
                                @Param("limit") Integer limit);
}
