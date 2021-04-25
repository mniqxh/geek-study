基于电商交易场景（用户、商品、订单），设计一套简单的表结构

参考来源：[常见电商项目的数据库表设计（MySQL版）](https://www.cnblogs.com/myd620/p/12870995.html) 

---

### 用户模块表清单

---

| 名称 | 代码 | 备注 |
| ------------ | ------------ | ------------ |
| 用户登录表 | user\_login |  |
| 用户信息表 | user\_info |  |
| 用户级别信息表 | user\_level\_info |  |
| 用户地址表 | user\_address |  |
| 用户登录日志表 | user\_login\_log |  |
| 用户积分日志表 | user\_point\_log |  |
| 用户余额变动日志表 | user\_balance\_log |  |

---

 - #### user_login【用户登录表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| user\_id | 用户ID | INT UNSIGNED(10) | √ |  |
| user\_login\_name | 用户登录名 | VARCHAR(20) |  |  |
| user\_password | 用户密码 | CHAR(32) |  |  |
| user\_status | 用户状态 | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_info【用户信息表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| user\_info\_id | 用户信息ID | INT UNSIGNED(10) | √ |  |
| user\_id | 用户ID：关联user_login表user_id | INT UNSIGNED(10) |  |  |
| user\_name | 用户真实姓名 | VARCHAR(20) |  |  |
| identity\_card\_type | 证件类型：1身份证；2军官证；3护照； | TINYINT(3) |  |  |
| identity\_card\_no | 证件号码 | VARCHAR(20) |  |  |
| mobile\_phone | 手机号 | INT UNSIGNED(10) |  |  |
| email | 邮箱 | VARCHAR(50) |  |  |
| gender | 性别：1男；2女；3未知； | CHAR(1) |  |  |
| register\_time | 注册时间 | TIMESTAMP |  |  |
| brithday | 会员生日 | DATETIME |  |  |
| user\_point | 用户积分 | INT(10) |  |  |
| user\_level | 用户级别 | TINYINT(3) |  |  |
| user\_money | 用户余额 | DECIMAL(8,2) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_level_info【用户级别信息表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| user\_level | 会员级别 | TINYINT(3) | √ |  |
| level\_label\_name | 会员级别名称 | VARCHAR(20) |  |  |
| level\_min\_point | 该级别最低分（包含） | INT UNSIGNED(10) |  |  |
| level\_max\_point | 该级别最高分（不包含） | INT UNSIGNED(10) |  |  |
| CREATED\_BY | 创建人 | INT UNSIGNED(10) |  |  |
| CREATED\_TIME | 创建时间 | TIMESTAMP |  |  |
| UPDATED\_BY | 更新人 | INT UNSIGNED(10) |  |  |
| UPDATED\_TIME | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_address【用户地址表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| user\_address\_id | 用户地址ID | INT UNSIGNED(10) | √ |  |
| user\_id | 用户ID：关联user_login表user_id | INT UNSIGNED(10) |  |  |
| zip | 邮编 | SMALLINT(5) |  |  |
| province | 省份 | SMALLINT(5) |  |  |
| city | 城市 | SMALLINT(5) |  |  |
| district | 区、县 | SMALLINT(5) |  |  |
| address | 地址门牌号 | VARCHAR(200) |  |  |
| is\_default | 是否默认 | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_login_log【用户登录日志表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| login\_id | 用户登录日志ID | INT UNSIGNED(10) |  |  |
| user\_id | 用户ID：关联user_login表user_id | INT UNSIGNED(10) |  |  |
| login\_time | 登陆时间 | TIMESTAMP |  |  |
| login\_ip | 登录IP | VARCHAR(32) |  |  |
| login\_type | 登录类型：0失败；1成功； | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_point_log【用户积分日志表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| point\_id | 积分日志ID | INT UNSIGNED(10) | √ |  |
| user\_id | 用户ID：关联user_login表user_id | INT UNSIGNED(10) |  |  |
| point\_origin | 积分来源：0登录；1订单；3活动； | TINYINT(3) |  |  |
| point\_refer\_no | 积分来源编号 | INT UNSIGNED(10) |  |  |
| change\_point | 变更积分数 | INT(10) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### user_balance_log【用户余额变动日志表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| balance\_id | 余额日志ID | INT UNSIGNED(10) |  |  |
| user\_id | 用户ID：关联user_login表user_id | INT UNSIGNED(10) |  |  |
| change\_origin | 余额变动来源：0充值；1订单；2退货； | TINYINT(3) |  |  |
| change\_origin\_id | 变动来源单据ID | VARCHAR(20) |  |  |
| amount | 变动金额 | DECIMAL(8,2) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

### 商品模块表清单

---

| 名称 | 代码 | 备注 |
| ------------ | ------------ | ------------ |
| 商品信息表 | product\_info |  |
| 商品评论表 | product\_comment |  |
| 商品图片信息表 | product\_pic\_info |  |

---

 - #### product_info【商品信息表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| product\_id | 商品ID | INT UNSIGNED(10) | √ |  |
| product\_core | 商品编码 | CHAR(16) |  |  |
| product\_name | 商品名称 | VARCHAR(20) |  |  |
| bar\_code | 条形码 | VARCHAR(50) |  |  |
| price | 商品销售价格 | DECIMAL(8,2) |  |  |
| publish\_status | 上下架状态：0下架1上架 | TINYINT(3) |  |  |
| audit\_status | 审核状态：0未审核，1已审核 | TINYINT(3) |  |  |
| weight | 商品重量 | FLOAT(12) |  |  |
| length | 商品长度 | FLOAT(12) |  |  |
| height | 商品高度 | FLOAT(12) |  |  |
| width | 商品宽度 | FLOAT(12) |  |  |
| color\_type | 商品颜色 | VARCHAR(10) |  |  |
| production\_date | 生产日期 | DATETIME |  |  |
| shelf\_life | 商品有效期 | INT(10) |  |  |
| descript | 商品描述 | TEXT |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### product_comment【商品评论表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| comment\_id | 评论ID | INT UNSIGNED(10) | √ |  |
| product\_id | 商品ID | INT UNSIGNED(10) |  |  |
| order\_id | 订单ID | BIGINT UNSIGNED(20) |  |  |
| user\_id | 用户ID | INT UNSIGNED(10) |  |  |
| title | 评论标题 | VARCHAR(50) |  |  |
| content | 评论内容 | VARCHAR(300) |  |  |
| audit\_status | 审核状态：0未审核，1已审核 | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### product_pic_info【商品图片信息表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| product\_pic\_id | 商品图片ID | INT UNSIGNED(10) | √ |  |
| product\_id | 商品ID | INT UNSIGNED(10) |  |  |
| pic\_desc | 图片描述 | VARCHAR(50) |  |  |
| pic\_url | 图片URL | VARCHAR(200) |  |  |
| is\_master | 是否主图：0.非主图1.主图 | TINYINT(3) |  |  |
| pic\_order | 图片排序 | TINYINT(3) |  |  |
| pic\_status | 图片是否有效：0无效 1有效 | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

### 订单模块表清单

---

| 名称 | 代码 | 备注 |
| ------------ | ------------ | ------------ |
| 订单主表 | order\_master |  |
| 订单详情表 | order\_detail |  |
| 物流公司信息表 | shipping\_info |  |

---

 - #### order_master【订单主表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| order\_id | 订单ID | INT UNSIGNED(10) | √ |  |
| order\_no | 订单编号 | VARCHAR(32) |  |  |
| user\_id | 下单人ID | INT UNSIGNED(10) |  |  |
| shipping\_user | 收货人姓名 | VARCHAR(10) |  |  |
| province | 省 | SMALLINT(5) |  |  |
| city | 市 | SMALLINT(5) |  |  |
| district | 区 | SMALLINT(5) |  |  |
| address | 地址 | VARCHAR(100) |  |  |
| payment\_method | 支付方式：1现金，2余额，3网银，4支付宝，5微信 | TINYINT(3) |  |  |
| order\_money | 订单金额 | DECIMAL(8,2) |  |  |
| district\_money | 优惠金额 | DECIMAL(8,2) |  |  |
| shipping\_money | 运费金额 | DECIMAL(8,2) |  |  |
| payment\_money | 支付金额 | DECIMAL(8,2) |  |  |
| shipping\_sn | 快递单号 | VARCHAR(50) |  |  |
| create\_time | 下单时间 | TIMESTAMP |  |  |
| shipping\_time | 发货时间 | DATETIME |  |  |
| pay\_time | 支付时间 | DATETIME |  |  |
| receive\_time | 收货时间 | DATETIME |  |  |
| order\_status | 订单状态 | TINYINT(3) |  |  |
| order\_point | 订单积分 | INT UNSIGNED(10) |  |  |
| invoice\_time | 发票抬头 | VARCHAR(100) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time1 | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

---

  - #### order_detail【订单详情表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| order\_detail\_id | 订单详情表ID | INT UNSIGNED(10) | √ |  |
| order\_id | 订单表ID | INT UNSIGNED(10) |  |  |
| product\_id | 订单商品ID | INT UNSIGNED(10) |  |  |
| product\_name | 商品名称 | VARCHAR(50) |  |  |
| product\_cnt | 购买商品数量 | INT(10) |  |  |
| product\_price | 购买商品单价 | DECIMAL(8,2) |  |  |
| fee\_money | 分摊优惠金额 | DECIMAL(8,2) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |

---

 - #### shipping_info【物流公司信息表】

| 代码 | 名称 | 数据类型(MYSQL) | 主键 | 备注 |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| ship\_id | 主键ID | TINYINT UNSIGNED(3) | √ |  |
| order\_id | 订单ID | INT UNSIGNED(10) |  |  |
| shipping\_sn | 快递单号 | VARCHAR(50) |  |  |
| ship\_name | 物流公司名称 | VARCHAR(20) |  |  |
| ship\_contact | 物流公司联系人 | VARCHAR(20) |  |  |
| telephone | 物流公司联系电话 | VARCHAR(20) |  |  |
| price | 配送价格 | DECIMAL(8,2) |  |  |
| ship\_status | 物流状态 | TINYINT(3) |  |  |
| create\_by | 创建人 | INT UNSIGNED(10) |  |  |
| create\_time1 | 创建时间 | TIMESTAMP |  |  |
| update\_by | 更新人 | INT UNSIGNED(10) |  |  |
| update\_time | 更新时间 | TIMESTAMP |  |  |