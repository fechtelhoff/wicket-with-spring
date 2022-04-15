package de.fechtelhoff.data.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import org.apache.commons.lang3.builder.ToStringBuilder;

@MappedSuperclass
public class AbstractEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Integer id;

	@Version
	@Column(columnDefinition = "integer default 1")
	public Integer version;

	@Column(nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
	public LocalDateTime added;

	@Column(nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
	public LocalDateTime modified;

	public AbstractEntity() {
		// nop
	}

	public boolean isPersisted() {
		return getId() != null;
	}

	@PrePersist
	public void prePersist() {
		if (added == null) {
			added = LocalDateTime.now().withNano(0);
		}
		if (version == null) {
			version = 1;
		}
		preUpdate();
	}

	@PreUpdate
	public void preUpdate() {
		modified = LocalDateTime.now().withNano(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(final Integer version) {
		this.version = version;
	}

	public LocalDateTime getAdded() {
		return added;
	}

	public void setAdded(final LocalDateTime added) {
		this.added = added;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(final LocalDateTime modified) {
		this.modified = modified;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		AbstractEntity that = (AbstractEntity) obj;
		return Objects.equals(this.id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, getClass());
	}

	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
