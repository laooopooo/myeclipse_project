package s;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport {
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String execute() throws Exception {
		return "done";
	}

	public String login() throws Exception {
		ActionContext.getContext().put("author", getAuthor());
		return "done";
	}
}
