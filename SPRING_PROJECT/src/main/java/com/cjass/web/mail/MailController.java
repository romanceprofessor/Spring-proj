package com.cjass.web.mail;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//
//@Controller
//public class MailController {
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	private String from = "developerlyk@gmail.com";
//	private String subject = "SPRING_PROJECT";
//
//	@RequestMapping(value = "/mail")
//	@ResponseBody
//	public String sendMail(@RequestParam Map map) {
//		Gson gson = new Gson();
//		Map resultMap = new HashMap();
//
//		try {
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//			messageHelper.setTo(map.get("mail").toString());
//			messageHelper.setText("Hello World!");
//			messageHelper.setFrom(from);
//			messageHelper.setSubject(subject);
//
//			mailSender.send(message);
//
//			map.put("isSuccess", "Y");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			//System.out.println(e);
//			map.put("isSuccess", "N");
//		}
//
//		return gson.toJson(map);
//	}
//
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * https://shared.co.kr/219
 *
 */
@Controller
public class MailController {

    // 구글 이메일
    static final String user_email = "a@gmail.com";
    // 구글 비번
    static final String user_pw = "a";

    static final String smtp_host = "smtp.gmail.com";
    static final int smtp_port = 465; // TLS : 587, SSL : 465

    @RequestMapping(value = "/mail")
    @ResponseBody
    public String sendMail(@RequestParam Map map) {
        Gson gson = new Gson();
        Map resultMap = new HashMap();

        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", smtp_host);
            props.put("mail.smtp.port", smtp_port);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.trust", smtp_host);

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user_email, user_pw);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user_email));

            // 받는 이메일
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(map.get("mail").toString()));

            // 제목
            message.setSubject("테스트 메일입니다.");

            // 내용
            message.setText("이것은 테스트 메일입니다. \n\n 잘 갔나요");

            // 발송
            Transport.send(message);

            resultMap.put("isSuccess", "Y");

        } catch (MessagingException e) {
            e.printStackTrace();
            resultMap.put("isSuccess", "N");
        }

        return gson.toJson(resultMap);
    }
}
