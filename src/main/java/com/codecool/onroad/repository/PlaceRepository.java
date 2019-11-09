package com.codecool.onroad.repository;

import com.codecool.onroad.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
