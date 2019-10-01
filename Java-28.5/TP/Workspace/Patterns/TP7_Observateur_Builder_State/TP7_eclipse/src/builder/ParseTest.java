package builder;

import java.util.ArrayList;

public class ParseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmailListConverter emailBuilder = new EmailListConverter();
		DocReader reader = new DocReader(emailBuilder, "projects.xml");
		reader.build();
		ArrayList<String> emailList = emailBuilder.getEmailList();
		System.out.println("------- Email list ---------");
		for (String email : emailList) {
			System.out.println(email);
		}
		SupervisorConverter supervisorConverter = new SupervisorConverter();
		reader = new DocReader(supervisorConverter, "projects.xml");
		reader.build();
		ArrayList<String> supervisorList = supervisorConverter.getSupervisors();
		System.out.println("--------- Supervisor list ---------");
		for (String supervisor : supervisorList) {
			System.out.println(supervisor);
		}
		
		
	}

}
