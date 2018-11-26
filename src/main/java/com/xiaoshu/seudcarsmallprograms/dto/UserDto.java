package com.xiaoshu.seudcarsmallprograms.dto;

import com.xiaoshu.seudcarsmallprograms.model.SysUser;

import java.util.List;

public class UserDto  extends SysUser {

    private static final long serialVersionUID = 7534636856631041778L;

    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
