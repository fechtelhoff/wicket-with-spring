package de.fechtelhoff.data.entityservice;

import org.springframework.data.jpa.repository.JpaRepository;
import de.fechtelhoff.data.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}