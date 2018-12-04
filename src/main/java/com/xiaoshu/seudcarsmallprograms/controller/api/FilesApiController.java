package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import com.xiaoshu.seudcarsmallprograms.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文件资源接口")
@RestController
public class FilesApiController extends ApiController{

    @Autowired
    private FileService fileService;

    @GetMapping("/files/{id}")
    @ApiOperation(value = "根据id获取文件")
    public FileInfo getFilesById(@PathVariable Long id) {
        return fileService.getById(id);
    }

}
