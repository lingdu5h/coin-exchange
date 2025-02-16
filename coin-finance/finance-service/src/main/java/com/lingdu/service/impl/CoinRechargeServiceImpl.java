package com.lingdu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingdu.domain.CoinRecharge;
import com.lingdu.dto.UserDto;
import com.lingdu.feign.UserServiceFeign;
import com.lingdu.mapper.CoinRechargeMapper;
import com.lingdu.service.CoinRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CoinRechargeServiceImpl extends ServiceImpl<CoinRechargeMapper, CoinRecharge> implements CoinRechargeService {

    @Autowired
    private UserServiceFeign userServiceFeign ;
    /**
     * 分页条件查询充值记录
     *
     * @param page      分页参数
     * @param coinId    币种的Id
     * @param userId    用户的Id
     * @param userName  用户的名称
     * @param mobile    用户的手机号
     * @param status    充值的状态
     * @param numMin    充值的最小金额
     * @param numMax    充值的最大金额
     * @param startTime 充值的开始时间
     * @param endTime   充值的截至时间
     * @return
     */
    @Override
    public Page<CoinRecharge> findByPage(Page<CoinRecharge> page, Long coinId, Long userId, String userName, String mobile, Byte status, String numMin, String numMax, String startTime, String endTime) {
        LambdaQueryWrapper<CoinRecharge> coinRechargeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 1 若用户本次的查询中,带了用户的信息userId, userName,mobile ----> 本质就是要把用户的Id 放在我们的查询条件里面
        Map<Long, UserDto> basicUsers = null;
        if (userId != null || !StringUtils.isEmpty(userName) | !StringUtils.isEmpty(mobile)) { // 使用用户的信息查询
            // 需要远程调用查询用户的信息
            basicUsers = userServiceFeign.getBasicUsers(userId == null ? null : Arrays.asList(userId), userName, mobile);
            if (CollectionUtils.isEmpty(basicUsers)) { // 找不到这样的用户->
                return page;
            }
            Set<Long> userIds = basicUsers.keySet();
            coinRechargeLambdaQueryWrapper.in(!CollectionUtils.isEmpty(userIds), CoinRecharge::getUserId, userIds);
        }
        // 2 若用户本次的查询中,没有带了用户的信息
        coinRechargeLambdaQueryWrapper.eq(coinId != null, CoinRecharge::getCoinId, coinId)
                .eq(status != null, CoinRecharge::getStatus, status)
                .between(
                        !(StringUtils.isEmpty(numMin) || StringUtils.isEmpty(numMax)),
                        CoinRecharge::getAmount,
                        new BigDecimal(StringUtils.isEmpty(numMin) ? "0" : numMin),
                        new BigDecimal(StringUtils.isEmpty(numMax) ? "0" : numMax)
                )
                .between(
                        !(StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)),
                        CoinRecharge::getCreated,
                        startTime, endTime + " 23:59:59"
                );
        Page<CoinRecharge> coinRechargePage = page(page, coinRechargeLambdaQueryWrapper);
        List<CoinRecharge> records = coinRechargePage.getRecords();
        if (!CollectionUtils.isEmpty(records)) {
            List<Long> userIds = records.stream().map(CoinRecharge::getUserId).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(basicUsers)) {
                basicUsers = userServiceFeign.getBasicUsers(userIds, null, null);
            }
            Map<Long, UserDto> finalBasicUsers = basicUsers;
            records.forEach(coinRecharge -> { // 设置用户相关的数据
                UserDto userDto = finalBasicUsers.get(coinRecharge.getUserId());
                if (userDto != null) {
                    coinRecharge.setUsername(userDto.getUsername()); // 远程调用查询用户的信息
                    coinRecharge.setRealName(userDto.getRealName());
                }
            });
        }

        return coinRechargePage;
    }

    /**
     * 查询用户充币记录
     *
     * @param page   分页参数
     * @param coinId 币种的Id
     * @param userId 用户的ID
     * @return
     */
    @Override
    public Page<CoinRecharge> findUserCoinRecharge(Page<CoinRecharge> page, Long coinId, Long userId) {
        return page(page,new LambdaQueryWrapper<CoinRecharge>()
                        .eq(coinId!=null,CoinRecharge::getCoinId,coinId)
                        .eq(CoinRecharge::getUserId ,userId)
        );
    }
}

