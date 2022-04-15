package de.fechtelhoff.business.service.mapper;

import java.io.Serializable;
import java.util.List;
import org.mapstruct.Mapper;
import de.fechtelhoff.business.service.bo.PersonBO;
import de.fechtelhoff.data.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface PersonMapper extends Serializable {

	PersonEntity map(final PersonBO person);

	PersonBO map(final PersonEntity person);

	List<PersonBO> map(final List<PersonEntity> persons);
}
