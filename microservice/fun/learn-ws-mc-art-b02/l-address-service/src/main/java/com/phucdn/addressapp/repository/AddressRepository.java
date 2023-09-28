package com.phucdn.addressapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phucdn.addressapp.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	/**
	 * When defining a native query, we annotate our repository method with the @Query 
	 * annotation, set the nativeQuery=true attribute, and provide an SQL statement 
	 * as the value. In the example below, we can use the same parameters as in the custom JPQL query.
	 * @param employeeId
	 * @return
	 */
	@Query(nativeQuery = true, value =  "select ea.id, ea.lane1, ea.lane2, ea.state, ea.zip\r\n"
			+ "from address ea join employee e on e.id = ea.employee_id\r\n"
			+ "where e.id = :employeeId")
	List<Address> findAddressByEmployeeId(@Param("employeeId") Integer employeeId);
}
