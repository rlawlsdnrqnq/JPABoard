package com.example.practice2.service;

import com.example.practice2.domain.entity.File;
import com.example.practice2.domain.repository.FileRepository;
import com.example.practice2.dto.FileDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FileService {
    FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(file.getId())
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
