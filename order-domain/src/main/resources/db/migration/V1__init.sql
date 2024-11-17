DROP TABLE IF EXISTS `order`;

#-----------------------------------------------------------------------------------------------------------------------
#-- Table 명 : order (주문)
#-----------------------------------------------------------------------------------------------------------------------
CREATE TABLE `order`
(
    order_id                         BIGINT                      NOT NULL         AUTO_INCREMENT  COMMENT '주문 ID',
    order_user_id                    BIGINT                      NOT NULL                         COMMENT '주문자 ID',
    order_number                     VARCHAR(255)                NOT NULL         UNIQUE          COMMENT '주문 번호',
    order_date                       DATETIME                    NOT NULL                         COMMENT '주문 일자',
    total_amount                     BIGDECIMAL(10, 2)           NOT NULL                         COMMENT '총 주문 금액',
    delete_yn                        VARCHAR(1)                  NOT NULL                         COMMENT '삭제 여부',
    created_user_id                  BIGINT                      NOT NULL                         COMMENT '등록자 ID',
    created_date_time                DATETIME                    NOT NULL                         COMMENT '등록 일시',
    modified_user_id                 BIGINT                      NOT NULL                         COMMENT '수정자 ID',
    modified_date_time               DATETIME                    NOT NULL                         COMMENT '수정 일시',

    CONSTRAINT pk_order PRIMARY KEY (order_id)
    CONSTRAINT chk_order_delete_yn CHECK (delete_yn IN ('Y', 'N')),
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COMMENT='주문';