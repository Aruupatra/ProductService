package com.example.productservice;

import com.example.productservice.inheritanceExamples.SingleTable.SingleMentorRepository;
import com.example.productservice.inheritanceExamples.SingleTable.SingleUserRespository;
import com.example.productservice.inheritanceExamples.joinedTable.JTMentorRepository;
import com.example.productservice.inheritanceExamples.joinedTable.JTUserRespository;
import com.example.productservice.inheritanceExamples.joinedTable.Mentor;
import com.example.productservice.inheritanceExamples.joinedTable.User;
import com.example.productservice.inheritanceExamples.mappedSuperClass.MappedMentorRepository;
import com.example.productservice.inheritanceExamples.tablePerClass.TableMentorRepository;
import com.example.productservice.inheritanceExamples.tablePerClass.TableUserRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {


	@Autowired
	private JTUserRespository jtUserRespository;
	@Autowired
	private JTMentorRepository jtMentorRepository;
	@Autowired
	private SingleUserRespository singleUserRepository;
	@Autowired
	private SingleMentorRepository singleMentorRepository;

	@Autowired
	private TableUserRespository tableUserRespository;
	@Autowired
	private TableMentorRepository tableMentorRepository;


	//private MappedUserRespository mappedUserRespository;
	@Autowired
	private MappedMentorRepository mappedMentorRepository;



	@Test
	void contextLoads() {
	}

	@Test
	void testRepo()
	{
//      User user=new User();
//	  user.setName("Arun");
//	  user.setEmail("parun1331@gmail.com");
	//  jtUserRespository.save(user);
		//mappedUserRespository.save(user);
	//	singleUserRepository.save(user);
		Mentor mentor=new Mentor();
		mentor.setName("John");
		mentor.setEmail("john@123");
		mentor.setNo_of_sessions(30);
		mappedMentorRepository.save(mentor);
//		jtMentorRepository.save(mentor);
//		singleMentorRepository.save(mentor);
//
//
//
//		tableUserRespository.save(user);
//		tableMentorRepository.save(mentor);







	}

}
