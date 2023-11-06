package com.project.examportal.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class Quiz {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long qId;
	    private String title;

	    @Column(length = 5000)
	    private String description;
	    private String maxMarks;
	    private String numberOfQuestions;
	    private boolean active = false;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Category category;

	    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonIgnore
		@ToString.Exclude
		private Set<Question> questions = new HashSet<>();
	    
	    public boolean isActive() {
	        return active;
	    }

	    public void setActive(boolean active) {
	        this.active = active;
	    }

		public Long getqId() {
			return qId;
		}

		public void setqId(Long qId) {
			this.qId = qId;
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

		public String getMaxMarks() {
			return maxMarks;
		}

		public void setMaxMarks(String maxMarks) {
			this.maxMarks = maxMarks;
		}

		public String getNumberOfQuestions() {
			return numberOfQuestions;
		}

		public void setNumberOfQuestions(String numberOfQuestions) {
			this.numberOfQuestions = numberOfQuestions;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public Set<Question> getQuestions() {
			return questions;
		}

		public void setQuestions(Set<Question> questions) {
			this.questions = questions;
		}

		public Quiz(Long qId, String title, String description, String maxMarks, String numberOfQuestions,
				boolean active, Category category, Set<Question> questions) {
			super();
			this.qId = qId;
			this.title = title;
			this.description = description;
			this.maxMarks = maxMarks;
			this.numberOfQuestions = numberOfQuestions;
			this.active = active;
			this.category = category;
			this.questions = questions;
		}

		public Quiz() {
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
		Quiz quiz = (Quiz) o;
		return getqId() != null && Objects.equals(getqId(), quiz.getqId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
	}
}
