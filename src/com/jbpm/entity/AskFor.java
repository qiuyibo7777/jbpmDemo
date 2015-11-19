package com.jbpm.entity;

import java.util.Date;

public class AskFor {
	private String applyName;
	private String applyPosition;
	private Date applyTime;
	private Integer applyDays;
	private String applyContent;
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyPosition() {
		return applyPosition;
	}
	public void setApplyPosition(String applyPosition) {
		this.applyPosition = applyPosition;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Integer getApplyDays() {
		return applyDays;
	}
	public void setApplyDays(Integer applyDays) {
		this.applyDays = applyDays;
	}
	public String getApplyContent() {
		return applyContent;
	}
	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

}
