package jp.co.pokemon.repository;

import jp.co.pokemon.entity.Pocket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PocketRepository {
    @Select("SELECT * FROM pocket_pk WHERE trainer_id = #{trainerId}")
    List<Pocket> findByTrainerId(int trainerId);
}
