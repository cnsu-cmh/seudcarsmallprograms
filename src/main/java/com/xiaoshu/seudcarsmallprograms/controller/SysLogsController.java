package com.xiaoshu.seudcarsmallprograms.controller;


import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.SysLogsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class SysLogsController {

    @Autowired
    private SysLogsService sysLogsService;

    @LogAnnotation(module = "log:list")
    @GetMapping
    @RequiresPermissions(value = "sys:log:query")
    public PageTableResponse list(PageTableRequest request) {

        PageTableHandler.CountHandler countHandler = (r) -> sysLogsService.selectConditionCount(r.getParams());
        PageTableHandler.ListHandler listHandler = (r) -> {
            return sysLogsService.selectConditionList(r.getParams(),r.getOffset(), r.getLimit());
        };

        return new PageTableHandler(countHandler,listHandler).handle(request);

    }

}
