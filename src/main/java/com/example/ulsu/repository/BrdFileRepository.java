package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdFile;
import com.example.ulsu.repository.querydsl.BrdCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrdFileRepository extends JpaRepository<BrdFile , Long>, BrdCustom {
}
