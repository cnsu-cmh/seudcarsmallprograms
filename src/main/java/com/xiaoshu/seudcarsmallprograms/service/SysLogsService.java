package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.model.SysLogs;

import java.util.List;
import java.util.Map;

public interface SysLogsService {

    Integer selectConditionCount(Map<String, Object> params);

    List<SysLogs> selectConditionList(Map<String, Object> params, Integer offset, Integer limit);

    void save(Long id, String module, Boolean flag, String o);

    void save(SysLogs sysLogs);
}
