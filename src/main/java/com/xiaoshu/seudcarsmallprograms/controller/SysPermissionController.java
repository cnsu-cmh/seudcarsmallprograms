package com.xiaoshu.seudcarsmallprograms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.model.SysPermission;
import com.xiaoshu.seudcarsmallprograms.model.SysUser;
import com.xiaoshu.seudcarsmallprograms.service.SysPermissionService;
import com.xiaoshu.seudcarsmallprograms.util.UserUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permissions")
public class SysPermissionController {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private SysPermissionService permissionService;

    @LogAnnotation(module = "permissionsCurrent")
    @GetMapping("/current")
    public List<SysPermission> permissionsCurrent() {
        List<SysPermission> list = UserUtil.getCurrentPermissions();
        if (list == null) {
            SysUser user = UserUtil.getCurrentUser();
            list = permissionService.selectByUserId(user.getId());
            UserUtil.setPermissionSession(list);
        }
        final List<SysPermission> permissions = list.stream().filter(l -> l.getType().equals(1))
                .collect(Collectors.toList());

        List<SysPermission> firstLevel = permissions.stream().filter(p -> p.getParentId().equals(0L)).collect(Collectors.toList());
        firstLevel.parallelStream().forEach(p -> {
            setChild(p, permissions);
        });

        return firstLevel;
    }

    private void setChild(SysPermission p, List<SysPermission> permissions) {
        List<SysPermission> child = permissions.parallelStream().filter(a -> a.getParentId().equals(p.getId())).collect(Collectors.toList());
        p.setChild(child);
        if (!CollectionUtils.isEmpty(child)) {
            child.parallelStream().forEach(c -> {
                //递归设置子元素，多级菜单支持
                setChild(c, permissions);
            });
        }
    }

    /**
     * 校验权限
     *
     * @return
     */
    @LogAnnotation(module = "ownsPermission")
    @GetMapping("/owns")
    public Set<String> ownsPermission() {
        List<SysPermission> permissions = UserUtil.getCurrentPermissions();
        if (CollectionUtils.isEmpty(permissions)) {
            return Collections.emptySet();
        }

        return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getPermission()))
                .map(SysPermission::getPermission).collect(Collectors.toSet());
    }

    @LogAnnotation(module = "permissionsList")
    @GetMapping
    @RequiresPermissions("sys:menu:query")
    public List<SysPermission> permissionsList() {
        List<SysPermission> permissionsAll = permissionService.selecttAll();

        List<SysPermission> list = Lists.newArrayList();
        setPermissionsList(0L, permissionsAll, list);

        return list;
    }

    private void setPermissionsList(Long pId, List<SysPermission> permissionsAll, List<SysPermission> list) {
        for (SysPermission per : permissionsAll) {
            if (per.getParentId().equals(pId)) {
                list.add(per);
                if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    setPermissionsList(per.getId(), permissionsAll, list);
                }
            }
        }
    }


    @LogAnnotation(module = "permissionsAll")
    @GetMapping("/all")
    @RequiresPermissions("sys:menu:query")
    public JSONArray permissionsAll() {
        List<SysPermission> permissionsAll = permissionService.selecttAll();
        JSONArray array = new JSONArray();
        setPermissionsTree(0L, permissionsAll, array);

        return array;
    }

    @LogAnnotation(module = "parentMenu")
    @GetMapping("/parents")
    @RequiresPermissions("sys:menu:query")
    public List<SysPermission> parentMenu() {
        List<SysPermission> parents = permissionService.selectParents();

        return parents;
    }

    /**
     * 菜单树
     *
     * @param pId
     * @param permissionsAll
     * @param array
     */
    private void setPermissionsTree(Long pId, List<SysPermission> permissionsAll, JSONArray array) {
        for (SysPermission per : permissionsAll) {
            if (per.getParentId().equals(pId)) {
                String string = JSONObject.toJSONString(per);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);

                if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(per.getId(), permissionsAll, child);
                }
            }
        }
    }

    @LogAnnotation(module = "listByRoleId")
    @GetMapping(params = "roleId")
    @RequiresPermissions(value = { "sys:menu:query", "sys:role:query" }, logical = Logical.OR)
    public List<SysPermission> listByRoleId(Long roleId) {
        return permissionService.selectByRoleId(roleId);
    }

    @LogAnnotation(module = "permission save")
    @PostMapping
    @RequiresPermissions("sys:menu:add")
    public void save(@RequestBody SysPermission permission) {
        permissionService.save(permission);
    }

    @LogAnnotation(module = "permission get")
    @GetMapping("/{id}")
    @RequiresPermissions("sys:menu:query")
    public SysPermission get(@PathVariable Long id) {
        return permissionService.getById(id);
    }

    @LogAnnotation(module = "permission update")
    @PutMapping
    @RequiresPermissions("sys:menu:add")
    public void update(@RequestBody SysPermission permission) {
        permissionService.update(permission);
    }

    @LogAnnotation(module = "permission delete")
    @DeleteMapping("/{id}")
    @RequiresPermissions(value = { "sys:menu:del" })
    public void delete(@PathVariable Long id) {
        permissionService.delete(id);
    }

}
