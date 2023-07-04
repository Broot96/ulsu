package com.example.ulsu.makeroom.responseDto;

import com.example.ulsu.entity.BrdLine;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Function;

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

    @Schema(description = "게시물 작성일")
    private LocalDateTime regDate;

    @Schema(description = "게시물 수정일")
    private LocalDateTime modDate;

    @Service
    public static class BrdLineInfoMapper implements Function<BrdLine, BrdLineInfoResponse>{

        @Override
        public BrdLineInfoResponse apply(BrdLine brdLine) {
            return BrdLineInfoResponse.builder()
                    .brdLineSeq(brdLine.getBrdLineSeq())
                    .brdHeaderSeq(brdLine.getBrdHeaderSeq())
                    .brdTtl(brdLine.getBrdTtl())
                    .wrtTeam(brdLine.getWrtTeam())
                    .wrtName(brdLine.getWrtName())
                    .cn(brdLine.getCn())
                    .intqCnt(brdLine.getIntqCnt())
                    .pwd(brdLine.getPwd())
                    .delYn(brdLine.getDelYn())
                    .aYn(brdLine.getAYn())
                    .regDate(brdLine.getRegDate())
                    .modDate(brdLine.getModDate())
                    .build();
        }
    }


}
