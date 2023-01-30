package edu.wccnet.emeyer.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "college")
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "college_name")
	private String name;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	private List<Campus> campuses = new ArrayList<Campus>();
	
	public void add(Campus newCampus) {
		campuses.add(newCampus);
		newCampus.setCollege(this);
	}
	public void remove(Campus campus) {
		campuses.remove(campus);
		
	}
	
	public List<Campus> getCampuses() {
		return campuses;
	}

	public void setCampuses(List<Campus> campuses) {
		this.campuses = campuses;
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

	public College(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}
	
	public College() {
		
	}
	

}
