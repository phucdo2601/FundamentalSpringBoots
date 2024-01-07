package com.phucdn.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.demo.models.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

	Optional<Club> findByTitle(String title);
}
