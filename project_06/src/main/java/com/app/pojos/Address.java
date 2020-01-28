package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String flatNo;
	private String buildingName;
	private String Area;
	private String City;
	
	public Address() 
	{	}

	public Address(String flatNo, String buildingName, String area, String city) 
	{
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.Area = area;
		this.City = city;
	}

	@Column(name = "cust_flatno")
	public String getFlatNo() 
	{
		return flatNo;
	}

	public void setFlatNo(String flatNo) 
	{
		this.flatNo = flatNo;
	}

	@Column(name = "cust_buildingname")
	public String getBuildingName() 
	{
		return buildingName;
	}

	public void setBuildingName(String buildingName) 
	{
		this.buildingName = buildingName;
	}

	@Column(name = "cust_area")
	public String getArea() 
	{
		return Area;
	}

	public void setArea(String area) 
	{
		Area = area;
	}

	@Column(name = "cust_city")
	public String getCity() 
	{
		return City;
	}

	public void setCity(String city) 
	{
		City = city;
	}

	@Override
	public String toString() 
	{
		return "Address [flatNo=" + flatNo + ", buildingName=" + buildingName + ", Area=" + Area + ", City=" + City
				+ "]";
	}	
}
