package jp.co.pokemon.service;

import jp.co.pokemon.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByName(String name);
}
