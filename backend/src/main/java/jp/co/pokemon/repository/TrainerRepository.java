package jp.co.pokemon.repository;

import jp.co.pokemon.entity.Trainer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainerRepository {
    @Select("SELECT * FROM trainer WHERE user_id = #{userId}")
    List<Trainer> findByUserId(int userId);
}
