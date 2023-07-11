package com.example.ulsu;

import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.service.BrdService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

   /* @Autowired
    private BrdService brdService;

    @Test
    public void selectTest(){

        List<BrdHeaderInfoResponse> result = brdService.getHeaderList();

        log.info(result.get(0).getBrdHeaderTtl());
        log.info(result.get(1).getBrdHeaderTtl());
        log.info(result.get(2).getBrdHeaderTtl());

    }*/

}
