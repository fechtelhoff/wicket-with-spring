package de.fechtelhoff.business.service.bo;

import java.time.LocalDateTime;
import de.fechtelhoff.business.common.AbstractBO;

@SuppressWarnings("java:S1104") // java:S1104 -> Class variable fields should not have public accessibility
public class PersonBO extends AbstractBO {

	public Integer id;

	public String firstName;
	public String lastName;

	public Integer version;
	public LocalDateTime added;
	public LocalDateTime modified;
}
