package com.wyx.proj.request;

public class GoodsListQueryRequest extends PageRequest {

    private int goodsType;

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }
}
