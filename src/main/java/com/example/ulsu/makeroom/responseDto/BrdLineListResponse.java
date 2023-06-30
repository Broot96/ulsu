package com.example.ulsu.makeroom.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrdLineListResponse {

    private Long brdLineSeq;
    private String ttl;
    private String wrtTeam;
    private LocalDateTime regDate;
    private int intqCnt;
    private int replyCnt;
}
