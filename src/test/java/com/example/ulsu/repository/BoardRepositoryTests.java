package com.example.ulsu.repository;

import com.example.ulsu.entity.BrdHeader;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BrdLineRepository brdLineRepository;
    @Autowired
    private BrdHeaderRepository brdHeaderRepository;

    @Test
    public void testInsert(){


    }
}
