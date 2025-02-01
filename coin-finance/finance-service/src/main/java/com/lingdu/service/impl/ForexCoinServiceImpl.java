package com.lingdu.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.mapper.ForexCoinMapper;
import com.lingdu.domain.ForexCoin;
import com.lingdu.service.ForexCoinService;

@Service
public class ForexCoinServiceImpl extends ServiceImpl<ForexCoinMapper, ForexCoin> implements ForexCoinService {

}

