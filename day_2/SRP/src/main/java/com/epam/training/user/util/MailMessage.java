package com.epam.training.user.util;

public class MailMessage {

    private String from;
    private String to;
    private String text;
    private String subject;

    public static class Builder {
        private String from;
        private String to;
        private String text;
        private String subject;

        public Builder withFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder withTo(String to) {
            this.to = to;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailMessage build() {
            MailMessage message = new MailMessage();
            message.from = from;
            message.to = to;
            message.text = text;
            message.subject = subject;
            return message;
        }

    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "MailMessage [from=" + from + ", to=" + to + ", text=" + text + "]";
    }

}
