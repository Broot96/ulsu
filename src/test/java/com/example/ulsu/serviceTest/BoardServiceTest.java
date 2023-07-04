package com.example.ulsu.serviceTest;

import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.makeroom.requestDto.BrdLineSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdPageRequest;
import com.example.ulsu.makeroom.responseDto.BrdLineInfoResponse;
import com.example.ulsu.makeroom.responseDto.BrdPageResponse;
import com.example.ulsu.service.BrdService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

    @Autowired
    private BrdService brdService;

    @Test
    public void readOneTest(){
        BrdLineInfoResponse brdLineInfoResponse = brdService.readLine(1L);

        log.info(brdLineInfoResponse.getBrdTtl());
        log.info(brdLineInfoResponse.getBrdTtl());
        log.info(brdLineInfoResponse.getBrdTtl());
    }

    @Test
    public void modify(){
        BrdLineSaveRequest brdLineSaveRequest = new BrdLineSaveRequest();

        brdLineSaveRequest.setBrdLineSeq(3L);
        brdLineSaveRequest.setBrdHeaderSeq(2L);
        brdLineSaveRequest.setBrdTtl("공부안합니다....3");
        brdLineSaveRequest.setWrtTeam("얼수팀");
        brdLineSaveRequest.setWrtName("권석근");
        brdLineSaveRequest.setCn("spring boot와 jpa react공부를 해봅시다!!!!!!!!!!!!");
        brdLineSaveRequest.setIntqCnt(0);
        brdLineSaveRequest.setPwd("1234");
        brdLineSaveRequest.setDelYn("N");
        brdService.modify(brdLineSaveRequest);
    }

    @Test
    public void remove(){
        brdService.remove(4L);
    }

    @Test
    public void testList(){
        BrdPageRequest brdPageRequest = BrdPageRequest.builder()
                .type("tcw")
                .keyword("asdlfdnsdf")
                .page(1)
                .size(10)
                .build();

        BrdPageResponse<BrdLineInfoResponse> responseDTO = brdService.list(brdPageRequest);
       log.info(responseDTO.getPageResponseList());
    }
}
