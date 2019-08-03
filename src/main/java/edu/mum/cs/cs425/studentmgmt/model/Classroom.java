package edu.mum.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "classrooms" )
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;
	
	private String buildingName;
	private String roomNumber;
	

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<>();
	
	public Classroom() {
		
	}

	public Classroom(Long classroomId, String buildingName, String roomNumber, List<Student> students) {
		super();
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.students = students;
	}
	
	public Classroom(String buildingName, String roomNumber, List<Student> students) {
		super();

		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.students = students;
	}
	
	public Classroom(String buildingName, String roomNumber) {
		super();

		this.buildingName = buildingName;
		this.roomNumber = roomNumber;

	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
				+ ", students=" + students + "]";
	}
	
	
	
	
	
	

}
