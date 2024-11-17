package com.fitdine.order.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "order", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id"}),
        @UniqueConstraint(columnNames = {"order_number"})
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true, columnDefinition = "bigint COMMENT '주문 ID'")
    private Long orderId;

    @Column(name = "order_user_id", nullable = false, columnDefinition = "bigint COMMENT '주문자 ID'")
    @NotNull
    private Long orderUserId;

    @Column(name = "order_number", nullable = false, unique = true, columnDefinition = "varchar(255) COMMENT '주문 번호 (고유)'")
    @NotBlank
    private String orderNumber;

    @Column(name = "order_date", nullable = false, columnDefinition = "datetime COMMENT '주문 일자'")
    @NotNull
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false, columnDefinition = "decimal(10, 2) COMMENT '총 주문 금액'")
    @NotNull
    private BigDecimal totalAmount;

    @Builder
    public OrderEntity(Long orderUserId,
                       String orderNumber,
                       LocalDateTime orderDate,
                       BigDecimal totalAmount) {
        this.orderUserId = orderUserId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
