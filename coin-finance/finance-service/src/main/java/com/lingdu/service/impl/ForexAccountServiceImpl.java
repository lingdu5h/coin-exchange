package com.lingdu.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.mapper.ForexAccountMapper;
import com.lingdu.domain.ForexAccount;
import com.lingdu.service.ForexAccountService;

@Service
public class ForexAccountServiceImpl extends ServiceImpl<ForexAccountMapper, ForexAccount> implements ForexAccountService {

}

