package s;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

public class MyDecider implements Decider {

	@Override
	public boolean decide(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		String str = (String) arg0;
		return str.indexOf("ja") >= 0;
	}

}
