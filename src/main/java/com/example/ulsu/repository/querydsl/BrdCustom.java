package com.example.ulsu.repository.querydsl;

import com.example.ulsu.entity.BrdLine;

import java.util.Optional;

public interface BrdCustom {

    Optional<BrdLine> getLineInfo(String type1, Long keyword1, String type2, Long keyword2);
}

