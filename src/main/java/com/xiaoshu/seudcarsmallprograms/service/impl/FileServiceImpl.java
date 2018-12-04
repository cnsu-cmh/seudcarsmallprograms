package com.xiaoshu.seudcarsmallprograms.service.impl;

import com.xiaoshu.seudcarsmallprograms.mapper.FileInfoMapper;
import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import com.xiaoshu.seudcarsmallprograms.service.FileService;
import com.xiaoshu.seudcarsmallprograms.util.FileUtil;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Value("${files.path}")
    private String filesPath;

    @Autowired
    private FileInfoMapper fileInfoMapper;


    @Override
    public FileInfo save(MultipartFile file) throws IOException{
        FileInfo fileInfo = multipartFile2FileInfo(file,null,null);
        log.debug("上传文件{}" );
        return fileInfo;
    }
    @Override
    public FileInfo multipartFile2FileInfo(MultipartFile file, Long cId, Integer cType)  throws IOException {
        String fileOrigName = file.getOriginalFilename();
        if (!fileOrigName.contains(".")) {
            throw new IllegalArgumentException("缺少后缀名");
        }

        String md5 = FileUtil.fileMd5(file.getInputStream());
        Example example = new Example(FileInfo.class);
        example.createCriteria().andEqualTo("md5", md5);
        FileInfo fileInfo = fileInfoMapper.selectOneByExample(example);
        if (fileInfo != null) {
            fileInfo.setcType(cType);
            fileInfo.setcId(cId);
            fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
            return fileInfo;
        }

        fileOrigName = fileOrigName.substring(fileOrigName.lastIndexOf("."));
        String pathname = FileUtil.getPath() + md5 + fileOrigName;
        String fullPath = filesPath + pathname;
        FileUtil.saveFile(file, fullPath);

        long size = file.getSize();
        String contentType = file.getContentType();

        fileInfo = new FileInfo();
        fileInfo.setMd5(md5);
        fileInfo.setContentType(contentType);
        fileInfo.setSize(size);
        fileInfo.setPath(fullPath);
        fileInfo.setUrl(pathname);
        fileInfo.setType(contentType.startsWith("image/") ? 1 : 0);
        fileInfo.setcType(cType);
        fileInfo.setcId(cId);
        fileInfoMapper.insertSelective(fileInfo);
        return fileInfo;
    }

    @Override
    public List<FileInfo> getByCIdAndCType(Long cId, Integer cType) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setcId(cId);
        fileInfo.setcType(cType);
        return fileInfoMapper.select(fileInfo);
    }


    @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        FileInfo fileInfo = (FileInfo)ObjectUtils.mapToObject(params, FileInfo.class);
        return fileInfoMapper.selectConditionCount(fileInfo);
    }

    @Override
    public List<FileInfo> selectConditionList(Map<String, Object> params) {
        FileInfo fileInfo = (FileInfo)ObjectUtils.mapToObject(params, FileInfo.class);
        return fileInfoMapper.selectConditionList(fileInfo);
    }

    @Override
    public void delete(Long id) {
        FileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(id);
        if (fileInfo != null) {
            String fullPath = fileInfo.getPath();
            FileUtil.deleteFile(fullPath);

            fileInfoMapper.deleteByPrimaryKey(id);
            log.debug("删除文件：{}", fileInfo.getPath());
        }
    }

    @Override
    public FileInfo getById(Long id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

}
