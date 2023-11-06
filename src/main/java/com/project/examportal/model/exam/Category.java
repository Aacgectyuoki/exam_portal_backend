package com.project.examportal.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "category")
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String title;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
	@ToString.Exclude
	private Set<Quiz> quizzes = new LinkedHashSet<>();
    
    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Category(Long cid, String title, String description, Set<Quiz> quizzes) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.quizzes = quizzes;
	}

	public Category() {
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
		Category category = (Category) o;
		return getCid() != null && Objects.equals(getCid(), category.getCid());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
