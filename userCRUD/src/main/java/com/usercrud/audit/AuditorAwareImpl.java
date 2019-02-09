package com.usercrud.audit;
import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Harsh");
        // Use below commented code when will use Spring Security.
    }
    //http://www.javaguides.net/2018/09/spring-data-jpa-auditing-with-spring-boot2-and-mysql-example.html
}