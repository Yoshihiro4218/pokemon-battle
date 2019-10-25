package jp.co.pokemon.helper;

import freemarker.template.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

@Component
@AllArgsConstructor
public class TemplateHelper {
    private final Configuration config;

    public String createTemplate(@NonNull String fileName, @NonNull Map<String, Object> templateVar) {
        try (Writer out = new StringWriter()) {
            Template template = config.getTemplate(fileName, StandardCharsets.UTF_8.displayName());
            template.process(templateVar, out);
            out.flush();
            return out.toString();
        } catch (IOException | TemplateException e) {
            throw new TemplateProcessingException("Couldn't process template:" + fileName, e);
        }
    }

    public static class TemplateProcessingException extends RuntimeException {
        public TemplateProcessingException(@NonNull String message, @NonNull Throwable cause){
            super(message, cause);
        }
    }
}
