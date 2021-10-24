package com.phucdn.learnSpringSecurity.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.phucdn.learnSpringSecurity.entity.FileEntity;

public interface FileStorageService {

	Stream<FileEntity> getAllFiles();

	FileEntity getFile(String id);

	FileEntity saveFile(MultipartFile file) throws IOException;

}
