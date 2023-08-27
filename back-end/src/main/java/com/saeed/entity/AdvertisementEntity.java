package com.saeed.entity;

import com.saeed.enums.JobEnum;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisement")
public class AdvertisementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "description", length = 2048)
	private String description;

	@Column(name = "isClosed")
	private Boolean isClosed;

	@Enumerated(EnumType.STRING)
	@Column(name = "jobEnum")
	private JobEnum jobEnum;

	@Column(name = "company_id")
	private Long companyId;

	@CreationTimestamp
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getClosed() {
		return isClosed;
	}

	public void setClosed(Boolean closed) {
		isClosed = closed;
	}

	public JobEnum getJobEnum() {
		return jobEnum;
	}

	public void setJobEnum(JobEnum jobEnum) {
		this.jobEnum = jobEnum;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
}
