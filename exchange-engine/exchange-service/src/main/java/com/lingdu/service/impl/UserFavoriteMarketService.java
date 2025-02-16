package com.lingdu.service.impl;

import com.lingdu.domain.UserFavoriteMarket;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserFavoriteMarketService extends IService<UserFavoriteMarket>{


    /**
     * 用户取消收藏
     * @param marketId
     * @param userId
     * @return
     */
    boolean deleteUserFavoriteMarket(Long marketId, Long userId);
}
