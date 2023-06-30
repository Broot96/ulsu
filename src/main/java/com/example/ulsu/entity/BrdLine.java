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
    @Column(name = "BRD_TITLE", nullable = false)
    private String brdTtl;                                  //게시글 제목
    @Column(name = "WRT_TEAM", nullable = false)
    private String wrtTeam;                                 //작성자 그룹
    @Column(name = "WRT_NAME", nullable = true)
    private String wrtName;                                 //작성자 이름
    @Column(name = "CN", nullable = true)
    private String cn;                                      //게시물 내용
    @Column(name = "INTQ_CNT", nullable = true)
    private int intqCnt;                                   //조회수
    @Column(name = "PASSWORD", nullable = false)
    private String pwd;                                     //게시물 비밀번호
    @Column(name = "DEL_YN", nullable = true)
    private String delYn;                                   //게시물 삭제여부
    @Column(name = "A_YN" , nullable = true)
    private String aYn;                                     //게시물 공지여부

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRD_HEADER_SEQ", referencedColumnName = "BRD_HEADER_SEQ", insertable = false, updatable = false)
    private BrdHeader brdHeader;
    public void changeBrdHeaderSeq(Long brdHeaderSeq){this.brdHeaderSeq = brdHeaderSeq;}
    public void changeBrdTtl(String brdTtl){this.brdTtl = brdTtl;}
    public void changeWrtTeam(String wrtTeam){this.wrtTeam = wrtTeam;}
    public void changeWrtName(String wrtName){this.wrtName = wrtName;}
    public void changeCn(String cn){this.cn = cn;}
    public void changeIntqCnt(int intqCnt){this.intqCnt = intqCnt;}
    public void changePwd(String pwd){this.pwd = pwd;}
    public void changeDelYn(String delYn){this.delYn = delYn;}




}