package jp.co.pokemon.props;

import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;
import org.springframework.validation.annotation.*;

import javax.validation.constraints.*;

@Configuration
@ConfigurationProperties(prefix = "example.mail")
@Data
@Validated
public class MailProps {
    @NotEmpty
    @Email
    private String from;
}