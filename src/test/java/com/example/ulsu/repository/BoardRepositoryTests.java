package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.entity.BrdLine;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BrdLineRepository brdLineRepository;
    @Autowired
    private BrdHeaderRepository brdHeaderRepository;


    @Test
    public void checkLine(){

    }


    @Test
    public void testInsert(){

        BrdLine brdLine = new BrdLine();
        brdLine.changeBrdHeaderSeq(2L);
        brdLine.changeBrdTtl("부트공부중입니다.");
        brdLine.changeWrtTeam("얼수팀");
        brdLine.changeWrtName("권석근");
        brdLine.changeCn("spring boot와 jpa react공부를 해봅시다");
        brdLine.changeIntqCnt(0);
        brdLine.changePwd("1234");
        brdLine.changeDelYn("N");
        brdLineRepository.save(brdLine);

    }

    @Test
    public void testUpdate(){

        Optional<BrdLine> result = brdLineRepository.findById(1L);
        BrdLine brdLine = result.orElseThrow();

        brdLine.changeCn("spring boot와 jpa react공부를 해봅시다잇~~");
        brdLineRepository.save(brdLine);
    }

    @Test
    public void testSelect(){

        Optional<BrdLine> result = brdLineRepository.findById(1L);
        BrdLine brdLine = result.orElseThrow();

        log.info(brdLine.getBrdHeader().getTtl());

    }
    @Test
    public void testSelectAll(){

        List<BrdHeader> result = brdHeaderRepository.findAll();

        log.info("1번 "+result.get(0).getTtl());
        log.info("2번 "+result.get(1).getTtl());
        log.info("3번 "+result.get(2).getTtl());



    }
}
