package tn.enis.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User implements Serializable {
	@Id
	private String username;
	private String password;
	private int activated ;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;
	
	public User(String username, String password,int activated) {
		super();
		this.username = username;
		this.password = password;
		this.activated = activated;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getActivated() {
		return activated;
	}
	public void setActivated(int activated) {
		this.activated = activated;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
