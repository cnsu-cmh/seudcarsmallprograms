package com.xiaoshu.seudcarsmallprograms.service;

import com.xiaoshu.seudcarsmallprograms.model.Mail;
import com.xiaoshu.seudcarsmallprograms.model.MailTo;

import java.util.List;
import java.util.Map;

public interface MailService {

    void save(Mail mail, List<String> toUser);

    Mail getById(Long id);

    List<MailTo> getToUsers(Long id);

    Integer selectConditionCount(Map<String, Object> params);

    List<Mail> selectConditionList(Map<String, Object> params);
}
