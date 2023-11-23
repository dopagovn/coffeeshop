package com.luckygroup.webapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.OderDetail;

@Repository
public interface OderDetailRepository extends JpaRepository<OderDetail, Long> {
    Optional<OderDetail> findById(int id);
    Optional<OderDetail> deleteById(int id);
}

