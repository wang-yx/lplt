# 统一返回结果格式

    {
        "status":0,
        "data":{}
    }
    或
    {
        "status":0,
        "data":[
        ]
    }
    或
    {
        "status":0,
        "data":""
    }
    status为0时为正常返回
 
# 统一时间格式
 
    yyyy-MM-dd HH:mm:ss
    
# 接口说明
    
    当前端页面有登录的用户的时候，将userId放到header中

# 通用接口

## 图片上传接口

    post
    http://.../image/update?key=....
 
    body：文件流
 
## 图片下载接口

    get
    http://.../image/get?key=...

# 后台接口

## 登录

    post
    http://.../user/login
    
    body
    {
        "userName":"admin",
        "password":"admin"
    }
    
    result
    {
        "status":0.
        "data":"success"
    }

## 更新首页展示图片

     post
     http://.../
     
     body
     {
          "originalKey":"",  //需要替换的图片key，为空时表示新增
          "currentKey":""   //更新后的图片key，不允许为空
     }
     
     result
     {
          "status":0,
          "data":"success"
     }
 
## 新闻查询接口同前台接口

## 新闻增加/更新接口
    
    post
    http://.../news/save
    
    body
    {
        "newsId":123456789L,        //新闻ID，有表示更新，没有表示增加
        "newsType":1,               //新闻类型
        "newsDetail":""             //新闻详情
    }
    
    result
    {
        "status":0,
        "data":"success"
    }

## 商品查询接口同前台接口

## 商品增加

    post
    http://.../goods/save
    
    body
    {
        "goodsId":123456789L,       //没有表示新增
        "goodsType":1,              //商品类型
        "goodsPic":[                //商品图片
            "123",
            "456"
        ],
        "goodsDetail":""            //商品描述
    }
    
    result
    {
        "status":0,
        "data":"success"
    }

# 前台接口

## 查询新闻列表
 
     post
     http://.../news/list/query
     
     body
     {
          "newsType":1,
          "size":5
     }
     
     result
     {
          "status":0,
          "data":[
               {
                    "newsId":123456789L,
                    "newsTitle":"",
                    "createTime":yyyy-MM-dd HH:mm:ss
                    "updateTime":yyyy-MM-dd HH:mm:ss
               }
          ]
     }
 
## 查询新闻详情

     post
     http://.../new/detail/query
     
     body
     {
        "newId":""
     }
     
     result
     {
          "status":0,
          "data":{
               "newsId":123456789L,
               "newsDetail":"",
               "createTime":yyyy-MM-dd HH:mm:ss,
               "updateTime":yyyy-MM-dd HH:mm:ss
          }
     }
 
## 商品列表

     post
     http://.../goods/list/query
     
     body
     {
        "goodsType":1,
        "size":5
     }
     
     result
     {
          "status":0,
          "data":[
               {
                    "goodsId":123456789L,
                    "goodsName":"",
                    "goodsPic":[
                         "123",
                         "456"
                    ],
                    "createTime":yyyy-MM-dd HH:mm:ss,
                    "updateTime":yyyy-MM-dd HH:mm:ss
               }
          ]
     }
     
## 商品详情
    
    post
    http://.../goods/detail
    
    body
    {
        "goodsId":123456789L,       //商品ID
    }
    
    result
    {
        "stataus":0,
        "data":{
            "goodsId":123456789L,
            "goodsPic":[
                "123",
                "456"
            ],
            "goodsDetail":"",
            "createTime":yyyy-MM-dd HH:mm:ss,
            "updateTime":yyyy-MM-dd HH:mm:ss
        }
    }