package com.lingdu.enums;

public enum OrderDirection {

    BUY(1,"买入") ,
    SELL(2,"卖出") ;

    private int code ;

    private String desc ;


    OrderDirection(int code,String desc){
        this.code = code ;
        this.desc = desc ;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static com.lingdu.enums.OrderDirection getOrderDirection(int code){
        com.lingdu.enums.OrderDirection[] values = values();
        for (com.lingdu.enums.OrderDirection value : values) {
            if(value.getCode()==code){
                return value ;
            }
        }
        return null ;
    }

}
