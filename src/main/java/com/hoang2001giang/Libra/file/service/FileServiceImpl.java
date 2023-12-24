package com.hoang2001giang.Libra.file.service;

import com.hoang2001giang.Libra.file.data.FileEntity;
import com.hoang2001giang.Libra.file.data.FileRepository;
import com.hoang2001giang.Libra.file.dto.FileDto;
import com.hoang2001giang.Libra.file.dto.UploadFileInVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

@Service
public class FileServiceImpl implements FileService{
    @Autowired
    FileRepository fileRepository;

    @Override
    public FileDto uploadFile(UploadFileInVO inVO) {
        String path = saveFile(inVO);

        FileEntity createdFile = new FileEntity();
        BeanUtils.copyProperties(inVO, createdFile);
        createdFile.setPath(path);
//        fileRepository.save(createdFile);
        return entityToDto(createdFile);
    }

    private String saveFile(UploadFileInVO inVO) {
        try {
            MultipartFile multipartFile = inVO.getFile();
            String dir = Files.createTempDirectory("tmpDir").toFile().getAbsolutePath();
            File file = new File(dir + File.separator + multipartFile.getOriginalFilename());

            try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file))) {
                os.write(multipartFile.getBytes());
            }
            return dir;
        } catch (Exception e) {
            throw new RuntimeException("Unable to save file", e);
        }
    }

    private FileDto entityToDto(FileEntity entity) {
        FileDto dto = new FileDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
