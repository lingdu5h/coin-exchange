package com.lingdu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.domain.UserAuthAuditRecord;
import com.lingdu.mapper.UserAuthAuditRecordMapper;
import com.lingdu.service.UserAuthAuditRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthAuditRecordServiceImpl extends ServiceImpl<UserAuthAuditRecordMapper, UserAuthAuditRecord> implements UserAuthAuditRecordService{

    /**
     * 获取一个用户的审核记录
     *
     * @param id
     * @return
     */
    @Override
    public List<UserAuthAuditRecord> getUserAuthAuditRecordList(Long id) {
        return list(new LambdaQueryWrapper<UserAuthAuditRecord>()
                    .eq(UserAuthAuditRecord::getUserId ,id)
                    .orderByDesc(UserAuthAuditRecord::getCreated)
                    .last("limit 3")
        );
    }
}
