package com.example.ulsu.makeroom.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@AllArgsConstructor
public class BrdFileSaveRequest {

    @Schema(description = "게시물 seq 번호")
    private Long brdLineSeq;

    @Schema(description = "파일 경로")
    private String filePath;

    @Schema(description = "파일 명")
    private String fileName;

    @Schema(description = "파일 확장자")
    private String extension;

    private MultipartFile[] uploadFile;

    public BrdFileSaveRequest() {

    }
}
