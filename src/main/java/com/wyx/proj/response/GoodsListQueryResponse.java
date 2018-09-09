package com.wyx.proj.response;

import java.util.Date;
import java.util.List;

public class GoodsListQueryResponse {

    private Long goodsId;
    private String goodsName;
    private List<String> goodsPic;
    private Date createTime;
    private Date updateTime;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<String> getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(List<String> goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
