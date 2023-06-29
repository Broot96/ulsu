package com.example.ulsu.repository.querydsl.impl;

import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.entity.QBrdLine;
import com.example.ulsu.repository.querydsl.BrdCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

public class BrdCustomImpl extends QuerydslRepositorySupport implements BrdCustom {

    public BrdCustomImpl(){super(BrdLine.class);}
    @Override
    public Page<BrdHeader> searchAll(String[] types, String keyword, Pageable pageable) {

        QBrdLine brdLine = QBrdLine.brdLine; // Q도메인 객체
        JPQLQuery<BrdLine> query = from(brdLine);

        if((types != null && types.length >0) && keyword != null){

            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types){

            }

        }

        return null;
    }

    @Override
    public Optional<BrdLine> getLineInfo(String type1, Long keyword1, String type2, Long keyword2) {
        return Optional.empty();
    }
}
