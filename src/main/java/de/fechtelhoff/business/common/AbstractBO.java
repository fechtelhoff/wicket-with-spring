package de.fechtelhoff.business.common;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractBO implements Serializable {

	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
