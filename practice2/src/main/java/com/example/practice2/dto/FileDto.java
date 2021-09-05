package com.example.practice2.dto;

import com.example.practice2.domain.entity.File;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FileDto {
    private Long id;
    private String origFilename;
    private String filename;
    private String filePath;

    public File toEntity() {
        File file = File.builder()
                .id(id)
                .origFilename(origFilename)
                .filename((filename))
                .filePath(filePath)
                .build();
        return file;
    }

    @Builder
    public FileDto(Long id, String origFilename, String filename, String filePath) {
        this.id = id;
        this.origFilename = origFilename;
        this.filename = filename;
        this.filePath = filePath;
    }
}
