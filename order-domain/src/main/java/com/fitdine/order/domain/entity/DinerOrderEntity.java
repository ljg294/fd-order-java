package com.fitdine.order.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "diner_order",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"diner_id", "diner_order_number"})
        })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DinerOrderEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dinerOrderId;

    @Column(name = "diner_order_customer_id", nullable = false, columnDefinition = "bigint COMMENT '주문자 ID'")
    private Long orderCustomerId;

    @Column(name = "diner_id", nullable = false, columnDefinition = "bigint COMMENT '음식점 ID'")
    private Long dinerId;

    @Column(name = "diner_order_number", nullable = false, columnDefinition = "bigint COMMENT '주문 번호'")
    private Long dinerOrderNumber;

    @Column(name = "diner_order_date_time", nullable = false, columnDefinition = "datetime COMMENT '주문 일시'")
    private LocalDateTime dinerOrderDateTime;

    @Column(name = "total_amount", nullable = false, columnDefinition = "decimal(10, 2) COMMENT '총 주문 금액'")
    private BigDecimal totalAmount;

    @Builder
    public DinerOrderEntity(Long dinerOrderId,
                            Long orderCustomerId,
                            Long dinerId,
                            Long dinerOrderNumber,
                            LocalDateTime dinerOrderDateTime,
                            BigDecimal totalAmount) {
        this.dinerOrderId = dinerOrderId;
        this.orderCustomerId = orderCustomerId;
        this.dinerId = dinerId;
        this.dinerOrderNumber = dinerOrderNumber;
        this.dinerOrderDateTime = dinerOrderDateTime;
        this.totalAmount = totalAmount;
    }

    @Builder(builderClassName = "createBuilder", builderMethodName = "createBuilder")
    public DinerOrderEntity(Long orderCustomerId,
                            Long dinerId,
                            Long dinerOrderNumber,
                            LocalDateTime dinerOrderDateTime,
                            BigDecimal totalAmount) {
        this.orderCustomerId = orderCustomerId;
        this.dinerId = dinerId;
        this.dinerOrderNumber = dinerOrderNumber;
        this.dinerOrderDateTime = dinerOrderDateTime;
        this.totalAmount = totalAmount;
    }
}
