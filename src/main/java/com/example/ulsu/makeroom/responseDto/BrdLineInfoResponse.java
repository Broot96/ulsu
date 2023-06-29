package com.example.ulsu.makeroom.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrdLineInfoResponse {

    @Schema(description = "게시물 seq")
    private Long brdLineSeq;

    @Schema(description = "게시판 seq")
    private Long brdHeaderSeq;

    @Schema(description = "게시물 제목")
    private String ttl;
}
