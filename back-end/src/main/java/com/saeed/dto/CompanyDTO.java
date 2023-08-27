package com.saeed.dto;

import com.saeed.enums.CategoryEnum;

import java.time.LocalDateTime;

public class CompanyDTO {

	private Long id;

	private String name;

	private String address;

	private Long startYear;

	private String region;

	private String description;

	private String techStack;

	private CategoryEnum categoryEnum;

	private LocalDateTime createDateTime;

	private LocalDateTime updateDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getStartYear() {
		return startYear;
	}

	public void setStartYear(Long startYear) {
		this.startYear = startYear;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public CategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	public void setCategoryEnum(CategoryEnum categoryEnum) {
		this.categoryEnum = categoryEnum;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
