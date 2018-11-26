package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.dto.RoleDto;
import com.xiaoshu.seudcarsmallprograms.model.SysRole;

import java.util.List;
import java.util.Map;

public interface SysRoleService {

    List<SysRole> selectAll();

    List<SysRole> selectByUserId(Long userId);

    Integer selectConditionCount(Map<String, Object> params);

    List<SysRole> selectConditionList(Map<String, Object> params);

    void saveRole(RoleDto roleDto);

    void deleteRole(Long id);

    SysRole getById(Long id);
}
