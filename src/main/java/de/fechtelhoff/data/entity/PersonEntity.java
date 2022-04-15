package de.fechtelhoff.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import de.fechtelhoff.data.common.AbstractEntity;
import de.fechtelhoff.data.common.EntityConstants;

@Entity
@Table(name = "person")
@SuppressWarnings({"java:S2160", "JpaDataSourceORMInspection"}) // java:S2160 -> Subclasses that add fields should override "equals"
public class PersonEntity extends AbstractEntity {

	@Column(nullable = false, length = EntityConstants.TEXT_SIZE)
	public String firstName;

	@Column(nullable = false, length = EntityConstants.TEXT_SIZE)
	public String lastName;

	public PersonEntity() {
		super();
	}

	public PersonEntity(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}
}
