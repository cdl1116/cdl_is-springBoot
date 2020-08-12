package com.cdl.spring_boot_test2.modules.test.service;

import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.test.entity.Card;

public interface CardService {
    Result<Card> insertCard(Card card);
}
