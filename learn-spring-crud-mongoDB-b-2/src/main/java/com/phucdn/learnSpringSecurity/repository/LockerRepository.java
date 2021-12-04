package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.LockerEntity;

@Repository
public interface LockerRepository extends MongoRepository<LockerEntity, String> {

	@Query("{$and : [ {$or: [{'locker_name': {$regex: :#{#search}}}, {'storage': {$regex: :#{#search}}}]}, {'is_block': false} ]}")
	public Page<LockerEntity> findLokerBySearch(@Param("search") Object search, Pageable pageable);
}
