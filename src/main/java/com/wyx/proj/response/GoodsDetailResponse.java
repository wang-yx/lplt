package com.wyx.proj.response;

import java.util.Date;
import java.util.List;

public class GoodsDetailResponse {
    private Long goodsId;

    private List<String> goodsPic;

    private String goodsDetail;

    private Date createTime;

    private Date updateTime;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public List<String> getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(List<String> goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
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
