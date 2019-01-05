package com.ecomm.backend;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.config.DBConfig;
import com.ecomm.model.Category;

public class CategoryMain {
	public void categoryOut()
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category=new Category();
	    Scanner sc = new Scanner(System.in);
			
			System.out.println("Please choose an option to do the manipulation");
			System.out.println("1.Add Categories /n 2.Delete Categories /n 3.Update Categories /n 4.View All Categories /n 5.View Categories by ID /n 6.View Categories by Name");
			
			int choice = sc.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Please enter the category details to enter");
				System.out.println("Category ID:");

				category.setCategoryId(sc.nextInt());
				
				System.out.println("Category Name:");

				category.setCategoryName(sc.next());
				
				boolean result1 = categoryDAO.addCategory(category);
				if(result1 == true)
				{
					System.out.println("Details has been added successfully");
				}
				break;
			case 2:
				
				List<Category> categoryList1 = categoryDAO.findAllCategories();
				for(Category category1 : categoryList1)
				{
					System.out.print("| Id:"+category1.getCategoryId()+"|");
					System.out.print("Name:"+category1.getCategoryName()+"|");
				

				}
				System.out.println("Please enter the category id to be deleted from the above table");
				int CategoryId = sc.nextInt();
				boolean result = categoryDAO.deleteCategory(CategoryId);
				if(result == true)
				{
					System.out.println("The row has been successfuly deleted");
				}
				break;
			case 3:
				List<Category> categoryList2 = categoryDAO.findAllCategories();
				for(Category category2 : categoryList2)
				{
					System.out.print("| Id:"+category2.getCategoryId()+"|");
					System.out.print("Name:"+category2.getCategoryName()+"|");
				}
				System.out.println("Please enter the category id");
				category.setCategoryId(sc.nextInt());
				System.out.println("Please enter the category details for updation");
				
				System.out.println("Category Name:");

				category.setCategoryName(sc.next());
				
				boolean result2 = categoryDAO.updateCategory(category);
				if(result2 == true)
				{
					System.out.println("Details has been updated successfully");
				}
				break;
				
			case 4:
				List<Category> categoryList = categoryDAO.findAllCategories();
				for(Category category3 : categoryList)
				{
					System.out.print("| Id:"+category3.getCategoryId()+"|");
					System.out.print("Name:"+category3.getCategoryName()+"|");
				}
				break;
				
			case 5:
				System.out.println("Please enter the category id to view category details");
				int categoryId3 = sc.nextInt();
				Category category4 = categoryDAO.findCategoryById(categoryId3);
				System.out.print("| Id:"+category4.getCategoryId()+"|");
				System.out.print("Name:"+category4.getCategoryName()+"|");

				break;
			case 6:
				System.out.println("Please enter the category name to view category details");
				String CategoryName = sc.next();
				Category category5 = categoryDAO.findCategoryByName(CategoryName);
				System.out.print("| Id:"+category5.getCategoryId()+"|");
				System.out.print("Name:"+category5.getCategoryName()+"|");

				break;
				
		 default: System.out.println("Please enter a valid input");
				
			}
			
			
			
			context.close();
			sc.close();


}
}