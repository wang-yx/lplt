图片上传：
url：/lplt/image/update
方式：POST
参数：文件
返回值：
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 3,
        "imgKey": "img1541304485445.png",
        "imgPath": "/Users/baidu/soft/workspace/workspace-test/lplt/img1541304485445.png",
        "imgCatg": null,
        "imgComment": "20180821135728.png",
        "createTime": null,
        "isRelease": 0,
        "releaseTime": null
    },
    "extendInfo": null
}

首页图片list
/lplt/image/searchMainPagePics
方式：get
参数：无
返回值：


首页图片上传
/lplt/image/updateBase64Pic
方式：post
参数：
String base64Str
String pictureInfo:
"{
 	'id': 1,
 	'imgPath': '',
 	'imgCatg': '9',
 	'imgComment': 'imgComment',
 	'isRelease': 1
 }"


图片删除
/lplt/image/deletePic
方式：post
参数：String pictureInfo: 
"{
 	'id': 1,
 	'imgPath': '',
 	'imgCatg': '9',
 	'imgComment': 'imgComment',
 	'isRelease': 1
 }"

----------------------------------------------------------------
新闻相关：
/lplt/news/list
方式：POST
参数：需要什么传什么
{
  "name": "aaaaa",
  "isrelease": 1,
  "starttime": "2018-10-01 00:00:00",
  "endtime": "2018-10-11 00:00:00",
  "language": 0,
  "pageNo": 1
}
返回值：
{
    "status": 1,
    "msg": "success",
    "data": {
        "curPage": 1,
        "pageSize": 15,
        "totalSize": 2,
        "totalPage": 0,
        "data": [
            {
                "id": 3,
                "englishid": 5,
                "chineseid": 4,
                "img": null,
                "updatetime": 1543125172000,
                "createtime": 1543125172000,
                "isrelease": 0,
                "releasetime": null,
                "showhomepage": 0,
                "readnum": null,
                "name": "中文中文1111",
                "newDetail_ch": null,
                "newDetail_en": null
            },
            {
                "id": 2,
                "englishid": 3,
                "chineseid": 2,
                "img": null,
                "updatetime": 1543126077000,
                "createtime": 1543124566000,
                "isrelease": 0,
                "releasetime": 1543126077000,
                "showhomepage": 0,
                "readnum": null,
                "name": "中文中文11112222",
                "newDetail_ch": null,
                "newDetail_en": null
            }
        ]
    },
    "extendInfo": null
}



/lplt/news/detail
post
参数
id
返回值
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 2,
        "englishid": 3,
        "chineseid": 2,
        "img": null,
        "updatetime": 1543126077000,
        "createtime": 1543124566000,
        "isrelease": 0,
        "releasetime": 1543126077000,
        "showhomepage": 0,
        "readnum": null,
        "name": null,
        "newDetail_ch": {
            "id": 2,
            "name": "中文中文11112222",
            "introduce": null,
            "detail": "中文中文detail",
            "comment": "中文中文comment",
            "updatetime": 1543126077000,
            "createtime": 1543124566000,
            "language": 0
        },
        "newDetail_en": {
            "id": 3,
            "name": "englishenglish",
            "introduce": null,
            "detail": "englishenglishenglishdetail",
            "comment": "englishenglishenglishenglishcomment",
            "updatetime": 1543126077000,
            "createtime": 1543124566000,
            "language": 1
        }
    },
    "extendInfo": null
}


/lplt/news/save
post
参数  保存和更新只是 id之差
{
  "id":2,
  "img":"url",
  "isrelease": 0,
  "showhomepage": 0,
  "newDetail_ch":{
    "name":"中文中文11112222",
    "detail":"中文中文detail",
    "comment":"中文中文comment",
    "language":0
  },
  "newDetail_en":{
    "name":"englishenglish",
    "detail":"englishenglishenglishdetail",
    "comment":"englishenglishenglishenglishcomment",
    "language":1
  }
}

返回值
{
    "status": 1,
    "msg": "success",
    "data": "保存成功",
    "extendInfo": null
}


/lplt/news/delete
post
参数：id
返回值：
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}



------------------------------------------------------------------------------------------------


/lplt/productCategory/save
post
参数：
{
  "id":1,
  "name": "类别11111",
  "nameen": "ccategroy one",
  "comment": "commentcomment"
}
返回值：
{
    "status": 1,
    "msg": "保存成功！",
    "data": "保存成功！",
    "extendInfo": null
}

// TODO 商品类别用分页吗？
/lplt/productCategory/list
post
参数：没有
返回值
{
    "status": 1,
    "msg": "success",
    "data": [
        {
            "id": 1,
            "name": "类别11111",
            "nameen": "ccategroy one",
            "comment": "commentcomment",
            "createtime": null
        }
    ],
    "extendInfo": null
}

/lplt/productCategory/detail
post
参数：id
返回值
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 1,
        "name": "类别11111",
        "nameen": "ccategroy one",
        "comment": "commentcomment",
        "createtime": null
    },
    "extendInfo": null
}

// TODO 返回删除成功，但是刷新后删除的数据还在
/productCategory/delete
post
参数：id
返回值：
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}

------------------------------------------------------------------------------------------------


// TODO 列表获取失败
/lplt/product/list
post
参数：
{
    "name": "aaaa",
    "type": 0,
    "brand": 1,
    "categoryid": 1,
    "isrelease": 0,
    "showhomepage": 0,
    "starttime": "2018-10-01 00:00:00",
    "endtime": "2018-12-01 00:00:00",
    "language": 0,
    "pageNo": 1
}
返回值：
{
    "status": 1,
    "msg": "success",
    "data": {
        "curPage": 1,
        "pageSize": 15,
        "totalSize": 1,
        "totalPage": 0,
        "data": [
            {
                "id": 15,
                "englishid": 17,
                "chineseid": 16,
                "categoryid": 1,
                "img": "imgimgimgimg",
                "servicehotline": "123456789",
                "salehotline": "123456789",
                "createtime": 1543175956000,
                "updatetime": 1543175956000,
                "isrelease": 0,
                "releasetime": null,
                "showhomepage": 0,
                "name": "产品名字22",
                "detail_ch": null,
                "detail_en": null
            }
        ]
    },
    "extendInfo": null
}


// TODO 增加一个字段，分类名称
/lplt/product/save
post
参数：
{
    "categoryid": 1,
    "img": "imgimgimgimg",
    "servicehotline": "123456789",
    "salehotline": "123456789",
    "isrelease": 0,
    "showhomepage": 0,
    "detail_ch": {
        "name": "产品名字22",
        "maker": "制造商",
        "dealer": "经销商",
        "type": "型号",
        "brand": "品牌",
        "source": "来源",
        "introduce": "介绍",
        "techadvantage": "技术优势",
        "techparams":"技术参数",
        "applicationarea": "应用场景",
        "detail": "产品详细",
        "comment": "产品备注",
        "language": 0
    },
    "detail_en": {
        "name": "name",
        "maker": "maker",
        "dealer": "dealer ",
        "type": "type",
        "brand": "brand",
        "source": "source",
        "introduce": "introduce",
        "techadvantage": "techadvantage",
        "techparams":"techparams",
        "applicationarea": "applicationarea",
        "detail": "detail",
        "comment": "comment",
        "language": 1
    }
}
返回值：
{
    "status": 1,
    "msg": "保存成功！",
    "data": "保存成功！",
    "extendInfo": null
}


/lplt/product/detail
post
参数：id
返回值：
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 14,
        "englishid": 15,
        "chineseid": 14,
        "categoryid": 1,
        "img": "imgimgimgimg",
        "servicehotline": "123456789",
        "salehotline": "123456789",
        "createtime": 1543174654000,
        "updatetime": 1543175919000,
        "isrelease": 0,
        "releasetime": 1543175919000,
        "showhomepage": 0,
        "name": null,
        "detail_ch": {
            "id": 14,
            "name": "产品名字",
            "maker": "制造商",
            "dealer": "经销商",
            "type": "型号",
            "brand": "品牌",
            "source": "来源",
            "introduce": "介绍",
            "techadvantage": "技术优势",
            "techparams": "技术参数",
            "applicationarea": "应用场景",
            "detail": "产品详细",
            "comment": "产品备注",
            "createtime": 1543174654000,
            "updatetime": 1543175919000,
            "language": 0
        },
        "detail_en": {
            "id": 15,
            "name": "name",
            "maker": "maker",
            "dealer": "dealer ",
            "type": "type",
            "brand": "brand",
            "source": "source",
            "introduce": "introduce",
            "techadvantage": "techadvantage",
            "techparams": "techparams",
            "applicationarea": "applicationarea",
            "detail": "detail",
            "comment": "comment",
            "createtime": 1543174654000,
            "updatetime": 1543175919000,
            "language": 1
        }
    },
    "extendInfo": null
}

/lplt/product/delete
post
参数 id
返回值：
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}



------------------------售后------------------------------------------------------------------------

/lplt/afterService/save
post
参数：有id更新 无id新加
{
    "id":1,
    "name": "问题1",
    "phone": "123456789",
    "email": "aaaa@123.com",
    "company": "报修公司",
    "question": "问题",
    "reply": "售后回复11111",
    "isdeal": 0
}
返回值
{
    "status": 1,
    "msg": "success",
    "data": "保存成功",
    "extendInfo": null
}


/lplt/afterService/detail
post
参数 ： id
返回值
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 1,
        "name": "问题1",
        "phone": "123456789",
        "email": "aaaa@123.com",
        "company": "报修公司",
        "question": "问题",
        "reply": "售后回复11111",
        "createtime": 1543211060000,
        "updatetime": 1543211203000,
        "isdeal": 0
    },
    "extendInfo": null
}


/lplt/afterService/list
post
参数：
{
    "name": "问题1",
    "starttime": "2018-10-01 00:00:00",
    "endtime": "2018-12-01 00:00:00",
    "pageNo":1
}
返回值
{
    "status": 1,
    "msg": "success",
    "data": {
        "curPage": 1,
        "pageSize": 15,
        "totalSize": 1,
        "totalPage": 0,
        "data": [
            {
                "id": 1,
                "name": "问题1",
                "phone": "123456789",
                "email": "aaaa@123.com",
                "company": "报修公司",
                "question": "问题",
                "reply": "售后回复11111",
                "createtime": 1543211060000,
                "updatetime": 1543211203000,
                "isdeal": 0
            }
        ]
    },
    "extendInfo": null
}


/lplt/afterService/delete
post
参数：id

返回值：
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}

------------------------公司信息------------------------------------------------------------------------


/lplt/company/save
post
参数： 有id是更新，没有id是新加
{
    "logokey": "图片url",
    "phone": "123456789",
    "servicehotline": "123456789",  //TODO服务热线
    "salehotline": "123456789",     //TODO销售热线
    "videopath":"视频path",         //视频path
    "email": "aaa@email.com",
    "zipcode": "邮政编码",
    "fax": "传真",
    "person": "公司法人",
    "registtime": "2018-01-01 00:00:00",
    "isrelease": 0,
    "company_ch": {
        "name": "公司名",
        "introduce": "公司介绍",
        "detail": "公司详细",
        "comment": "公司备注信息",
        "city": "城市",
        "address": "地址",
        "language": 0
    },
    "company_en": {
        "name": "name",
        "introduce": "introduce",
        "detail": "detail",
        "comment": "comment",
        "city": "city",
        "address": "address",
        "language": 1
    }
}
返回值
{
    "status": 1,
    "msg": "success",
    "data": "保存成功",
    "extendInfo": null
}


/lplt/company/detail
post
参数：id
返回值
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 1,
        "chineseid": 1,
        "englishid": 2,
        "logokey": "图片url",
        "phone": "123456789",
        "email": "aaa@email.com",
        "zipcode": "123456",
        "fax": "12345",
        "person": "公司法人",
        "registtime": "2018-01-01 14:00:00",
        "createtime": 1543292407000,
        "updatetime": 1543292747000,
        "isinfo": 0,
        "isrelease": 0,
        "releasetime": 1543292747000,
        "company_ch": {
            "id": 1,
            "name": "公司名",
            "introduce": "公司介绍",
            "detail": "公司详细",
            "comment": "公司备注信息",
            "city": "城市",
            "address": "地址",
            "updatetime": 1543292747000,
            "createtime": 1543292407000,
            "language": 0
        },
        "company_en": {
            "id": 2,
            "name": "name",
            "introduce": "introduce",
            "detail": "detail",
            "comment": "comment",
            "city": "city",
            "address": "address",
            "updatetime": 1543292747000,
            "createtime": 1543292407000,
            "language": 1
        }
    },
    "extendInfo": null
}


/lplt/company/delete
post
参数：id
返回值
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}

------------------------联系方式------------------------------------------------------------------------


/lplt/contactInfo/save
post
参数： 有id是更新，无id是新加
{
    "logokey": "图片url",
    "phone": "123456789",
    "servicehotline": "123456789",  //TODO服务热线
    "salehotline": "123456789",     //TODO销售热线
    "email": "aaa@email.com",
    "zipcode": "123456",
    "fax": "12345",
    "person": "公司法人",
    "registtime": "2018-01-01 00:00:00",
    "isrelease": 0
}
返回值
{
    "status": 1,
    "msg": "success",
    "data": "保存成功",
    "extendInfo": null
}

/lplt/contactInfo/detail
post
参数：id
返回值： 这里的 chineseid，englishid，company_ch，company_en是没用的
{
    "status": 1,
    "msg": "success",
    "data": {
        "id": 3,
        "chineseid": 0,
        "englishid": 0,
        "logokey": "图片url",
        "phone": "12345678900000",
        "email": "aaa@email.com",
        "zipcode": "123456",
        "fax": "12345",
        "person": "公司法人",
        "registtime": "2018-01-01 14:00:00",
        "createtime": 1543293513000,
        "updatetime": 1543293622000,
        "isinfo": 1,
        "isrelease": 0,
        "releasetime": 1543293622000,
        "company_ch": null,
        "company_en": null
    },
    "extendInfo": null
}

/lplt/contactInfo/list
post
没有参数
返回值：  这里的 chineseid，englishid，company_ch，company_en是没用的
{
    "status": 1,
    "msg": "success",
    "data": [
        {
            "id": 5,
            "chineseid": 0,
            "englishid": 0,
            "logokey": "图片url",
            "phone": "0000000000",
            "email": "aaa@email.com",
            "zipcode": "123456",
            "fax": "12345",
            "person": "公司法人",
            "registtime": "2018-01-01 00:00:00",
            "createtime": 1543293826000,
            "updatetime": 1543293826000,
            "isinfo": 1,
            "isrelease": 0,
            "releasetime": null,
            "company_ch": null,
            "company_en": null
        }
    ],
    "extendInfo": null
}

/lplt/contactInfo/list
post
参数： id
返回值
{
    "status": 1,
    "msg": "success",
    "data": "删除成功！",
    "extendInfo": null
}


售后的代码还没有发布到服务器上









