package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.SysUser;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserMapper extends MyMapper<SysUser> {

    @Delete("delete from sys_role_user where user_id = #{userId}")
    void deleteUserRole(Long userId);

    void saveUserRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    @Update("update sys_user t set t.password = #{password} where t.id = #{id}")
    void changePassword(@Param("id") Long id, @Param("password") String password);
}
