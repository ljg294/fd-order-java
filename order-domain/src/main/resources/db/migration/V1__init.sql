DROP TABLE IF EXISTS diner_order;

#-----------------------------------------------------------------------------------------------------------------------
#-- Table 명 : diner_order (음식점 주문)
#-----------------------------------------------------------------------------------------------------------------------
CREATE TABLE diner_order
(
    diner_order_id                   BIGINT                      NOT NULL         AUTO_INCREMENT  COMMENT '음식점 주문 ID',
    diner_order_member_id            BIGINT                      NOT NULL                         COMMENT '주문자 ID',
    diner_id                         BIGINT                      NOT NULL                         COMMENT '음식점 ID',
    diner_order_number               BIGINT                      NOT NULL                         COMMENT '주문 번호',
    diner_order_date                 DATETIME                    NOT NULL                         COMMENT '주문 일자',
    total_amount                     BIGDECIMAL(10, 2)           NOT NULL                         COMMENT '총 주문 금액',
    delete_yn                        VARCHAR(1)                  NOT NULL                         COMMENT '삭제 여부',
    created_user_id                  BIGINT                      NOT NULL                         COMMENT '등록자 ID',
    created_date_time                DATETIME                    NOT NULL                         COMMENT '등록 일시',
    modified_user_id                 BIGINT                      NOT NULL                         COMMENT '수정자 ID',
    modified_date_time               DATETIME                    NOT NULL                         COMMENT '수정 일시',

    CONSTRAINT pk_diner_order PRIMARY KEY (diner_order_id),
    CONSTRAINT uk_diner_id_order_number UNIQUE (diner_id, diner_order_number)
    CONSTRAINT chk_diner_order_delete_yn CHECK (delete_yn IN ('Y', 'N')),
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COMMENT='음식점 주문';
