package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbWeatherId generated by hbm2java
 */
@Embeddable
public class TbWeatherId implements java.io.Serializable {

	private int cityId;
	private Date weatherDate;

	public TbWeatherId() {
	}

	public TbWeatherId(int cityId, Date weatherDate) {
		this.cityId = cityId;
		this.weatherDate = weatherDate;
	}

	@Column(name = "CITY_ID", nullable = false)
	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Column(name = "WEATHER_DATE", nullable = false, length = 10)
	public Date getWeatherDate() {
		return this.weatherDate;
	}

	public void setWeatherDate(Date weatherDate) {
		this.weatherDate = weatherDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbWeatherId))
			return false;
		TbWeatherId castOther = (TbWeatherId) other;

		return (this.getCityId() == castOther.getCityId()) && ((this.getWeatherDate() == castOther.getWeatherDate())
				|| (this.getWeatherDate() != null && castOther.getWeatherDate() != null
						&& this.getWeatherDate().equals(castOther.getWeatherDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCityId();
		result = 37 * result + (getWeatherDate() == null ? 0 : this.getWeatherDate().hashCode());
		return result;
	}

}
