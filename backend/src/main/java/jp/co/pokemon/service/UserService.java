package jp.co.pokemon.service;

import jp.co.pokemon.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    public Optional<User> findByName(String name) {
        // TODO
        log.info("name={}", name);
        User tmpUser = new User();
        tmpUser.setName("testName");
        Optional<User> maybeUser = Optional.of(tmpUser);

        return maybeUser;
    }
}
