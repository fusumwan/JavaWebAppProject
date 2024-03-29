package com.app.ordertableweb.domain.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
import org.springframework.validation.annotation.Validated;
import com.app.ordertableweb.domain.utils.ByteConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import com.app.ordertableweb.domain.utils.StringConverter;

@Entity
@Table(name = "restaurant")
public class Restaurant implements java.io.Serializable {
	/*
	* Added insertable=false and updatable=false.
	* This means that this column will not be used in INSERT or UPDATE statements,
	* because its value is automatically generated by the database.
	*/
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	name = "UUID",
	strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "restaurant_id", updatable = false, insertable = false, nullable = false)
	@JsonProperty("restaurant_id")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String restaurant_id;
	@Column(name = "name")
	@JsonProperty("name")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String name;
	@Column(name = "image")
	@JsonProperty("image")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String image;
	@Column(name = "location")
	@JsonProperty("location")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String location;
	@Column(name = "contact_number")
	@JsonProperty("contact_number")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Integer contact_number;
	@Column(name = "longitude")
	@JsonProperty("longitude")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String longitude;
	@Column(name = "latitude")
	@JsonProperty("latitude")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String latitude;
	@Column(name = "description")
	@JsonProperty("description")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String description;
	// Referenced Table: tables, Referenced Column: restaurant_id
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Tables> tabless;
	// Referenced Table: timeperiod, Referenced Column: restaurant_id
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant",cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Timeperiod> timeperiods;
	public Restaurant() {
	}
	public Restaurant(
	String restaurant_id
	,
	String name
	,
	String image
	,
	String location
	,
	Integer contact_number
	,
	String longitude
	,
	String latitude
	,
	String description
	) {
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.image = image;
		this.location = location;
		this.contact_number = contact_number;
		this.longitude = longitude;
		this.latitude = latitude;
		this.description = description;
		this.Init();
	}
	public void Init() {
		if(this.tabless==null) {
			this.tabless=new ArrayList<Tables>();
		}
		if(this.timeperiods==null) {
			this.timeperiods=new ArrayList<Timeperiod>();
		}
	}
	public void setRestaurantId(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurantId() {
		return this.restaurant_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return this.image;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return this.location;
	}
	public void setContactNumber(Integer contact_number) {
		this.contact_number = contact_number;
	}
	public Integer getContactNumber() {
		return this.contact_number;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLongitude() {
		return this.longitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLatitude() {
		return this.latitude;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	public void setTables(List<Tables> tabless) {
		this.tabless = tabless;
	}
	public List<Tables> getTabless() {
		return this.tabless;
	}
	public void addTables(Tables tables) {
		if(this.tabless==null) {
			this.tabless=new ArrayList<Tables>();
		}
		this.tabless.add(tables);
		tables.setRestaurant(this);
	}
	public void setTimeperiod(List<Timeperiod> timeperiods) {
		this.timeperiods = timeperiods;
	}
	public List<Timeperiod> getTimeperiods() {
		return this.timeperiods;
	}
	public void addTimeperiod(Timeperiod timeperiod) {
		if(this.timeperiods==null) {
			this.timeperiods=new ArrayList<Timeperiod>();
		}
		this.timeperiods.add(timeperiod);
		timeperiod.setRestaurant(this);
	}
	@Override
	public String toString() {
		return "Restaurant [" +
		"restaurant_id"+
		"=" + StringConverter.toString(this.restaurant_id)+
		","+
		"name"+
		"=" + StringConverter.toString(this.name)+
		","+
		"image"+
		"=" + StringConverter.toString(this.image)+
		","+
		"location"+
		"=" + StringConverter.toString(this.location)+
		","+
		"contact_number"+
		"=" + StringConverter.toString(this.contact_number)+
		","+
		"longitude"+
		"=" + StringConverter.toString(this.longitude)+
		","+
		"latitude"+
		"=" + StringConverter.toString(this.latitude)+
		","+
		"description"+
		"=" + StringConverter.toString(this.description)+
		"]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Restaurant other = (Restaurant) obj;
		return Objects.equals(this.restaurant_id, other.restaurant_id)
			&& Objects.equals(this.name, other.name)
			&& Objects.equals(this.image, other.image)
			&& Objects.equals(this.location, other.location)
			&& Objects.equals(this.contact_number, other.contact_number)
			&& Objects.equals(this.longitude, other.longitude)
			&& Objects.equals(this.latitude, other.latitude)
			&& Objects.equals(this.description, other.description)
			&& Objects.equals(this.tabless, other.tabless)
			&& Objects.equals(this.timeperiods, other.timeperiods);
	}
}