package com.epam.training.javasecurity.mvc;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MessageForm {

    @NotEmpty(message = "Message is required.")
    private String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    @NotEmpty(message = "Email is required.")
    @Email
    private String toEmail;
	
    private Double priority;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }
}
