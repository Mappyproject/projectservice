package com.mappy.projectservice.repository;

import com.mappy.projectservice.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {
}
