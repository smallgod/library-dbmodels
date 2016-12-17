package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbCity generated by hbm2java
 */
@Entity
@Table(name = "tb_city", catalog = "gnamp_v4")
public class TbCity implements java.io.Serializable {

	private int cityId;
	private String name;
	private String province;
	private Set<TbWeather> tbWeathers = new HashSet<TbWeather>(0);
	private Set<TbTerminal> tbTerminals = new HashSet<TbTerminal>(0);

	public TbCity() {
	}

	public TbCity(int cityId, String name, String province) {
		this.cityId = cityId;
		this.name = name;
		this.province = province;
	}

	public TbCity(int cityId, String name, String province, Set<TbWeather> tbWeathers, Set<TbTerminal> tbTerminals) {
		this.cityId = cityId;
		this.name = name;
		this.province = province;
		this.tbWeathers = tbWeathers;
		this.tbTerminals = tbTerminals;
	}

	@Id

	@Column(name = "CITY_ID", unique = true, nullable = false)
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "NAME", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PROVINCE", nullable = false, length = 64)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbCity")
	public Set<TbWeather> getTbWeathers() {
		return this.tbWeathers;
	}

	public void setTbWeathers(Set<TbWeather> tbWeathers) {
		this.tbWeathers = tbWeathers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbCity")
	public Set<TbTerminal> getTbTerminals() {
		return this.tbTerminals;
	}

	public void setTbTerminals(Set<TbTerminal> tbTerminals) {
		this.tbTerminals = tbTerminals;
	}

}
