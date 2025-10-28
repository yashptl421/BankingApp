package com.yash.banking.notification_service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static com.yash.banking.notification_service.email.EmailTemplates.ACCOUNT_CONFIRMATION;
import static com.yash.banking.notification_service.email.EmailTemplates.REGISTRATION_CONFIRMATION;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    @Value("${email.fromEmail}")
    private String fromEmail;

    @Async
    public void sendRegistrationSuccessEmail(
            String destinationEmail,
            String customerName,
            Long customerId,
            Long aadharNumber
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom(fromEmail);

        final String templateName = REGISTRATION_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", customerName);
        variables.put("customerId", customerId);
        variables.put("aadharNumber", aadharNumber);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(REGISTRATION_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
        }

    }

    @Async
    public void sendAccountCreatedSuccessEmail(
            String destinationEmail,
            String customerName,
            String accountType,
            BigInteger accountNumber
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom(fromEmail);

        final String templateName = ACCOUNT_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", customerName);
        variables.put("accountNumber", accountNumber);
        variables.put("accountType", accountType);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(ACCOUNT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
        }

    }

    public String
    sendMailWithAttachment(String destinationEmail) {
        // Creating a mime message
        MimeMessage mimeMessage
                = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("example@gmail.com");
            mimeMessageHelper.setTo(destinationEmail);
            mimeMessageHelper.setText("Documents are attached");
            mimeMessageHelper.setSubject("Email from Notification Service");

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File("/Users/yashpatel/Downloads/IMG_6014.jpg"));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            System.out.println("Message  = " + mimeMessage);
            // Sending the mail
            mailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}
