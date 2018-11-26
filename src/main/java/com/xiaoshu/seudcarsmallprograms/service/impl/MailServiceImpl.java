package com.xiaoshu.seudcarsmallprograms.service.impl;

import com.xiaoshu.seudcarsmallprograms.mapper.MailMapper;
import com.xiaoshu.seudcarsmallprograms.model.Mail;
import com.xiaoshu.seudcarsmallprograms.model.MailTo;
import com.xiaoshu.seudcarsmallprograms.service.MailService;
import com.xiaoshu.seudcarsmallprograms.service.SendMailSevice;
import com.xiaoshu.seudcarsmallprograms.util.ObjectUtils;
import com.xiaoshu.seudcarsmallprograms.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private SendMailSevice sendMailSevice;

    @Autowired
    MailMapper mailMapper;

    @Override
    @Transactional
    public void save(Mail mail, List<String> toUser) {
        mail.setUserId(UserUtil.getCurrentUser().getId());
        mailMapper.insertUseGeneratedKeys(mail);

        toUser.forEach(u -> {
            int status = 1;
            try {
                sendMailSevice.sendMail(u, mail.getSubject(), mail.getContent());
            } catch (Exception e) {
                log.error("发送邮件失败", e);
                status = 0;
            }

            mailMapper.saveToUser(mail.getId(), u, status);
        });
    }

    @Override
    public Mail getById(Long id) {
        return mailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MailTo> getToUsers(Long id) {
        return mailMapper.getToUsers(id);
    }

    @Override
    public Integer selectConditionCount(Map<String, Object> params) {
        Mail mail = (Mail)ObjectUtils.mapToObject(params, Mail.class);
        return mailMapper.selectConditionCount(mail);
    }

    @Override
    public List<Mail> selectConditionList(Map<String, Object> params) {
        Mail mail = (Mail)ObjectUtils.mapToObject(params, Mail.class);
        return mailMapper.selectConditionList(mail);
    }
}
