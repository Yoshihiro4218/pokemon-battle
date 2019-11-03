package jp.co.pokemon.service.impl;

import jp.co.pokemon.entity.Pocket;
import jp.co.pokemon.repository.PocketRepository;
import jp.co.pokemon.service.PocketService;
import jp.co.pokemon.util.With;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PocketServiceImpl implements PocketService {

    private final PocketRepository pocketRepository;

    @Override
    public Optional<List<Pocket>> findByTrainerIdOrderByPosition(int trainerId) {
        Optional<List<Pocket>> maybePocketPkList = Optional.ofNullable(pocketRepository.findByTrainerIdOrderByPosition(trainerId));
        log.info("PocketPkList={}", maybePocketPkList);
        return maybePocketPkList;
    }

    @Override
    public void updateMyPokes(int trainerId, List<Integer> pokeList) {
        pocketRepository.delete(trainerId);
        pokeList.forEach(With.index(0, (poke, idx) -> {
            pocketRepository.create(
                    Pocket.builder()
                          .trainerId(trainerId)
                          .position(idx)
                          .pkId(poke)
                          .build());
        }));
    }
}
