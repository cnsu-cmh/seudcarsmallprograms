package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.model.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> selectByUserId(Long userId);

    void update(SysPermission permission);

    void delete(Long id);

    SysPermission getById(Long id);

    void save(SysPermission permission);

    List<SysPermission> selectByRoleId(Long roleId);

    List<SysPermission> selectParents();

    List<SysPermission> selecttAll();

}
