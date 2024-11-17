package com.fitdine.order.domain.repository;

import com.fitdine.order.domain.DomainIntegrationTest;
import com.fitdine.order.domain.entity.OrderEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DomainIntegrationTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    private OrderEntity order;

    @BeforeEach
    void setUp() {
        order = OrderEntity.builder()
                .orderUserId(1L)
                .orderNumber("ORD-001")
                .orderDate(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(150.50))
                .build();
    }

    @Test
    void testSaveOrder() {
        OrderEntity savedOrder = orderRepository.save(order);

        assertThat(savedOrder.getOrderId()).isNotNull();
        assertThat(savedOrder.getOrderNumber()).isEqualTo("ORD-001");
        assertThat(savedOrder.getTotalAmount()).isEqualTo(BigDecimal.valueOf(150.50));
    }

    @Test
    void testFindById() {
        OrderEntity savedOrder = orderRepository.save(order);

        Optional<OrderEntity> retrievedOrder = orderRepository.findById(savedOrder.getOrderId());

        assertThat(retrievedOrder).isPresent();
        assertThat(retrievedOrder.get().getOrderNumber()).isEqualTo("ORD-001");
    }

    @Test
    void testUpdateOrder() {
        OrderEntity savedOrder = orderRepository.save(order);

        savedOrder = OrderEntity.builder()
                .orderUserId(savedOrder.getOrderUserId())
                .orderNumber("ORD-002") // Updated order number
                .orderDate(savedOrder.getOrderDate())
                .totalAmount(BigDecimal.valueOf(200.00)) // Updated total amount
                .build();

        OrderEntity updatedOrder = orderRepository.save(savedOrder);

        assertThat(updatedOrder.getOrderNumber()).isEqualTo("ORD-002");
        assertThat(updatedOrder.getTotalAmount()).isEqualTo(BigDecimal.valueOf(200.00));
    }

    @Test
    void testDeleteOrder() {
        OrderEntity savedOrder = orderRepository.save(order);

        orderRepository.deleteById(savedOrder.getOrderId());

        Optional<OrderEntity> deletedOrder = orderRepository.findById(savedOrder.getOrderId());
        assertThat(deletedOrder).isEmpty();
    }
}