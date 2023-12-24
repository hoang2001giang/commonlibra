package com.hoang2001giang.Libra.file.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileInVO {
    private String mappedEntity;
    private String objectId;
    private MultipartFile file;
}
