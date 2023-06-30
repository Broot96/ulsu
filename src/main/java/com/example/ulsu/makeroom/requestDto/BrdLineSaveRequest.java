package com.example.ulsu.makeroom.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "소통게판 게시물 저장 Request")
public class BrdLineSaveRequest {

    @Schema(description = "게시물 seq")
    private Long brdLineSeq;

    @NotNull(message = "게시판 시퀀스가 입력되지 않았습니다.")
    @Schema(description = "게시판 seq")
    private Long brdHeaderSeq;

    @NotBlank(message = "게시물 제목이 입력되지 않았습니다.")
    @Schema(description = "게시물 제목")
    private String ttl;

    @Schema(description = "작성 팀")
    private String wrtTeam;

    @Schema(description = "게시글 비밀번호")
    private String pwd;

    @Schema(description = "게시글 공지여부")
    private String aYn;

    @NotBlank(message = "게시물 내용이 입력되지 않았습니다.")
    @Schema(description = "게시물 내용")
    private String cn;
}
