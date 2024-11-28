package com.fitdine.order.domain.repository;

import com.fitdine.order.domain.entity.DinerOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DinerOrderRepository extends JpaRepository<DinerOrderEntity, Long> {
    List<DinerOrderEntity> findByDinerId(Long dinerId);
}
