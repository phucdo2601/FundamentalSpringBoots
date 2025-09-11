package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customerHistoryRanks_tbl")
public class CustomerHistoryRank extends BaseEntity implements Serializable {
	private Timestamp dateOfCreate;
	private boolean isCurrent;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "genCusRankId")
	private GeneralCustomerRank generalCustomerRank;
}
