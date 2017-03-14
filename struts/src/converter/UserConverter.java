package converter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import domain.User;

public class UserConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] values, Class arg2) {
		// TODO Auto-generated method stub
		System.out.println("ÎÒÊÇUserConverterµÄconvertFormString()");
		Set<User> result = new HashSet<User>();
		for (int i = 0; i < values.length; i++) {
			User user = new User();
			String[] userValues = values[i].split(",");
			user.setName(userValues[0]);
			user.setPass(userValues[1]);
		}
		return result;
	}

	@Override
	public String convertToString(Map arg0, Object o) {
		// TODO Auto-generated method stub
		if (o.getClass() == Set.class) {
			Set<User> users = (Set) o;
			String result = "[";
			for (Object obj : users) {
				User user = (User) obj;
				result += "<" + user.getName() + "," + user.getPass() + ">";
			}
			return result + "]";
		} else {
			return "";
		}
	}
}
