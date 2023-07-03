package com.example.ulsu.service.impl;

import com.example.ulsu.entity.BrdFile;
import com.example.ulsu.entity.BrdHeader;
import com.example.ulsu.entity.BrdLine;
import com.example.ulsu.makeroom.requestDto.BrdFileSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdLineSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdPageRequest;
import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.repository.BrdFileRepository;
import com.example.ulsu.repository.BrdHeaderRepository;
import com.example.ulsu.repository.BrdLineRepository;
import com.example.ulsu.service.BrdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class BrdServiceImpl implements BrdService {

    private final BrdHeaderRepository brdHeaderRepository;
    private final BrdHeaderInfoResponse.BrdHeaderInfoDtoMapper brdHeaderInfoDtoMapper;
    private final BrdLineRepository brdLineRepository;
    private final BrdFileRepository brdFileRepository;

    @Value("${upload.folder}")
    private String uploadFolder;

    @Override
    @Transactional
    public List<BrdHeaderInfoResponse> getHeaderList() {
        List<BrdHeader> brdHeaderList = brdHeaderRepository.findAll();
        List<BrdHeaderInfoResponse> brdHeaderInfoResponseList = new ArrayList<>();

        for (int i = 0; i < brdHeaderList.size(); i++) {
            BrdHeaderInfoResponse brdHeaderInfoResponse = brdHeaderInfoDtoMapper.apply(brdHeaderList.get(i));
            brdHeaderInfoResponseList.add(i, brdHeaderInfoResponse);
        }

        return brdHeaderInfoResponseList;
    }

    @Override
    @Transactional
    public void FileSave(BrdFileSaveRequest fileSaveRequest) {
        MultipartFile[] uploadFile = fileSaveRequest.getUploadFile();

        if (uploadFile != null) {
            for (MultipartFile multipartFile : uploadFile) {
                log.info("-------------------------------------------------");
                log.info("Upload File Name: " + multipartFile.getOriginalFilename());
                log.info("Upload File Size: " + multipartFile.getSize());

                String uploadFileName = multipartFile.getOriginalFilename();
                uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                String extension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                log.info("Only File Name: " + uploadFileName);
                log.info("Only File Extension: " + extension);

                UUID uuid = UUID.randomUUID();
                uploadFileName = uuid.toString() + "_" + uploadFileName;
                File saveFile = new File(uploadFolder, uploadFileName);

                BrdFileSaveRequest brdFileSaveRequest = new BrdFileSaveRequest();
                brdFileSaveRequest.setFilePath(uploadFileName);
                brdFileSaveRequest.setExtension(extension);
                brdFileSaveRequest.setBrdLineSeq(fileSaveRequest.getBrdLineSeq());

                BrdFile brdFile = new BrdFile();
                brdFile.changeBrdLineSeq(brdFileSaveRequest.getBrdLineSeq());
                brdFile.changeFilePath(brdFileSaveRequest.getFilePath());
                brdFile.changeFileExtension(brdFileSaveRequest.getExtension());

                try {
                    multipartFile.transferTo(saveFile);
                    brdFileRepository.save(brdFile);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }
        }
    }

    @Override
    public Long LineSave(BrdLineSaveRequest brdLineSaveRequest) {
        BrdLine brdLine = new BrdLine();
        brdLine.changeBrdHeaderSeq(1L);
        brdLine.changeBrdTtl(brdLineSaveRequest.getTtl());
        brdLine.changeWrtName(brdLineSaveRequest.getWrtName());
        brdLine.changePwd(brdLineSaveRequest.getPwd());
        brdLine.changeAyn("on".equals(brdLineSaveRequest.getAYn()) ? "Y" : "N");
        brdLine.changeCn(brdLineSaveRequest.getCn());
        brdLine.changeWrtTeam(brdLineSaveRequest.getWrtTeam());

        brdLineRepository.save(brdLine);
        Long brdLineSeq = brdLine.getBrdLineSeq();

        return brdLineSeq;
    }

    @Override
    public List<BrdLine> selectLineAll(BrdPageRequest brdPageRequest) {

        List<BrdLine> brdLineList = brdLineRepository.findAll(Sort.by(String.valueOf(brdPageRequest.getBrdHeaderSeq())).descending());


        return null;
    }
}
