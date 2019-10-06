package jp.co.pokemon.service.impl;

import jp.co.pokemon.entity.Pocket;
import jp.co.pokemon.repository.PocketRepository;
import jp.co.pokemon.service.PocketService;
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
    public Optional<List<Pocket>> findByTrainerId(int trainerId) {
        Optional<List<Pocket>> maybePocketPkList = Optional.ofNullable(pocketRepository.findByTrainerId(trainerId));
        log.info("PocketPkList={}", maybePocketPkList);
        return maybePocketPkList;
    }
}
