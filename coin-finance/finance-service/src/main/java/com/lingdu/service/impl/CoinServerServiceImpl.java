package com.lingdu.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.mapper.CoinServerMapper;
import com.lingdu.domain.CoinServer;
import com.lingdu.service.CoinServerService;

@Service
public class CoinServerServiceImpl extends ServiceImpl<CoinServerMapper, CoinServer> implements CoinServerService {

}

