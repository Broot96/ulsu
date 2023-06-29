package com.example.ulsu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "board_line")
public class BrdLine extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRD_LINE_SEQ", nullable = false)
    private Long brdLineSeq;                                //게시물 번호
    @Column(name = "BRD_HEADER_SEQ", nullable = false)
    private Long brdHeaderSeq;                              //게시판 번호
    @Column(name = "WRT_NAME", nullable = true)
    private String wrtName;                                 //작성자 이름
    @Column(name = "CN", nullable = true)
    private String cn;                                      //게시물 내용
    @Column(name = "INTQ_CNT", nullable = true)
    private Long intqCnt;                                   //조회수
    @Column(name = "PASSWORD", nullable = false)
    private String pwd;                                     //게시물 비밀번호
    @Column(name = "DEL_YN", nullable = true)
    private String delYn;                                   //게시물 삭제여부

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRD_HEADER_SEQ", referencedColumnName = "BRD_HEADER_SEQ", insertable = false, updatable = false)
    private BrdHeader brdHeader;


}