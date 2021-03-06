package com.ernest.controllerview.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	    @NotNull(message = "Please enter a first name")
	    @Size(min = 2, max=75, message = "First Name must be between 2 and 75 characters long")
	    private String firstName;
	    @NotNull(message = "Please enter a last name")
	    @Size(min = 2, max = 75, message = "Last Name must be between 2 and 75 characters long")
	    private String lastName;
	    @NotNull(message = "Please enter a email")
	    @Size(min = 2, max=200, message = "Email must be between 2 and 200 characters long")
	    @Email
	    private String email;
	    @NotNull(message = "Please enter a first name")
	    @Size(min = 5, message = "Password must be at leat 5 characters long")
	    private String password;
	    @Transient
	    private String passwordConfirmation;
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public User() {
	    }
	    public User(String firstName, String lastName, String email, String password) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.email = email;
	    	this.password = password;
	    	
	    }
	    
	    
	    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}


		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
}
