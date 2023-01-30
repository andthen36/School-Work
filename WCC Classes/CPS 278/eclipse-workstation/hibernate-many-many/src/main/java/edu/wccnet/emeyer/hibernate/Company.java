package edu.wccnet.emeyer.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "college_company", 
	joinColumns = @JoinColumn(name= "company_id"), inverseJoinColumns = @JoinColumn(name = "college_id"))
	private List<College> colleges = new ArrayList<College>();

	public void addCollege(College college) {
		colleges.add(college);
	}
	public void removeCollege(College college) {
		colleges.remove(college);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<College> getColleges() {
		return colleges;
	}


	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", colleges=" + colleges + "]";
	}


	public Company(String name) {
		super();
		this.name = name;
	}
	
	
}
