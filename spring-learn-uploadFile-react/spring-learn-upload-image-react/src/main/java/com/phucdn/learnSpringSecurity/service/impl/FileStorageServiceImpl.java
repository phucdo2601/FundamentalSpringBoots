package com.phucdn.learnSpringSecurity.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.phucdn.learnSpringSecurity.entity.FileEntity;
import com.phucdn.learnSpringSecurity.repository.FileRepository;
import com.phucdn.learnSpringSecurity.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Autowired
	private FileRepository fileRepository;

	@Override
	public FileEntity saveFile(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
		return fileRepository.save(fileEntity);

	}

	@Override
	public FileEntity getFile(String id) {
		return fileRepository.findById(id).get();
	}

	@Override
	public Stream<FileEntity> getAllFiles() {
		return fileRepository.findAll().stream();
	}
}
