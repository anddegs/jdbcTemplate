package chrisanabo.jdbctemplate.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chrisanabo.jdbctemplate.service.impl.AlertServiceImpl;

public class Main 
{
  public static void main( String[] args ) {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("alertMessage.xml");
    AlertServiceImpl alertServiceImpl = (AlertServiceImpl) ctx.getBean("alertServiceImpl");
   
//    User user = new User();
//    user.setUsername("johndoe");
//    user.setName("John Doe");
//   
//    userManager.insertUser(user);
//   
//    System.out.println("User inserted!");
//   
//    user = userManager.getUser("johndoe");
//   
//    System.out.println("\nUser fetched!"
//    + "\nId: " + user.getId()
//    + "\nUsername: " + user.getUsername()
//    + "\nName: " + user.getName());
//   
//    List<User> users = userManager.getUsers();
//   
//    System.out.println("\nUser list fetched!"
//     + "\nUser count: " + users.size());

  }
}

