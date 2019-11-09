package com.codecool.onroad.repository;

import com.codecool.onroad.model.Road;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadRepository extends JpaRepository<Road, Long> {
}
