package jp.co.pokemon.repository;

import jp.co.pokemon.entity.Pocket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PocketRepository {
    List<Pocket> findByTrainerId(int trainerId);
}
