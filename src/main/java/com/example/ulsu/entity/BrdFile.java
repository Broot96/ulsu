package com.example.ulsu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "board_file")
public class BrdFile extends AuditingFields{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRD_FILE_SEQ", nullable = false)
    private Long brdFileSeq;                                    //파일 시퀀스
    @Column(name = "BRD_LINE_SEQ", nullable = true)
    private Long brdLineSeq;                                    //게시물 번호
    @Column(name = "BRD_FILE_PATH", nullable = true)
    private String  filePath;                                   //파일 경로
    @Column(name = "BRD_FILE_NAME", nullable = true)
    private String fileName;                                    //파일명
    @Column(name = "BRD_FILE_EXTENSION", nullable = true)
    private String fileExtension;                               //확장자
    @Column(name = "BRD_FILE_YN")
    private String fileDyn;                                     //파일 삭제 유무

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRD_LINE_SEQ", referencedColumnName = "BRD_LINE_SEQ", insertable = false, updatable = false)
    private BrdLine brdLine;


    public void changeBrdLineSeq(Long brdLineSeq){this.brdLineSeq = brdLineSeq;}
    public void changeFilePath(String filePath){this.filePath = filePath;}
    public void changeFileName(String fileName){this.fileName = fileName;}
    public void changeFileExtension(String fileExtension){this.fileExtension = fileExtension;}
    public void changeFileDyn(String fileDyn){this.fileDyn = fileDyn;}
}
