package com.spring.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {

	private List<String> cityList;
	private Set<String> countrySet;
	private Map<Integer, String> zipCityMap;
	private Properties cityCountryProps;
	
	public List<String> getCityList() {
		return cityList;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	public Set<String> getCountrySet() {
		return countrySet;
	}
	public void setCountrySet(Set<String> countrySet) {
		this.countrySet = countrySet;
	}
	public Map<Integer, String> getZipCityMap() {
		return zipCityMap;
	}
	public void setZipCityMap(Map<Integer, String> zipCityMap) {
		this.zipCityMap = zipCityMap;
	}
	public Properties getCityCountryProps() {
		return cityCountryProps;
	}
	public void setCityCountryProps(Properties cityCountryProps) {
		this.cityCountryProps = cityCountryProps;
	}
}
