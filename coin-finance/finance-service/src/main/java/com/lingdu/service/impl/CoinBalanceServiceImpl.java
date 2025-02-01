package com.lingdu.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.domain.CoinBalance;
import com.lingdu.mapper.CoinBalanceMapper;
import com.lingdu.service.CoinBalanceService;

@Service
public class CoinBalanceServiceImpl extends ServiceImpl<CoinBalanceMapper, CoinBalance> implements CoinBalanceService {

}

