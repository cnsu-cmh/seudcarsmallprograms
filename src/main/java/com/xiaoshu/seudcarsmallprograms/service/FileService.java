package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileService {

    FileInfo save(MultipartFile file) throws IOException;

    Integer selectConditionCount(Map<String, Object> params);

    List<FileInfo> selectConditionList(Map<String, Object> params);

    void delete(Long id);

    FileInfo getById(Long id);

    List<FileInfo> getByCId(Long cId);

    FileInfo getWelByCId(Long cId);
}
