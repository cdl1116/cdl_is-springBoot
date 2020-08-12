package com.cdl.spring_boot_test2.modules.test.service.impl;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.test.entity.Card;
import com.cdl.spring_boot_test2.modules.test.repository.CardRepository;
import com.cdl.spring_boot_test2.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    @Transactional
    public Result<Card> insertCard(Card card) {
        cardRepository.saveAndFlush(card);
        return new Result<Card>(Result.ResultStatus.SUCCESS.status,
                "Insert success",card);
    }
}
