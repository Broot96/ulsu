package com.example.ulsu.makeroom.responseDto;

import com.example.ulsu.entity.BrdHeader;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrdHeaderInfoResponse {

    @Schema(description = "게시판 seq")
    private Long brdHeaderSeq;

    @Schema(description = "게시판 제목")
    private String brdHeaderTtl;

    @Service
    public static class BrdHeaderInfoDtoMapper implements Function<BrdHeader, BrdHeaderInfoResponse>{

        @Override
        public BrdHeaderInfoResponse apply(BrdHeader brdHeader) {
            return BrdHeaderInfoResponse.builder()
                    .brdHeaderSeq(brdHeader.getBrdHeaderSeq())
                    .brdHeaderTtl(brdHeader.getTtl())
                    .build();
        }
    }
}
