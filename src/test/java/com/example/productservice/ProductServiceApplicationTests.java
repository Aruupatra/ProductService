package com.example.productservice;

import com.example.productservice.dtos.ProductDto;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepositories;
import com.example.productservice.repositories.ProductRepositories;
import com.example.productservice.services.CategoryService;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value=false)
class ProductServiceApplicationTests {


//	@Autowired
//    private ProductService selfProductService;
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private ProductRepositories productRepositories;
//	@Autowired
//	private CategoryRepositories categoryRepositories;
////	@Autowired
////	private JTUserRespository jtUserRespository;
////	@Autowired
////	private JTMentorRepository jtMentorRepository;
////	@Autowired
////	private SingleUserRespository singleUserRepository;
////	@Autowired
////	private SingleMentorRepository singleMentorRepository;
////
////	@Autowired
////	private TableUserRespository tableUserRespository;
////	@Autowired
////	private TableMentorRepository tableMentorRepository;
////
////
////	//private MappedUserRespository mappedUserRespository;
////	@Autowired
////	private MappedMentorRepository mappedMentorRepository;
//
//
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void testRepo()
//	{
////      User user=new User();
////	  user.setName("Arun");
////	  user.setEmail("parun1331@gmail.com");
//	//  jtUserRespository.save(user);
//		//mappedUserRespository.save(user);
//	//	singleUserRepository.save(user);
////		Mentor mentor=new Mentor();
////		mentor.setName("John");
////		mentor.setEmail("john@123");
////		mentor.setNo_of_sessions(30);
////		mappedMentorRepository.save(mentor);
////		jtMentorRepository.save(mentor);
////		singleMentorRepository.save(mentor);
////
////
////
////		tableUserRespository.save(user);
////		tableMentorRepository.save(mentor);
//
//
//
//
//
//
//
//	}
//
//	@Test
//	void testForFetchType()
//	{
//		Category category=new Category();
//		category.setName("Dress");
//		category.setDescription("any tshirts");
//		Category saveCategory=categoryRepositories.save(category);
//
//		Product product=new Product();
//		product.setTitle("pant");
//		product.setPrice(1000.0);;
//		product.setCategory(saveCategory);
//		productRepositories.save(product);
//
//
//
//	}
//
//	@Test
//	void fetchProduct()
//	{
//		Optional<Product> product=productRepositories.findById(3l);
//	}
//
//	@Test
//	void testSomething()
//	{
//
//
//		Category category1=new Category();
//		category1.setName("Jeans");
//		category1.setDescription("Buy 1 Get 1");
//		category1.setDescription("Lower Items");
//      //  categoryRepositories.save(category1);
//
//		Product product1=new Product();
//		product1.setPrice(100.5);
//		product1.setTitle("Watch");
//		product1.setImage("http:/bsffjgsr.com");
//		product1.setCategory(category1);
//
//		productRepositories.save(product1);
//	}
//
//	@Test
//	void getProductsFromCategory()
//	{
////		Optional<Category> OptionalCategory=categoryRepositories.findById(1L);
////		Category category=OptionalCategory.get();
////		for(Product product:category.getProducts())
////		{
////			 System.out.println(product.getPrice());
////		}
//
//		List<Category> categories=categoryRepositories.findAllByIdIn(List.of(1L,2L));
//
//		for(Category category:categories)
//		{
//			for(Product product:category.getProducts())
//			{
//				System.out.println(product.getPrice());
//			}
//
//		}
//	}
//
////	@Test
////	void testForUpdateSelfProductService()
////	{
////             Product product=new Product();
////			 product.setPrice(20.0);
////		productRepositories.updateByIdIn(4L,product);
////	}
//
//	@Test
//	void testForProductByCategoryNameAndCategoryId()
//	{
//
//		List<Product> products=productRepositories.findProductByCategory_NameAndCategoryId("Dress",1L);
//
//		for(Product product:products)
//		{
//			System.out.println(product.getPrice());
//		}
//	}
//
//	@Test
//	void testForCustomQuery()
//	{
////		List<Product> products=productRepositories.laoProductById(2l);
////		for(Product product:products)
////		{
////			System.out.println(product.getPrice());
////		}
//
//		//test for JPA Queries
//
//		List<Product> products=productRepositories.getProductsByProductIdandCategoryName(1L,"Dress");
//
//		for(Product product:products)
//		{
//			System.out.println(product.getPrice());
//		}
//	}
//
//	@Test
//	void testSelfProductService()
//	{
//        ProductDto productDto=new ProductDto();
//		productDto.setTitle("Pinkina Hagi dela");
//		productDto.setCategory("Mama weds Pinku");
//
//		Product product=new Product();
//		product.setId(20L);
//		product.setPrice(2000.0);
//
////		selfProductService.addNewProduct(productDto);
//
////		Product product=new Product();
////		product.setTitle("Hi Arun");
////		productRepositories.save(product);
//		//selfProductService.deleteProduct(20L);
//	}
//
//	@Test
//	void testFindProductById()
//	{
//		Optional<Product> product=productRepositories.findById(1L);
//		System.out.println(product.get().getPrice());
//
//	}
//
//	@Test
//	void testFindProductByCategoryName()
//	{
//		List<Product> products=categoryService.getProductsInCategory("Dress");
//
//		for(Product p:products)
//		{
//			System.out.println(p.getPrice());
//		}
//
//	}
//

}
