package com.fitdine.order.domain.repository;

import com.fitdine.order.domain.DomainIntegrationTest;
import com.fitdine.order.domain.entity.DinerOrderEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DomainIntegrationTest
class DinerOrderRepositoryTest {

    @Autowired
    private DinerOrderRepository dinerOrderRepository;

    private DinerOrderEntity dinerOrder;

    @BeforeEach
    void setUp() {
        //Arrange
        dinerOrder = DinerOrderEntity.createBuilder()
                .orderCustomerId(1L)
                .dinerId(1L)
                .dinerOrderNumber(10L)
                .dinerOrderDateTime(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(150.50))
                .build();

        dinerOrderRepository.save(dinerOrder);
    }

    @AfterEach
    void tearDown() {
        dinerOrderRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("음식점 주문 저장 성공")
    void testSaveOrderSuccess() {
        //Arrange
        DinerOrderEntity savedDinerOrder = DinerOrderEntity.createBuilder()
                .orderCustomerId(1L)
                .dinerId(2L)
                .dinerOrderNumber(20L)
                .dinerOrderDateTime(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(300.50))
                .build();

        //Act
        dinerOrderRepository.save(savedDinerOrder);

        //Assert
        assertThat(savedDinerOrder.getDinerOrderId()).isNotNull();
        assertThat(savedDinerOrder.getDinerOrderNumber()).isEqualTo(20L);
        assertThat(savedDinerOrder.getTotalAmount()).isEqualTo(BigDecimal.valueOf(300.50));
    }

    @Test
    @DisplayName("음식점 주문 저장 실패 - 동일한 음식점 주문번호 중복")
    void testSaveOrderDuplicateOrderNumberInASingleDinerFail() {

        //Arrange
        DinerOrderEntity dinerOrder2 = DinerOrderEntity.createBuilder()
                .orderCustomerId(2L)
                .dinerId(1L)
                .dinerOrderNumber(10L)
                .dinerOrderDateTime(LocalDateTime.now())
                .totalAmount(BigDecimal.valueOf(150.50))
                .build();

        //Act & Assert
        assertThatThrownBy(() -> dinerOrderRepository.save(dinerOrder2))
                .isInstanceOf(Exception.class)
                .hasMessageContaining("could not execute statement");
    }

    @Test
    @DisplayName("음식점 주문ID로 음식점 주문 조회 성공")
    void testFindByIdSuccess() {

        //Act
        Optional<DinerOrderEntity> retrievedOrder = dinerOrderRepository.findById(dinerOrder.getDinerOrderId());

        //Assert
        assertThat(retrievedOrder).isPresent();
        assertThat(retrievedOrder.get().getDinerOrderNumber()).isEqualTo(10L);
    }

    @Test
    @DisplayName("음식점 ID로 음식점 주문 조회 성공")
    void testFindByDinerIdSuccess() {

        //Act
        List<DinerOrderEntity> retrievedOrders = dinerOrderRepository.findByDinerId(dinerOrder.getDinerId());

        //Assert
        assertThat(retrievedOrders).isNotEmpty();
        assertThat(retrievedOrders.get(0).getDinerOrderNumber()).isEqualTo(10L);
    }
}