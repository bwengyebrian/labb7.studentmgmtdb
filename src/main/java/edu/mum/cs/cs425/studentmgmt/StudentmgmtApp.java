package edu.mum.cs.cs425.studentmgmt;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentmgmtApp implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TranscriptRepository transcriptREpository;
	
	@Autowired
	private ClassroomRepository classroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student s = new Student("000-61-0001","Anna", "Lynn","Smith",3.45, LocalDate.of(2019, 5, 24),new Transcript("BS Computer Science"));
		Classroom c = new Classroom("McLaughlin building", "M105");
		c.getStudents().add(s);
		System.out.print(saveClassroom(c));
		
	}
	
	public Student saveStudent(Student s) {
		transcriptREpository.save(s.getTranscript());
		return studentRepository.save(s);
	}
	
	public Classroom saveClassroom(Classroom c) {
		
//        for(Student s : c.getStudents()) {
//        	saveStudent(s);
//        }
		return classroomRepository.save(c);
	}

}
