package com.xiaoshu.seudcarsmallprograms.service;

import javax.mail.MessagingException;

public interface SendMailSevice {

    void sendMail(String u, String subject, String content) throws MessagingException;
}
