package com.phucdn.learnSpringSecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.entity.LockerEntity;
import com.phucdn.learnSpringSecurity.repository.LockerRepository;
import com.phucdn.learnSpringSecurity.service.LockerService;
import com.phucdn.learnSpringSecurity.utils.Constant;
import com.phucdn.learnSpringSecurity.utils.DateInstance;

@RestController
@RequestMapping("/api/v1/locker")
public class LokerController {

	@Autowired
	private LockerService lokerService;
	
	@Autowired
	private LockerRepository lockerRepository;
	
	@GetMapping("")
	public ResponseEntity<?> loadAllLoker() {
		
		return new ResponseEntity<>(lokerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLockerById(@PathVariable("id") String id) {
		Optional<LockerEntity> lockOpt = lokerService.findById(id);
		
		return lockOpt.map(lock -> ResponseEntity.ok().body(lock))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	public ResponseEntity<?> addNewLocker(@RequestBody LockerEntity lockerEntity){
		lockerEntity.setCreateBy(Constant.LOCKER_DEMO.CREATE_BY);
		lockerEntity.setDateOfCreate(DateInstance.getCurrentTime());
		lockerEntity.setDescription(Constant.LOCKER_DEMO.DESCRIPTION);
		lockerEntity.setStatus(Constant.LOCKER_DEMO.ACTIVATE_STATUS);
		lokerService.save(lockerEntity);
		return new ResponseEntity<>(lokerService.save(lockerEntity), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> findLockerBySearch(@RequestParam(name = "input", required = true) String search,
												@RequestParam(name = "pageSize", required = false, defaultValue = "3") Optional<Integer> pageSize,
												@RequestParam(name = "pageNum", required = false, defaultValue = "0") Optional<Integer> pageNum) {
		
		int pageSizeIn = pageSize.get().intValue();
		int pageNumIn = pageNum.get().intValue();
		
		String realSearch = search.trim();
		
		if (realSearch.isEmpty() || realSearch.isBlank()) {
			return new ResponseEntity<>("The input search is not valid. Please input again!", HttpStatus.BAD_REQUEST);
		}
		
		if (pageNumIn < 0 || pageSizeIn <= 0) {
			return new ResponseEntity<>("The page size or page num input is not valid. Please input again.(Page size is larger than 1, and page num is greater than 0)", HttpStatus.NOT_ACCEPTABLE);
		}
		
		List<LockerEntity> listReturn = new ArrayList<>();
		
		Pageable paging;
		if (pageNum.isEmpty()) {
			paging = PageRequest.ofSize(pageSizeIn);
		}else {
			paging = PageRequest.of(pageNumIn, pageSizeIn);
		}
		
		Page<LockerEntity> pageLockRe = lockerRepository.findLokerBySearch(search, paging);
		listReturn = pageLockRe.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("currentPage", pageLockRe.getNumber());
		response.put("employees", listReturn);			
		response.put("totalItems", pageLockRe.getTotalElements());
		response.put("totalPages", pageLockRe.getTotalPages());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
