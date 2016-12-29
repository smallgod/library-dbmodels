package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbWeather generated by hbm2java
 */
@Entity
@Table(name = "tb_weather")
public class TbWeather implements java.io.Serializable {

	private TbWeatherId id;
	private TbCity tbCity;
	private int weatherType;
	private int high;
	private int low;
	private String weatherText;

	public TbWeather() {
	}

	public TbWeather(TbWeatherId id, TbCity tbCity, int weatherType, int high, int low, String weatherText) {
		this.id = id;
		this.tbCity = tbCity;
		this.weatherType = weatherType;
		this.high = high;
		this.low = low;
		this.weatherText = weatherText;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cityId", column = @Column(name = "CITY_ID", nullable = false)),
			@AttributeOverride(name = "weatherDate", column = @Column(name = "WEATHER_DATE", nullable = false, length = 10)) })
	public TbWeatherId getId() {
		return this.id;
	}

	public void setId(TbWeatherId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID", nullable = false, insertable = false, updatable = false)
	public TbCity getTbCity() {
		return this.tbCity;
	}

	public void setTbCity(TbCity tbCity) {
		this.tbCity = tbCity;
	}

	@Column(name = "WEATHER_TYPE", nullable = false)
	public int getWeatherType() {
		return this.weatherType;
	}

	public void setWeatherType(int weatherType) {
		this.weatherType = weatherType;
	}

	@Column(name = "HIGH", nullable = false)
	public int getHigh() {
		return this.high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	@Column(name = "LOW", nullable = false)
	public int getLow() {
		return this.low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	@Column(name = "WEATHER_TEXT", nullable = false, length = 4096)
	public String getWeatherText() {
		return this.weatherText;
	}

	public void setWeatherText(String weatherText) {
		this.weatherText = weatherText;
	}

}