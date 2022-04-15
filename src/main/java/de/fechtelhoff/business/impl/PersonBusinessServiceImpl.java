package de.fechtelhoff.business.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import de.fechtelhoff.business.service.PersonBusinessService;
import de.fechtelhoff.business.service.bo.PersonBO;
import de.fechtelhoff.business.service.mapper.PersonMapper;
import de.fechtelhoff.data.entity.PersonEntity;
import de.fechtelhoff.data.entityservice.PersonRepository;

@Repository
public class PersonBusinessServiceImpl implements PersonBusinessService {

	private final PersonMapper mapper;
	private final PersonRepository personRepository;

	@Autowired
	public PersonBusinessServiceImpl(final PersonMapper mapper, final PersonRepository personRepository) {
		this.mapper = mapper;
		this.personRepository = personRepository;
	}

	@Override
	public List<PersonBO> lookupPersons() {
		final List<PersonEntity> persons = personRepository.findAll();
		return mapper.map(persons);
	}
}
