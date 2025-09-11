/**
 * 
 */
package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "generalCustomerRank_tbl")
public class GeneralCustomerRank extends BaseEntity implements Serializable {
	private String genCusRankCode;
	private String genCusRankTitle;
	private String description;
	private Float startPointRank;
	private Float endPointRank;
	private Timestamp dateOfCreate;
	private Timestamp dateOfUpdate;
	private String statusId;

	@OneToMany(mappedBy = "generalCustomerRank", cascade = CascadeType.ALL)
	private List<CustomerHistoryRank> listHistoryRanks;

}
