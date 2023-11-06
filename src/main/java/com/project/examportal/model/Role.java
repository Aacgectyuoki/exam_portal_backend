package com.project.examportal.model;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
    private Long roleId;
    private String roleName;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	@ToString.Exclude
	private Set<UserRole> userRoles=new HashSet<>();


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Role(Long roleId, String roleName, Set<UserRole> userRoles) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userRoles = userRoles;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Role role = (Role) o;
		return getRoleId() != null && Objects.equals(getRoleId(), role.getRoleId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
