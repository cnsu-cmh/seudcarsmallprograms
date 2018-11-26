package com.xiaoshu.seudcarsmallprograms.controller;


import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.dto.RoleDto;
import com.xiaoshu.seudcarsmallprograms.model.SysRole;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.SysRoleService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @LogAnnotation(module = "listRoles")
    @GetMapping
    @RequiresPermissions("sys:role:query")
    public PageTableResponse listRoles(PageTableRequest request) {
        PageTableHandler.CountHandler countHandler = (r) -> roleService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> {
            return roleService.selectConditionList(r.getParams());
        };

        return new PageTableHandler(countHandler,listHandler).handle(request);
    }

    @LogAnnotation(module = "selectAll")
    @GetMapping("/all")
    @RequiresPermissions(value = { "sys:user:query", "sys:role:query" }, logical = Logical.OR)
    public List<SysRole> roles() {
        return roleService.selectAll();
    }

    @LogAnnotation(module = "selectByUserId")
    @GetMapping(params = "userId")
    @RequiresPermissions(value = { "sys:user:query", "sys:role:query" }, logical = Logical.OR)
    public List<SysRole> roles(Long userId) {
        return roleService.selectByUserId(userId);
    }

    @LogAnnotation(module = "role:add")
    @PostMapping
    @RequiresPermissions("sys:role:add")
    public void saveRole(@RequestBody RoleDto roleDto) {
        roleService.saveRole(roleDto);
    }

    @LogAnnotation(module = "deleteRole")
    @DeleteMapping("/{id}")
    @RequiresPermissions(value = { "sys:role:del" })
    public void delete(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

    @LogAnnotation(module = "getById")
    @GetMapping("/{id}")
    @RequiresPermissions("sys:role:query")
    public SysRole get(@PathVariable Long id) {
        return roleService.getById(id);
    }

}
