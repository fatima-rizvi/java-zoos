package com.lambdaschool.zoo.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Spring Boot needs to know what username to use for the auditing fields CreatedBy and ModifiedBy
 * For now, a default name will be used
 */
@Component
public class UserAuditing implements AuditorAware<String>
{

    @Override
    public Optional<String> getCurrentAuditor() {
        String uname;
        uname = "***SYSTEM***";
        return Optional.of(uname);
    }
}
