#This is fans CREATE SQL.
#@author Conan Zhang
#@date 2012-07-17

use fans;

CREATE TABLE t_account(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL UNIQUE,
    create_date TIMESTAMP NULL  DEFAULT now(),
    expireIn VARCHAR(16) NULL ,
    refresh VARCHAR(32) NULL ,
    state VARCHAR(32) NULL ,
    screen_name VARCHAR(32) NOT NULL UNIQUE,
    token VARCHAR(32) NOT NULL 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_relate(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL ,
    fansid BIGINT NOT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX t_user_relate_IDX_0 on t_user_relate(uid,fansid);

CREATE TABLE t_user_birelate(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL ,
    biuid BIGINT NOT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX t_user_birelate_IDX_0 on t_user_birelate(uid,biuid);

CREATE TABLE t_user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL UNIQUE,
    screen_name VARCHAR(32) NOT NULL UNIQUE,
    name VARCHAR(32) NOT NULL UNIQUE,
    province INT NULL ,
    city INT NULL ,
    location VARCHAR(32) NULL ,
    description VARCHAR(128) NULL ,
    url VARCHAR(128) NULL ,
    profile_image_url VARCHAR(128) NULL ,
    domain VARCHAR(32) NULL ,
    gender VARCHAR(1) NULL  DEFAULT 'm',
    followers_count INT NOT NULL  DEFAULT 0,
    friends_count INT NOT NULL  DEFAULT 0,
    statuses_count INT NOT NULL  DEFAULT 0,
    favourites_count INT NOT NULL  DEFAULT 0,
    created_at DATETIME NOT NULL ,
    allow_all_act_msg VARCHAR(1) NULL  DEFAULT 'f',
    remark VARCHAR(32) NULL ,
    geo_enabled VARCHAR(1) NULL  DEFAULT 't',
    verified VARCHAR(1) NULL  DEFAULT 'f',
    allow_all_comment VARCHAR(1) NULL  DEFAULT 't',
    avatar_large VARCHAR(128) NULL ,
    verified_reason VARCHAR(32) NULL ,
    online_status INT NULL ,
    lang VARCHAR(8) NULL ,
    weihao VARCHAR(32) NULL ,
    verifiedType INT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_increase(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL ,
    date INT NOT NULL ,
    type VARCHAR(8) NOT NULL ,
    count BIGINT NOT NULL  DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX t_user_increase_IDX_0 on t_user_increase(uid,date,type);
CREATE  INDEX t_user_increase_IDX_1 on t_user_increase(date);

CREATE TABLE t_provinces(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL ,
    pid INT NOT NULL ,
    cid INT NULL  DEFAULT 1000,
    longitude VARCHAR(16) NULL ,
    latitude VARCHAR(16) NULL 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_config(
    id INT PRIMARY KEY AUTO_INCREMENT,
    create_date TIMESTAMP NULL  DEFAULT now(),
    imgUrl VARCHAR(256) NULL ,
    template VARCHAR(256) NULL ,
    r VARCHAR(256) NULL ,
    output VARCHAR(256) NULL ,
    type VARCHAR(16) NOT NULL UNIQUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_limit_user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL ,
    name VARCHAR(16) NOT NULL ,
    limit_time BIGINT NULL  DEFAULT -1,
    create_date TIMESTAMP NULL  DEFAULT now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX t_limit_user_IDX_0 on t_limit_user(uid,name);

CREATE TABLE t_apply_user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid BIGINT NOT NULL ,
    name VARCHAR(16) NOT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now()
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE UNIQUE INDEX t_apply_user_IDX_0 on t_apply_user(uid,name);

CREATE TABLE t_blog(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(256) NOT NULL ,
    content MEDIUMTEXT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now(),
    uid BIGINT NOT NULL ,
    utype VARCHAR(16) NULL  DEFAULT 'weibo'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_blog_comment(
    id INT PRIMARY KEY AUTO_INCREMENT,
    blogid INT NOT NULL ,
    blogcid INT NULL  DEFAULT 0,
    comment TEXT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now(),
    uid BIGINT NOT NULL ,
    utype VARCHAR(16) NULL  DEFAULT 'weibo'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_blog_action(
    id INT PRIMARY KEY AUTO_INCREMENT,
    blogid INT NOT NULL ,
    action INT NULL  DEFAULT 1,
    create_date TIMESTAMP NULL  DEFAULT now(),
    uid BIGINT NOT NULL ,
    utype VARCHAR(16) NULL  DEFAULT 'weibo'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_blog_tag(
    id INT PRIMARY KEY AUTO_INCREMENT,
    blogid INT NOT NULL ,
    tag VARCHAR(256) NOT NULL ,
    create_date TIMESTAMP NULL  DEFAULT now(),
    uid BIGINT NOT NULL ,
    utype VARCHAR(16) NULL  DEFAULT 'weibo'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

