package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class User {
	@Id
	private String userName; 
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name ="USER_ROLE",
	joinColumns = {
			@JoinColumn(name="USER_ID")
			
	},
	inverseJoinColumns = {
			@JoinColumn(name="ROLE_ID")
	}
			
			)
	private Set<Role>role;

}