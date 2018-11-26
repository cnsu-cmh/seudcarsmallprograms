package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.dto.BeanField;
import com.xiaoshu.seudcarsmallprograms.dto.GenerateInput;

import java.util.List;

public interface GenerateService {

    String upperFirstChar(String tableName);

    List<BeanField> selectBeanField(String tableName);

    void saveCode(GenerateInput input);
}
