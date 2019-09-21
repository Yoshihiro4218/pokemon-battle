package jp.co.pokemon.repository;

import jp.co.pokemon.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("")
    Optional<User> findByEmail(String email);
}
