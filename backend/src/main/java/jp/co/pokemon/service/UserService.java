package jp.co.pokemon.service;

import jp.co.pokemon.entity.User;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {
    Optional<User> findByName(String name);
    String create(String username, String rawPassword, String email);
    Optional<User> sessionUser(Authentication authentication);
}
