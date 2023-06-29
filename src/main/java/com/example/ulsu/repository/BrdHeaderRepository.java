package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.repository.querydsl.BrdCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrdHeaderRepository extends JpaRepository<BrdHeader, Long> , BrdCustom{
}
