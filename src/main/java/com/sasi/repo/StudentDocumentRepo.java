package com.sasi.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sasi.entity.StudentDocumentEntity;

public interface StudentDocumentRepo extends CrudRepository<StudentDocumentEntity, String>{
	
	Optional<StudentDocumentEntity> findByPersonId(String personId);
}