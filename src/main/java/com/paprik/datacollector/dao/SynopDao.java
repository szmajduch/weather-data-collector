package com.paprik.datacollector.dao;

import com.paprik.datacollector.entities.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SynopDao extends JpaRepository<StationEntity, Long> {

}
