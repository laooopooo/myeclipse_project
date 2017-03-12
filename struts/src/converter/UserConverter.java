package converter;

import java.util.Map;

import ognl.DefaultTypeConverter;
import domain.User;

public class UserConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		// TODO Auto-generated method stub
		if (toType == User.class) {
			String[] params = (String[]) value;
			User user = new User();
			String[] userValue = params[0].split(",");
			user.setName(userValue[0]);
			user.setPass(userValue[1]);

			return user;
		} else if (toType == String.class) {
			User user = (User) value;
			return "<" + user.getName() + "," + user.getPass() + ">";
		}
		return null;
	}
}
