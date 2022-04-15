package de.fechtelhoff.data.entityservice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import de.fechtelhoff.data.entity.PersonEntity;

@SpringBootTest
@Transactional
class PersonRepositoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(PersonRepositoryTest.class);

	@Autowired
	private PersonRepository repository;

	@Test
	void findAll() {
		List<PersonEntity> personEntities = repository.findAll();
		personEntities.forEach(personEntity -> LOG.info("{}", personEntity));
		assertNotNull(personEntities);
		assertFalse(personEntities.isEmpty());
	}

	@Test
	void save() {
		PersonEntity personEntity = new PersonEntity("Hinke", "Lotta");
		personEntity = repository.save(personEntity);
		LOG.info("{}", personEntity);
		assertNotNull(personEntity.id);
	}
}
