DROP TABLE IF EXISTS user_login;
CREATE TABLE user_login(
    user_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '用户ID' ,
    user_login_name VARCHAR(20) NOT NULL   COMMENT '用户登录名' ,
    user_password CHAR(32) NOT NULL   COMMENT '用户密码' ,
    user_status TINYINT(3) NOT NULL   COMMENT '用户状态' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (user_id)
) ENGINE=InnoDB COMMENT = '用户登录表';

DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
    user_info_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '用户信息ID' ,
    user_id INT UNSIGNED(10) NOT NULL   COMMENT '用户ID：关联user_login表user_id' ,
    user_name VARCHAR(20)    COMMENT '用户真实姓名' ,
    identity_card_type TINYINT(3)    COMMENT '证件类型：1身份证；2军官证；3护照；' ,
    identity_card_no VARCHAR(20)    COMMENT '证件号码' ,
    mobile_phone INT UNSIGNED(10)    COMMENT '手机号' ,
    email VARCHAR(50)    COMMENT '邮箱' ,
    gender CHAR(1)    COMMENT '性别：1男；2女；3未知；' ,
    register_time TIMESTAMP NOT NULL   COMMENT '注册时间' ,
    brithday DATETIME    COMMENT '会员生日' ,
    user_point INT(10) NOT NULL   COMMENT '用户积分' ,
    user_level TINYINT(3) NOT NULL   COMMENT '用户级别' ,
    user_money DECIMAL(8,2) NOT NULL   COMMENT '用户余额' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (user_info_id)
) ENGINE=InnoDB COMMENT = '用户信息表';

DROP TABLE IF EXISTS user_level_info;
CREATE TABLE user_level_info(
    user_level TINYINT(3) NOT NULL   COMMENT '会员级别' ,
    level_label_name VARCHAR(20) NOT NULL   COMMENT '会员级别名称' ,
    level_min_point INT UNSIGNED(10) NOT NULL   COMMENT '该级别最低分（包含）' ,
    level_max_point INT UNSIGNED(10) NOT NULL   COMMENT '该级别最高分（不包含）' ,
    CREATED_BY INT UNSIGNED(10)    COMMENT '创建人' ,
    CREATED_TIME TIMESTAMP    COMMENT '创建时间' ,
    UPDATED_BY INT UNSIGNED(10)    COMMENT '更新人' ,
    UPDATED_TIME TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (user_level)
) ENGINE=InnoDB COMMENT = '用户级别信息表 ';

DROP TABLE IF EXISTS user_address;
CREATE TABLE user_address(
    user_address_id INT UNSIGNED(10) NOT NULL   COMMENT '用户地址ID' ,
    user_id INT UNSIGNED(10)    COMMENT '用户ID：关联user_login表user_id' ,
    zip SMALLINT(5)    COMMENT '邮编' ,
    province SMALLINT(5)    COMMENT '省份' ,
    city SMALLINT(5)    COMMENT '城市' ,
    district SMALLINT(5)    COMMENT '区、县' ,
    address VARCHAR(200)    COMMENT '地址门牌号' ,
    is_default TINYINT(3)    COMMENT '是否默认' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (user_address_id)
) ENGINE=InnoDB COMMENT = '用户地址表 ';

DROP TABLE IF EXISTS user_login_log;
CREATE TABLE user_login_log(
    login_id INT UNSIGNED(10)    COMMENT '用户登录日志ID' ,
    user_id INT UNSIGNED(10)    COMMENT '用户ID：关联user_login表user_id' ,
    login_time TIMESTAMP    COMMENT '登陆时间' ,
    login_ip VARCHAR(32)    COMMENT '登录IP' ,
    login_type TINYINT(3)    COMMENT '登录类型：0失败；1成功；' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' 
) ENGINE=InnoDB COMMENT = '用户登录日志表 ';

DROP TABLE IF EXISTS user_point_log;
CREATE TABLE user_point_log(
    point_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '积分日志ID' ,
    user_id INT UNSIGNED(10)    COMMENT '用户ID：关联user_login表user_id' ,
    point_origin TINYINT(3)    COMMENT '积分来源：0登录；1订单；3活动；' ,
    point_refer_no INT UNSIGNED(10)    COMMENT '积分来源编号' ,
    change_point INT(10)    COMMENT '变更积分数' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (point_id)
) ENGINE=InnoDB COMMENT = '用户积分日志表 ';

DROP TABLE IF EXISTS user_balance_log;
CREATE TABLE user_balance_log(
    balance_id INT UNSIGNED(10)    COMMENT '余额日志ID' ,
    user_id INT UNSIGNED(10)    COMMENT '用户ID：关联user_login表user_id' ,
    change_origin TINYINT(3)    COMMENT '余额变动来源：0充值；1订单；2退货；' ,
    change_origin_id VARCHAR(20)    COMMENT '变动来源单据ID' ,
    amount DECIMAL(8,2)    COMMENT '变动金额' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' 
) ENGINE=InnoDB COMMENT = '用户余额变动日志表 ';

DROP TABLE IF EXISTS product_info;
CREATE TABLE product_info(
    product_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '商品ID' ,
    product_core CHAR(16) NOT NULL   COMMENT '商品编码' ,
    product_name VARCHAR(20) NOT NULL   COMMENT '商品名称' ,
    bar_code VARCHAR(50) NOT NULL   COMMENT '条形码' ,
    price DECIMAL(8,2) NOT NULL   COMMENT '商品销售价格' ,
    publish_status TINYINT(3) NOT NULL   COMMENT '上下架状态：0下架1上架' ,
    audit_status TINYINT(3) NOT NULL   COMMENT '审核状态：0未审核，1已审核' ,
    weight FLOAT(12)    COMMENT '商品重量' ,
    length FLOAT(12)    COMMENT '商品长度' ,
    height FLOAT(12)    COMMENT '商品高度' ,
    width FLOAT(12)    COMMENT '商品宽度' ,
    color_type VARCHAR(10)    COMMENT '商品颜色' ,
    production_date DATETIME NOT NULL   COMMENT '生产日期' ,
    shelf_life INT(10) NOT NULL   COMMENT '商品有效期' ,
    descript TEXT NOT NULL   COMMENT '商品描述' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (product_id)
) ENGINE=InnoDB COMMENT = '商品信息表 ';

DROP TABLE IF EXISTS product_comment;
CREATE TABLE product_comment(
    comment_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '评论ID' ,
    product_id INT UNSIGNED(10) NOT NULL   COMMENT '商品ID' ,
    order_id BIGINT UNSIGNED(20) NOT NULL   COMMENT '订单ID' ,
    user_id INT UNSIGNED(10) NOT NULL   COMMENT '用户ID' ,
    title VARCHAR(50) NOT NULL   COMMENT '评论标题' ,
    content VARCHAR(300) NOT NULL   COMMENT '评论内容' ,
    audit_status TINYINT(3) NOT NULL   COMMENT '审核状态：0未审核，1已审核' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (comment_id)
) ENGINE=InnoDB COMMENT = '商品评论表 ';

DROP TABLE IF EXISTS product_pic_info;
CREATE TABLE product_pic_info(
    product_pic_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '商品图片ID' ,
    product_id INT UNSIGNED(10) NOT NULL   COMMENT '商品ID' ,
    pic_desc VARCHAR(50)    COMMENT '图片描述' ,
    pic_url VARCHAR(200) NOT NULL   COMMENT '图片URL' ,
    is_master TINYINT(3) NOT NULL   COMMENT '是否主图：0.非主图1.主图' ,
    pic_order TINYINT(3) NOT NULL   COMMENT '图片排序' ,
    pic_status TINYINT(3) NOT NULL   COMMENT '图片是否有效：0无效 1有效' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (product_pic_id)
) ENGINE=InnoDB COMMENT = '商品图片信息表 ';

DROP TABLE IF EXISTS order_detail;
CREATE TABLE order_detail(
    order_detail_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '订单详情表ID' ,
    order_id INT UNSIGNED(10) NOT NULL   COMMENT '订单表ID' ,
    product_id INT UNSIGNED(10) NOT NULL   COMMENT '订单商品ID' ,
    product_name VARCHAR(50) NOT NULL   COMMENT '商品名称' ,
    product_cnt INT(10) NOT NULL   COMMENT '购买商品数量' ,
    product_price DECIMAL(8,2) NOT NULL   COMMENT '购买商品单价' ,
    fee_money DECIMAL(8,2)    COMMENT '分摊优惠金额' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (order_detail_id)
) ENGINE=InnoDB COMMENT = '订单详情表 ';

DROP TABLE IF EXISTS order_master;
CREATE TABLE order_master(
    order_id INT UNSIGNED(10) NOT NULL AUTO_INCREMENT  COMMENT '订单ID' ,
    order_no VARCHAR(32) NOT NULL   COMMENT '订单编号' ,
    user_id INT UNSIGNED(10) NOT NULL   COMMENT '下单人ID' ,
    shipping_user VARCHAR(10) NOT NULL   COMMENT '收货人姓名' ,
    province SMALLINT(5) NOT NULL   COMMENT '省' ,
    city SMALLINT(5) NOT NULL   COMMENT '市' ,
    district SMALLINT(5) NOT NULL   COMMENT '区' ,
    address VARCHAR(100) NOT NULL   COMMENT '地址' ,
    payment_method TINYINT(3) NOT NULL   COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信' ,
    order_money DECIMAL(8,2) NOT NULL   COMMENT '订单金额' ,
    district_money DECIMAL(8,2) NOT NULL   COMMENT '优惠金额' ,
    shipping_money DECIMAL(8,2) NOT NULL   COMMENT '运费金额' ,
    payment_money DECIMAL(8,2) NOT NULL   COMMENT '支付金额' ,
    shipping_sn VARCHAR(50)    COMMENT '快递单号' ,
    create_time TIMESTAMP NOT NULL   COMMENT '下单时间' ,
    shipping_time DATETIME    COMMENT '发货时间' ,
    pay_time DATETIME    COMMENT '支付时间' ,
    receive_time DATETIME    COMMENT '收货时间' ,
    order_status TINYINT(3) NOT NULL   COMMENT '订单状态' ,
    order_point INT UNSIGNED(10) NOT NULL   COMMENT '订单积分' ,
    invoice_time VARCHAR(100)    COMMENT '发票抬头' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time1 TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (order_id)
) ENGINE=InnoDB COMMENT = '订单主表 ';

DROP TABLE IF EXISTS shipping_info;
CREATE TABLE shipping_info(
    ship_id TINYINT UNSIGNED(3) NOT NULL AUTO_INCREMENT  COMMENT '主键ID' ,
    order_id INT UNSIGNED(10)    COMMENT '订单ID' ,
    shipping_sn VARCHAR(50)    COMMENT '快递单号' ,
    ship_name VARCHAR(20) NOT NULL   COMMENT '物流公司名称' ,
    ship_contact VARCHAR(20) NOT NULL   COMMENT '物流公司联系人' ,
    telephone VARCHAR(20) NOT NULL   COMMENT '物流公司联系电话' ,
    price DECIMAL(8,2) NOT NULL   COMMENT '配送价格' ,
    ship_status TINYINT(3)    COMMENT '物流状态' ,
    create_by INT UNSIGNED(10)    COMMENT '创建人' ,
    create_time1 TIMESTAMP    COMMENT '创建时间' ,
    update_by INT UNSIGNED(10)    COMMENT '更新人' ,
    update_time TIMESTAMP    COMMENT '更新时间' ,
    PRIMARY KEY (ship_id)
) ENGINE=InnoDB COMMENT = '物流公司信息表 ';

