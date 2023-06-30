package com.example.ulsu.service;

import com.example.ulsu.makeroom.requestDto.BrdFileSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdLineSaveRequest;
import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface BrdService {

    List<BrdHeaderInfoResponse> getHeaderList();
    void FileSave(@Validated BrdFileSaveRequest brdFileSaveRequest);
    Long LineSave(BrdLineSaveRequest brdLineSaveRequest);
}
