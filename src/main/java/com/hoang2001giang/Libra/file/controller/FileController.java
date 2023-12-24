package com.hoang2001giang.Libra.file.controller;

import com.hoang2001giang.Libra.file.dto.UploadFileInVO;
import com.hoang2001giang.Libra.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/files")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@ModelAttribute UploadFileInVO inVO) {
        return new ResponseEntity<>(fileService.uploadFile(inVO), HttpStatus.CREATED);
    }
}
