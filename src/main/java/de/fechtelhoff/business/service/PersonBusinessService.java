package de.fechtelhoff.business.service;

import java.util.List;
import de.fechtelhoff.business.service.bo.PersonBO;

public interface PersonBusinessService {

	List<PersonBO> lookupPersons();
}