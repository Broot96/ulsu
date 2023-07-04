package com.example.ulsu.makeroom.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
@Schema(description = "소통게판 게시물 저장 Request")
public class BrdLineSaveRequest {

    @Schema(description = "게시물 seq")
    private Long brdLineSeq;

    @Schema(description = "게시판 seq")
    private Long brdHeaderSeq;

    @Schema(description = "게시물 제목")
    private String brdTtl;

    @Schema(description = "작성자 그룹")
    private String wrtTeam;

    @Schema(description = "작성자 이름")
    private String wrtName;

    @Schema(description = "게시물 내용")
    private String cn;

    @Schema(description = "조회수")
    private int intqCnt;

    @Schema(description = "게시물 비밀번호")
    private String pwd;

    @Schema(description = "게시물 삭제여부")
    private String delYn;

    @Schema(description = "게시물 공지여부")
    private String aYn;

    public BrdLineSaveRequest() {

    }
}
