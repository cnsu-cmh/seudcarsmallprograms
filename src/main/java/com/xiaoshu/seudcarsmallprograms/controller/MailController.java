package com.xiaoshu.seudcarsmallprograms.controller;

import com.xiaoshu.seudcarsmallprograms.annotation.LogAnnotation;
import com.xiaoshu.seudcarsmallprograms.model.Mail;
import com.xiaoshu.seudcarsmallprograms.model.MailTo;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableHandler;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableRequest;
import com.xiaoshu.seudcarsmallprograms.page.table.PageTableResponse;
import com.xiaoshu.seudcarsmallprograms.service.MailService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mails")
public class MailController {

	@Autowired
	private MailService mailService;

	@LogAnnotation(module = "保存并且发送邮件")
	@PostMapping
	@RequiresPermissions("mail:send")
	public Mail save(@RequestBody Mail mail) {
		String toUsers = mail.getToUsers().trim();
		if (StringUtils.isBlank(toUsers)) {
			throw new IllegalArgumentException("收件人不能为空");
		}

		toUsers = toUsers.replace(" ", "");
		toUsers = toUsers.replace("；", ";");
		String[] strings = toUsers.split(";");

		List<String> toUser = Arrays.asList(strings);
		toUser = toUser.stream().filter(u -> !StringUtils.isBlank(u)).map(u -> u.trim()).collect(Collectors.toList());
		mailService.save(mail, toUser);

		return mail;
	}

	/**
	 * 根据id获取邮件
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@RequiresPermissions("mail:all:query")
	public Mail get(@PathVariable Long id) {
		return mailService.getById(id);
	}

	/**
	 * 根据id获取邮件发送详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/to")
	@RequiresPermissions("mail:all:query")
	public List<MailTo> getMailTo(@PathVariable Long id) {
		return mailService.getToUsers(id);
	}

	/**
	 * 邮件列表
	 * @param request
	 * @return
	 */
	@GetMapping
	@RequiresPermissions("mail:all:query")
	public PageTableResponse list(PageTableRequest request) {

		PageTableHandler.CountHandler countHandler = (r) -> mailService.selectConditionCount(r.getParams());
		PageTableHandler.ListHandler listHandler = (r) -> {
			return mailService.selectConditionList(r.getParams());
		};

		return new PageTableHandler(countHandler,listHandler).handle(request);
	}

}

