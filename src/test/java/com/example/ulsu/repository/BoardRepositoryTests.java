package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdFile;
import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.entity.BrdLine;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BrdLineRepository brdLineRepository;
    @Autowired
    private BrdHeaderRepository brdHeaderRepository;
    @Autowired
    private BrdFileRepository brdFileRepository;

    @Test
    public void checkLine(){

    }


    @Test
    public void testInsert(){

        BrdLine brdLine = new BrdLine();
        brdLine.changeBrdHeaderSeq(2L);
        brdLine.changeBrdTtl("공부중입니다....4");
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

    @Test
    public void testFile(){
        BrdFile brdFile = new BrdFile();
        brdFile.changeBrdLineSeq(1L);
        brdFile.changeFilePath("safasdf");
        brdFile.changeFileExtension("png");

        brdFileRepository.save(brdFile);
    }

    @Test
    public void testPaging(){

        //1 page order by bno desc;
        Pageable pageable = PageRequest.of(0,10, Sort.by("brdLineSeq").descending());

        Page<BrdLine> result = brdLineRepository.findAll(pageable);

        log.info("total count: "+result.getTotalElements());
        log.info("total pages: "+result.getTotalPages());
        log.info("page number: "+result.getNumber());
        log.info("page size: "+result.getSize());

        List<BrdLine> todoList = result.getContent();

        todoList.forEach(brdLine -> log.info(brdLine.getCn()));
    }

    @Test
    public void testPagingList(){
        String[] types = {"t","c","w"};

        String keyword = "이거없어임마";

        Pageable pageable = PageRequest.of(0,10,Sort.by("brdLineSeq").descending());

        Page<BrdLine> result = brdLineRepository.searchAll(types, keyword, pageable);

        log.info(result.getTotalPages());

        //pag size
        log.info(result.getSize());

        //pageNumber
        log.info(result.getNumber());

        //prev next
        log.info(result.hasPrevious() + ": " + result.hasNext());

        result.getContent().forEach(brdLine -> log.info(brdLine));
    }

}
