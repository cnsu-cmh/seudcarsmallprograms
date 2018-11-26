package com.xiaoshu.seudcarsmallprograms.controller;


import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.dto.UserDto;
import com.xiaoshu.seudcarsmallprograms.model.SysUser;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.SysUserService;
import com.xiaoshu.seudcarsmallprograms.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class SysUserController {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private SysUserService userService;

    @LogAnnotation(module = "currentUser")
    @GetMapping("/current")
    public SysUser currentUser() {
        return UserUtil.getCurrentUser();
    }

    @LogAnnotation(module = "listUsers")
    @GetMapping
    @RequiresPermissions("sys:user:query")
    public PageTableResponse listUsers(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> userService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> {
            return userService.selectConditionList(r.getParams());
        };

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @LogAnnotation(module = "saveUser")
    @PostMapping
    @RequiresPermissions("sys:user:add")
    public SysUser saveUser(@RequestBody UserDto userDto) {
        SysUser user = userService.getUser(userDto.getUsername());
        if (user != null) {
            throw new IllegalArgumentException(userDto.getUsername() + "已存在");
        }

        return userService.saveUser(userDto);
    }

    @LogAnnotation(module = "updateUser")
    @PutMapping
    @RequiresPermissions("sys:user:add")
    public SysUser updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @LogAnnotation(module = "changePassword")
    @PutMapping("/{username}")
    @RequiresPermissions("sys:user:password")
    public void changePassword(String oldPassword, String newPassword, @PathVariable String username) {
        userService.changePassword(username, oldPassword, newPassword);
    }

    @LogAnnotation(module = "getById")
    @GetMapping("/{id}")
    public SysUser get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @LogAnnotation(module = "updateHeadImgUrl")
    @PutMapping(params = "headImgUrl")
    public void updateHeadImgUrl(String headImgUrl) {
        SysUser user = UserUtil.getCurrentUser();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setHeadImgUrl(headImgUrl);

        userService.updateUser(userDto);
        log.debug("{}修改了头像", user.getUsername());
    }
}
