package com.hoang2001giang.Libra.file.service;

import com.hoang2001giang.Libra.file.dto.FileDto;
import com.hoang2001giang.Libra.file.dto.UploadFileInVO;

public interface FileService {
    FileDto uploadFile(UploadFileInVO inVO);
}
