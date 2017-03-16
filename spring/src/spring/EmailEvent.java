package spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
	private String address;
	private Properties
	private String text;

	public EmailEvent(Object source) {
		super(source);
	}

	public EmailEvent(Object source, String address, String text) {
		super(source);
		this.address = address;
		this.text = text;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
