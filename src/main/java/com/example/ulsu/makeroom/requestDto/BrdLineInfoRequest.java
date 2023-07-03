package com.example.ulsu.makeroom.requestDto;

import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.makeroom.responseDto.BrdLineInfoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;



@Builder
@Getter
@AllArgsConstructor
public class BrdLineInfoRequest {

    //@NotNull(message = "게시물 시퀀스가 입력되지 않았습니다")
    @Schema(description = "게시물 seq 번호")
    private Long brdLineSeq;

    //@NotNull(message = "게시판 시퀀스가 입력되지 않았습니다.")
    @Schema(description = "게시판 seq")
    private Long brdHeaderSeq;

    @Schema(description = "삭제 여부")
    private String delYn;

    @Schema(description = "BrdLineInfoResponse")
    BrdLineInfoResponse brdLineInfoResponse;
}
