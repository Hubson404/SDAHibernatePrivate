package org.example;

import javax.persistence.*;

@Entity
@Table(name = "REGIONS")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REGION_ID")
	private int regionId;

	@Column(name = "REGION_NAME", unique = false)
	private String regionName;

	public Region(){};

	public Region(String regionName) {
		this.regionName = regionName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "Region{" +
				   "regionId=" + regionId +
				   ", regionName='" + regionName + '\'' +
				   '}';
	}
}
