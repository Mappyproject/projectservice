package com.mappy.projectservice.repository;

import com.mappy.projectservice.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends CrudRepository<Event, Long> {
}
