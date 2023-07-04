package com.example.ulsu.repository.querydsl.impl;


import com.example.ulsu.entity.BrdLine;

import com.example.ulsu.entity.QBrdLine;
import com.example.ulsu.makeroom.responseDto.BrdLineListResponse;
import com.example.ulsu.repository.querydsl.BrdCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Optional;

public class BrdCustomImpl extends QuerydslRepositorySupport implements BrdCustom {

    public BrdCustomImpl(){super(BrdLine.class);}
    @Override
    public Page<BrdLine> searchAll(String[] types, String keyword, Pageable pageable) {


        QBrdLine brdLine = QBrdLine.brdLine;  // Q도메인 객체
        JPQLQuery<BrdLine> query = from(brdLine);

        if((types != null && types.length >0) && keyword != null){

            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types){

                switch (type){
                    case "t":
                    booleanBuilder.or(brdLine.brdTtl.contains(keyword));
                        break;
                    case "c":
                    booleanBuilder.or(brdLine.cn.contains(keyword));
                        break;
                    case "w":
                    booleanBuilder.or(brdLine.wrtTeam.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }
        query.where(brdLine.brdLineSeq.gt(0L));
        this.getQuerydsl().applyPagination(pageable, query);

        List<BrdLine> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Optional<BrdLine> getLineInfo(String type1, Long keyword1, String type2, Long keyword2) {
        return Optional.empty();
    }
}
