package com.example.ulsu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "board_header")
public class BrdHeader extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRD_HEADER_SEQ", nullable = false)
    private Long brdHeaderSeq;

    @Column(name = "TTL", nullable = true)
    private String ttl;

    @ToString.Exclude
    @OneToMany(mappedBy = "brdHeader", fetch = FetchType.LAZY)
    private List<BrdLine> brdHeaderList = new ArrayList<>();
}