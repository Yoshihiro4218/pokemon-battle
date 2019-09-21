package jp.co.pokemon.service.impl;

import jp.co.pokemon.entity.User;
import jp.co.pokemon.repository.UserRepository;
import jp.co.pokemon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByName(String name) {
        Objects.requireNonNull(name, "name must be not null");
        return userRepository.findFirstByName(name);
    }

}