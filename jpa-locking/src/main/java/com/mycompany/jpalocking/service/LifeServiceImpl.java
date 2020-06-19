package com.mycompany.jpalocking.service;

import com.mycompany.jpalocking.exception.AllLivesRedeemedException;
import com.mycompany.jpalocking.model.Life;
import com.mycompany.jpalocking.repository.LifeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LifeServiceImpl implements LifeService {

    private final LifeRepository lifeRepository;

    @Override
    public List<Life> getAllLives() {
        return lifeRepository.findAll();
    }

    @Override
    public int countAvailableLives() {
        return lifeRepository.countByPlayerIdIsNull();
    }

    @Override
    public Life saveLife(Life life) {
        return lifeRepository.save(life);
    }

    @Override
    public Life getAvailableLife() {
        return lifeRepository.findFirstByPlayerIdIsNull()
                .orElseThrow(() -> new AllLivesRedeemedException("There are no lives to be redeemed."));
    }

}
