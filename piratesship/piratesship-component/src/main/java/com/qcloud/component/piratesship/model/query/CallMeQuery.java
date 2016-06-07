package com.qcloud.component.piratesship.model.query;

public class CallMeQuery {

    private String project;

    private String fromSeaman;

    private String toSeaman;

    private String receiveSeaman;

    private String subject;

    public CallMeQuery() {

    }

    public String getProject() {

        return project;
    }

    public void setProject(String project) {

        this.project = project;
    }

    public String getFromSeaman() {

        return fromSeaman;
    }

    public void setFromSeaman(String fromSeaman) {

        this.fromSeaman = fromSeaman;
    }

    public String getToSeaman() {

        return toSeaman;
    }

    public void setToSeaman(String toSeaman) {

        this.toSeaman = toSeaman;
    }

    public String getReceiveSeaman() {

        return receiveSeaman;
    }

    public void setReceiveSeaman(String receiveSeaman) {

        this.receiveSeaman = receiveSeaman;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }
}
