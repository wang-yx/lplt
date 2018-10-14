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

# 首页

### 产品列表

    post
    http://.../product/list/homePage
    
    body
    {
        
    }
    
    result
    {
       "status":0,
       "data":[
            {
                 "productId":123456789L,
                 "productName":"",
                 "productPic":"key",
                 "createTime":yyyy-MM-dd HH:mm:ss
            }
       ]
    }
 
### 图片

    get
    http://.../imgae/list/homePage
    
    result
    {
        "status":0,
        "data":[
            "key1",
            "key2"
        ]
    }


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

# 新闻接口

## 新闻增加/更新接口
 
    post
    http://.../news/save
    
    body
    {
     "newsId":123456789L,        //新闻ID，有表示更新，没有表示增加
     "newsTitle":"新闻title",
     "picKey":"图片key",
     "newsDetail":""             //新闻详情
    }
    
    result
    {
     "status":0,
     "data":"success"
    }
    
## 查询新闻列表
   
    post
    http://.../news/list
    
    body
    {
        "page":{
            "pageNo":1,
            "pageSize":15
        }
    }
    
    result
    {
    "status":0,
    "data":{
            "page":{
                "curPage":1,
                "pageSize":15,
                "totalSize":100,
                "totalPage":7
            },
            data":[
               {
                  "newsId":123456789L,
                  "newsTitle":"",
                  "picKey":"",
                  "introduce":"",
                  "createTime":yyyy-MM-dd HH:mm:ss
               }
            ]
        }
    }

## 查询新闻详情

    post
    http://.../new/detail
    
    body
    {
      "newId":""
    }
    
    result
    {
        "status":0,
        "data":{
             "newsId":123456789L,
             "newsTitle":"",
             "picKey":"",
             "newsDetail":"",
             "readNum":10,
             "createTime":yyyy-MM-dd HH:mm:ss
             "updateTime":yyyy-MM-dd HH:mm:ss
        }
    }

# 产品接口

## 产品增加

    post
    http://.../product/save
    
    body
    {
     "productId":123456789L,       //没有表示新增
     "productPic":"",
     "productName":"",
     "productIntroduce":"简介",
     "productDetail":""            //产品描述
    }
    
    result
    {
     "status":0,
     "data":"success"
    }



## 产品列表

    post
    http://.../product/list
    
    body
    {
        "page":{
            "pageNo":1,
            "pageSize":"15"
        }
    }
    
    result
    {
       "status":0,
       "data":{
          "page":{
              "curPage":1,
              "pageSize":15,
              "totalSize":100,
              "totalPage":7
          },
          data":[
             {
                "productId":123456789L,
                 "productName":"",
                 "productPic":"key",
                 "createTime":yyyy-MM-dd HH:mm:ss,
                 "updateTime":yyyy-MM-dd HH:mm:ss
             }
          ]
      }
    }
  
## 产品详情
 
    post
    http://.../product/detail
    
    body
    {
     "productId":123456789,       //商品ID
    }
    
    result
    {
     "stataus":0,
     "data":{
         "productId":123456789L,
         "productName":"名称",
         "productIntroduce":"简介",
         "productPic":"",
         "productDetail":"",
         "createTime":yyyy-MM-dd HH:mm:ss,
         "updateTime":yyyy-MM-dd HH:mm:ss
     }
    }