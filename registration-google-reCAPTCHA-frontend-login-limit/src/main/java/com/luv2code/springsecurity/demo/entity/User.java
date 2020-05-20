package com.luv2code.springsecurity.demo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "enabled")
	private Long enabled;
	
	@Column(name = "accountNonExpired")
	private Long accountNonExpired;
	
	@Column(name = "accountNonLocked")
	private Long accountNonLocked;
	
	@Column(name = "credentialsNonExpired")
	private Long credentialsNonExpired;
	
	

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User() {
	}

	public User(String userName, String password, String firstName, String lastName, String email, Long enabled,
			Long accountNonExpired, Long accountNonLocked, Long credentialsNonExpired, Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.roles = roles;
	}



	public User(String userName, String password, String firstName, String lastName, String email,
			Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Long getEnabled() {
		return enabled;
	}

	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}

	public Long getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Long accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Long getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Long accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Long getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Long credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", enabled=" + enabled + ", accountNonExpired="
				+ accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired="
				+ credentialsNonExpired + ", roles=" + roles + "]";
	}


}
