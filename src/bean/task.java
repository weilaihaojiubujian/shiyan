package bean;

import java.util.Date;
import java.util.List;

public class task {

   private String taskname;
   private String introduce;
   private int tid;
   private double price;
   private Date date;
   private int accept;

   private double progress;
public String getTaskname() {
	return taskname;
}
public void setTaskname(String taskname) {
	this.taskname = taskname;
}
public String getIntroduce() {
	return introduce;
}
public void setIntroduce(String introduce) {
	this.introduce = introduce;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getAccept() {
	return accept;
}
public void setAccept(int accept) {
	this.accept = accept;
}

public double getProgress() {
	return progress;
}
public void setProgress(double progress) {
	this.progress = progress;
}
   
}
