package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.dto.UserDto;
import com.xiaoshu.seudcarsmallprograms.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {


    SysUser getUser(String username);

    Integer selectConditionCount(Map<String, Object> params);

    List<SysUser> selectConditionList(Map<String, Object> params);

    SysUser updateUser(UserDto userDto);

    SysUser saveUser(UserDto userDto);

    void changePassword(String username, String oldPassword, String newPassword);

    SysUser getById(Long id);
}
