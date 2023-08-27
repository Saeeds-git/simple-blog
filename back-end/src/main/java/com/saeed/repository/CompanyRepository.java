package com.saeed.repository;

import com.saeed.entity.CompanyEntity;
import com.saeed.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

	List<CompanyEntity> findByCategoryEnum(CategoryEnum categoryEnum);

}
