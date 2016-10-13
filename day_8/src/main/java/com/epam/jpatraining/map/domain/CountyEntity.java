package com.epam.jpatraining.map.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity(name = "county")
@EntityListeners(AuditListener.class)
public class CountyEntity implements Auditable {


	@Id
	@GeneratedValue
	private long id;
	
	@Version
	private Integer version;
	
	
	@Column(nullable = false)
	private String origId;
	
	
	@Column(nullable = false)	
	private String name;
	
	@OneToOne
	private CityEntity seat;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private int population;
	
	@Column(nullable = false)
	private int size;

	@Transient
	private String fullName;
	
	@Embedded
	private Audit audit = new Audit();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigId() {
		return origId;
	}

	public void setOrigId(String origId) {
		this.origId = origId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public CityEntity getSeat() {
		return seat;
	}

	public void setSeat(CityEntity seat) {
		this.seat = seat;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFullName() {
		if (fullName == null) {
			fullName = String.format("%s, %s, %s", id, origId, name); 
		}
		return fullName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audit == null) ? 0 : audit.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origId == null) ? 0 : origId.hashCode());
		result = prime * result + population;
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + size;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CountyEntity other = (CountyEntity) obj;
		if (audit == null) {
			if (other.audit != null) {
				return false;
			}
		} else if (!audit.equals(other.audit)) {
			return false;
		}
		if (color == null) {
			if (other.color != null) {
				return false;
			}
		} else if (!color.equals(other.color)) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (origId == null) {
			if (other.origId != null) {
				return false;
			}
		} else if (!origId.equals(other.origId)) {
			return false;
		}
		if (population != other.population) {
			return false;
		}
		if (seat == null) {
			if (other.seat != null) {
				return false;
			}
		} else if (!seat.equals(other.seat)) {
			return false;
		}
		if (size != other.size) {
			return false;
		}
		if (version == null) {
			if (other.version != null) {
				return false;
			}
		} else if (!version.equals(other.version)) {
			return false;
		}
		return true;
	}
	
	
	
	
}
