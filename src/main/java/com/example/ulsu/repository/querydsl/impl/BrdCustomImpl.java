package com.example.ulsu.repository.querydsl.impl;

import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.repository.querydsl.BrdCustom;

import java.util.Optional;

public class BrdCustomImpl implements BrdCustom {
    @Override
    public Optional<BrdLine> getLineInfo(String type1, Long keyword1, String type2, Long keyword2) {
        return Optional.empty();
    }
}
