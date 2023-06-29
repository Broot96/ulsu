package com.example.ulsu.service.impl;

import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.repository.BrdHeaderRepository;
import com.example.ulsu.repository.BrdLineRepository;
import com.example.ulsu.service.BrdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BrdServiceImpl implements BrdService {

    private final BrdHeaderRepository brdHeaderRepository;

    private final BrdHeaderInfoResponse.BrdHeaderInfoDtoMapper brdHeaderInfoDtoMapper;

    private final BrdLineRepository brdLineRepository;
    @Override
    public List<BrdHeaderInfoResponse> getHeaderList() {

        List<BrdHeader> brdHeaderList = brdHeaderRepository.findAll();
        List<BrdHeaderInfoResponse> brdHeaderInfoResponseList = new ArrayList<>();

        for(int i = 0; i < brdHeaderList.size(); i++){
            BrdHeaderInfoResponse brdHeaderInfoResponse = brdHeaderInfoDtoMapper.apply(brdHeaderList.get(i));
            brdHeaderInfoResponseList.add(i,brdHeaderInfoResponse);
        }


        return brdHeaderInfoResponseList;
    }
}
