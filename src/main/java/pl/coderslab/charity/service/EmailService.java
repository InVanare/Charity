package pl.coderslab.charity.service;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.utility.Template;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

@Component
public class EmailService {

    private JavaMailSender javaMailSender;
    private Template template;
    private final String MAIL_HOST = "noreply@serwer2206560.home.pl";

    @Autowired
    public EmailService(JavaMailSender javaMailSender, Template template) {
        this.javaMailSender = javaMailSender;
        this.template = template;
    }

    public void sendMessageFromTemplate(String to, String subject, String nameTemplate, Map<String, Object> model) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(MAIL_HOST);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(template.getContentFromTemplate(nameTemplate, model), true);
            javaMailSender.send(message);
        } catch (MessagingException | TemplateException | IOException e) {
            e.printStackTrace();
        }

    }
}
