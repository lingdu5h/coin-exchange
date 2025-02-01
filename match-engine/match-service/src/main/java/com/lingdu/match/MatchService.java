package com.lingdu.match;

import com.lingdu.model.Order;
import com.lingdu.model.OrderBooks;

/**
 * 撮合/交易的接口定义
 */
public interface MatchService {

    /**
     * 进行订单的撮合交易
     * @param order
     */
    void match(OrderBooks orderBooks, Order order) ;
}
