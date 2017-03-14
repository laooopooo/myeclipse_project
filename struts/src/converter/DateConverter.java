package converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] values, Class arg2) {
		// TODO Auto-generated method stub
		System.out.println("ÎÒÊÇDateConverterµÄconvertFormString£¨£©");
		Date date = new Date();
		String dateValue = values[0];
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sf.parse(dateValue);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return date;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
