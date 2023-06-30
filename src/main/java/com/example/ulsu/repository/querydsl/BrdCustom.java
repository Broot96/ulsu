package com.example.ulsu.repository.querydsl;

import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.makeroom.responseDto.BrdLineListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BrdCustom {

    Page<BrdLine> searchAll(String[] types, String keyword, Pageable pageable);
    Optional<BrdLine> getLineInfo(String type1, Long keyword1, String type2, Long keyword2);
}

