package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.repository.querydsl.BrdCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrdLineRepository extends JpaRepository<BrdLine, Long>, BrdCustom {
}

