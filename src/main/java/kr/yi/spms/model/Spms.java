package kr.yi.spms.model;

import java.util.Date;

public class Spms {
	int sp_no;
	String sp_name;
	String content;
	Date startdate;
	Date enddate;
	String status;

	
	public Spms() {
		super();
	}


	public Spms(int sp_no) {
		super();
		this.sp_no = sp_no;
	}


	public Spms(int sp_no, String sp_name, String content, Date startdate, Date enddate, String status) {
		super();
		this.sp_no = sp_no;
		this.sp_name = sp_name;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
	}


	public int getSp_no() {
		return sp_no;
	}


	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
	}


	public String getSp_name() {
		return sp_name;
	}


	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "spms [sp_no=" + sp_no + ", sp_name=" + sp_name + ", content=" + content + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", status=" + status + "]";
	}
	
	

}
