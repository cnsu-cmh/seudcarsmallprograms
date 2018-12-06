package com.xiaoshu.seudcarsmallprograms.controller.api;

import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "数据字典接口")
@RestController
public class DictApiController extends ApiController {

    @Autowired
    private DictService dictService;

    @GetMapping(value = "/dict", params = "type" )
    @ResponseBody
    @ApiOperation(value = "根据type获取字典")
    @ApiImplicitParam(name = "type",value = "字典类型,比如sex",dataType = "String",paramType = "query")
    public List<Dict> listByType(String type) {
        return dictService.selectByType(type);
    }

    @GetMapping(value = "/dict/allType")
    @ResponseBody
    @ApiOperation(value = "所有字典类型")
    public List<Map<String,String>> listAllType() {
        return dictService.selectAllType();
    }

    @GetMapping(value = "/dict/listValByType", params = "type" )
    @ResponseBody
    @ApiOperation(value = "根据type获取字典val")
    @ApiImplicitParam(name = "type",value = "字典类型,比如sex",dataType = "String",paramType = "query")
    public List<String> listValByType(String type) {
        List<String> val = dictService.selectValByType(type);
        if("carLevel".equals(type)) {
            val.add(0,"不限");
        }
        return val;
    }
}
