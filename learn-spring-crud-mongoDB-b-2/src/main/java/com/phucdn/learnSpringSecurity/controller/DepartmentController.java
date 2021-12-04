package com.phucdn.learnSpringSecurity.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phucdn.learnSpringSecurity.entity.DepartmentEntity;
import com.phucdn.learnSpringSecurity.exception.DepartmentException;
import com.phucdn.learnSpringSecurity.repository.DepartmentRepository;
import com.phucdn.learnSpringSecurity.service.DepartmentService;
import com.phucdn.learnSpringSecurity.utils.Constant;
import com.phucdn.learnSpringSecurity.utils.DateInstance;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

	// cau hinh ghi log file trong spring
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public ResponseEntity<?> getAllDepartments() {
		return new ResponseEntity<>(departmentRepository.getAllDepartmentWithActivateStatus(), HttpStatus.OK);
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<?> getDepartmentByDepartmentId(@PathVariable("id") String depId) {
		LOGGER.info("Find department By dedpartment_id: " + depId);
		LOGGER.trace("This is TRACE");
		LOGGER.debug("This is DEBUG");
		LOGGER.info("This is INFO");
		LOGGER.warn("This is WARN");
		LOGGER.error("This is ERROR");
		Optional<DepartmentEntity> findDepByDepId = departmentRepository.findByDepId(depId);

		return findDepByDepId.map(dep -> ResponseEntity.ok().body(dep))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/departments")
	public ResponseEntity<?> createNewDep(@RequestBody DepartmentEntity depEntity) {
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);

		depEntity.setDateOfCreate(dateOfCreate);
		depEntity.setStatus(Constant.DEPARTMENT_DEMO.ACTIVATE_STATUS);
		return new ResponseEntity<>(departmentService.save(depEntity), HttpStatus.OK);
	}

	@PutMapping("/departments/{id}")
	public ResponseEntity<?> updateDepartmentByDepId(@PathVariable("id") String depId,
			@RequestBody DepartmentEntity departmentEntity) {
		Optional<DepartmentEntity> depOptional = departmentRepository.findByDepId(depId);

		return depOptional.map(dep -> {
			dep.setDepName(departmentEntity.getDepName());
			dep.setUpdateBy(departmentEntity.getUpdateBy());
			dep.setStatus(Constant.DEPARTMENT_DEMO.ACTIVATE_STATUS);
			dep.setDateOfUpdate(DateInstance.getCurrentTime());
			dep.setDescription(departmentEntity.getDescription());
			final DepartmentEntity updateDepartment = departmentService.save(dep);
			return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<?> deleteDepartmentByDepId(@PathVariable("id") String depId) {
		DepartmentEntity departmentEntity = departmentRepository.findByDepId(depId)
				.orElseThrow(() -> new DepartmentException("Department does not exsit with this id:" + depId));

		departmentService.delete(departmentEntity);
		Map<String, Boolean> response = new HashMap<>();

		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/departments/banDep/{id}")
	public ResponseEntity<?> banDepartmentByDeptId(@PathVariable("id") String depId) {
		DepartmentEntity departmentEntity = departmentRepository.findByDepId(depId)
				.orElseThrow(() -> new DepartmentException("Department does not exsit with this id:" + depId));

		Optional<DepartmentEntity> banDep = departmentService.changeStatusOfDepartment(depId,
				Constant.DEPARTMENT_DEMO.IN_ACTICATE_STATUS);

		return new ResponseEntity<>(banDep, HttpStatus.OK);

	}
}
