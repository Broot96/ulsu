package com.example.ulsu.service;

import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface BrdService {

    List<BrdHeaderInfoResponse> getHeaderList();
}
