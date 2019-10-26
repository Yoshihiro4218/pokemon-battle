package jp.co.pokemon.config;

import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
public class FreemarkerConfiguration {
    @Bean
    public freemarker.template.Configuration mailTemplateConfig() {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_27);
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setEncoding(Locale.JAPANESE, "UTF-8");
        return cfg;
    }
}
