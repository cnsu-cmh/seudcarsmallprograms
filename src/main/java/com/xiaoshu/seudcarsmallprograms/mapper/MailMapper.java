package com.xiaoshu.seudcarsmallprograms.mapper;

import com.xiaoshu.seudcarsmallprograms.model.Mail;
import com.xiaoshu.seudcarsmallprograms.model.MailTo;
import com.xiaoshu.seudcarsmallprograms.util.MyMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MailMapper extends MyMapper<Mail> {

    @Insert("insert into mail_to(mail_id, to_user, status) values(#{mailId}, #{toUser}, #{status})")
    int saveToUser(@Param("mailId") Long mailId, @Param("toUser") String toUser, @Param("status") int status);

    @Select("select t.* from mail_to t where t.mail_id = #{mailId}")
    List<MailTo> getToUsers(Long id);
}
