package com.xiaoshu.seudcarsmallprograms.controller;

import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.dto.LayuiFile;
import com.xiaoshu.seudcarsmallprograms.model.FileInfo;
import com.xiaoshu.seudcarsmallprograms.model.ImsAutopartsCarType;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;

	@LogAnnotation(module = "uploadFile")
	@PostMapping
	public FileInfo uploadFile(MultipartFile file) throws IOException {
		return fileService.save(file);
	}

	/**
	 * layui富文本文件自定义上传
	 * 
	 * @param file
	 * @param domain
	 * @return
	 * @throws IOException
	 */
	@LogAnnotation(module = "uploadLayuiFile")
	@PostMapping("/layui")
	public LayuiFile uploadLayuiFile(MultipartFile file, String domain) throws IOException {
		FileInfo fileInfo = fileService.save(file);

		LayuiFile layuiFile = new LayuiFile();
		layuiFile.setCode(0);
		LayuiFile.LayuiFileData data = new LayuiFile.LayuiFileData();
		layuiFile.setData(data);
		data.setSrc(domain + "/files" + fileInfo.getUrl());
		data.setTitle(file.getOriginalFilename());

		return layuiFile;
	}

	@LogAnnotation(module = "listFiles")
	@GetMapping
	@RequiresPermissions("sys:file:query")
	public PageTableResponse listFiles(PageTableRequest request) {

		PageTableHandler.CountHandler countHandler = (r) -> fileService.selectConditionCount(r.getParams());
		PageTableHandler.ListHandler listHandler = (r) -> {
			return fileService.selectConditionList(r.getParams());
		};

		return new PageTableHandler(countHandler,listHandler).handle(request);

	}

	@LogAnnotation(module = "delete")
	@DeleteMapping("/{id}")
	@RequiresPermissions("sys:file:del")
	public void delete(@PathVariable Long id) {
		fileService.delete(id);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取文件")
	public FileInfo get(@PathVariable Long id) {
		return fileService.getById(id);
	}

	@GetMapping("/carId/{cId}")
	@ApiOperation(value = "根据车子id获取车子图片集合")
	public List<FileInfo> getByCId(@PathVariable Long cId) {
		return fileService.getByCId(cId);
	}

	@GetMapping("/wel/carId/{cId}")
	@ApiOperation(value = "根据车子id获取首页展示图片")
	public FileInfo getWelByCId(@PathVariable Long cId) {
		return fileService.getWelByCId(cId);
	}

}
