package com.xiaoshu.seudcarsmallprograms.controller;


import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.dto.BeanField;
import com.xiaoshu.seudcarsmallprograms.dto.GenerateDetail;
import com.xiaoshu.seudcarsmallprograms.dto.GenerateInput;
import com.xiaoshu.seudcarsmallprograms.service.GenerateService;
import com.xiaoshu.seudcarsmallprograms.util.ConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generate")
public class GenerateController {

    @Autowired
    private GenerateService generateService;

    @LogAnnotation(module = "generateByTableName")
    @GetMapping(params = { "tableName" })
    @RequiresPermissions("generate:edit")
    public GenerateDetail generateByTableName(String tableName) {
        if(StringUtils.isBlank(tableName)){
            throw new IllegalArgumentException("tableName表名称不能为空");
        }
        ConfigUtil configUtil = ConfigUtil.getInstance("generator/bgm.properties");
        String explorerDir = (String)configUtil.getValue("explorerDir");
        GenerateDetail detail = new GenerateDetail(explorerDir);
        detail.setBeanName(generateService.upperFirstChar(tableName));
        List<BeanField> fields = generateService.selectBeanField(tableName);
        detail.setFields(fields);
        return detail;
    }

    @LogAnnotation(module = "save")
    @PostMapping
    @RequiresPermissions("generate:edit")
    public void save(@RequestBody GenerateInput input) {
        generateService.saveCode(input);
    }
}
