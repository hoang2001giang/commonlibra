package com.hoang2001giang.Libra.file.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileInVO {
    private MultipartFile file;
}
