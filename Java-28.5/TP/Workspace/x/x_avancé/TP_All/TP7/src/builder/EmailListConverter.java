package builder;

import java.util.ArrayList;

public class EmailListConverter extends AbstractConverter implements
		NodeConverter {

	ArrayList<String> emailList = new ArrayList<String>();

	public ArrayList<String> getEmailList() {
		return emailList;
	}

	@Override
	public void ReadEmail(String email) {
		emailList.add(email);
	}


}
