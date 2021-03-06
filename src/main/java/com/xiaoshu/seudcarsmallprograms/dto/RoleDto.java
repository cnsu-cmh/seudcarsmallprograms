package com.xiaoshu.seudcarsmallprograms.dto;

import com.xiaoshu.seudcarsmallprograms.model.SysRole;

import java.util.List;


public class RoleDto extends SysRole {

	private static final long serialVersionUID = -2095208358248925331L;

	private List<Long> permissionIds;

	public List<Long> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(List<Long> permissionIds) {
		this.permissionIds = permissionIds;
	}
}
