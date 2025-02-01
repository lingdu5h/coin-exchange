package com.lingdu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.domain.UserLoginLog;
import com.lingdu.mapper.UserLoginLogMapper;
import com.lingdu.service.UserLoginLogService;
import org.springframework.stereotype.Service;
@Service
public class UserLoginLogServiceImpl extends ServiceImpl<UserLoginLogMapper, UserLoginLog> implements UserLoginLogService{

}
