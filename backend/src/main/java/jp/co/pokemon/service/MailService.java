package jp.co.pokemon.service;

import jp.co.pokemon.props.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.mail.*;
import org.springframework.stereotype.*;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final MailProps mailProps;
    private final MailSender mailSender;

    public void send(@NonNull String subject, @NonNull String addressTo, @NonNull String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(addressTo);
        msg.setFrom(mailProps.getFrom());
        msg.setSubject(subject);
        msg.setText(body);
        mailSender.send(msg);
    }
}
