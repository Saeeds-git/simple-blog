package com.saeed.dto;

import com.saeed.enums.JobEnum;

import java.time.LocalDateTime;

public class AdvertisementDTO {

	private Long id;

	private Long companyId;

	private String description;

	private Boolean isClosed;

	private JobEnum jobEnum;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
