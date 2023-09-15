package com.abhishek.emsrestapi.model;

import java.util.Date;

import org.apache.el.parser.AstFalse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_employee" )
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
//if column name and field name is same thn no need to use @column an.	
//	@JsonProperty("full_name")
	@Column(name = "name")
	@NotBlank(message ="name should not be null")
	private String name;
	
//	@JsonIgnore
	
	@Column(name ="age")
	private Long age;
	
	@Column(name ="location")
	private String location;
	
	@Column(name= "email")
	private String email;
	
	
	@Column(name = "department")
	@NotBlank(message ="department should not be null")
	private String department;
	
	
	@CreationTimestamp
	@Column(name = "created_at" , nullable = false, updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

}
