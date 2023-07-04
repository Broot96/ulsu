package com.example.ulsu.service;

import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.makeroom.requestDto.BrdFileSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdLineInfoRequest;
import com.example.ulsu.makeroom.requestDto.BrdLineSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdPageRequest;
import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.makeroom.responseDto.BrdLineInfoResponse;
import com.example.ulsu.makeroom.responseDto.BrdPageResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface BrdService {

    List<BrdHeaderInfoResponse> getHeaderList();
    void FileSave(@Validated BrdFileSaveRequest brdFileSaveRequest);
    Long LineSave(BrdLineSaveRequest brdLineSaveRequest);
    List<BrdLine> selectLineAll(BrdPageRequest brdPageRequest);

    BrdLineInfoResponse readLine(Long brdLineSeq);          //게시물 조회
    void modify(BrdLineSaveRequest brdLineSaveRequest);     //게시물 수정
    void remove(Long brdLineSeq);

    BrdPageResponse<BrdLineInfoResponse> list(BrdPageRequest brdPageRequest);

}
