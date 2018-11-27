package com.xiaoshu.seudcarsmallprograms.controller;

import com.xiaoshu.seudcarsmallprograms.model.Dict;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.DictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dicts")
public class DictController {

	@Autowired
	private DictService dictService;

	@RequiresPermissions("dict:add")
	@PostMapping
	public Dict save(@RequestBody Dict dict) {
		Dict d = dictService.getByTypeAndK(dict.getType(), dict.getK());
		if (d != null) {
			throw new IllegalArgumentException("类型和key已存在");
		}
		dictService.save(dict);

		return dict;
	}

	@GetMapping("/{id}")
	public Dict get(@PathVariable Long id) {
		return dictService.getById(id);
	}

	@RequiresPermissions("dict:add")
	@PutMapping
	public Dict update(@RequestBody Dict dict) {
		dictService.update(dict);

		return dict;
	}

	@RequiresPermissions("dict:query")
	@GetMapping(params = { "start", "length" })
	public PageTableResponse list(PageTableRequest request) {
		PageTableHandler.CountHandler countHandler = (r) -> dictService.selectConditionCount(r.getParams());
		PageTableHandler.ListHandler listHandler = (r) -> {
			return dictService.selectConditionList(r.getParams());
		};

		return new PageTableHandler(countHandler,listHandler).handle(request);
	}

	@RequiresPermissions("dict:del")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		dictService.delete(id);
	}

	@GetMapping(params = "type")
	public List<Dict> listByType(String type) {
		return dictService.selectByType(type);
	}
}

