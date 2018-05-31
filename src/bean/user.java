package bean;

public class user {
private String username;
private String password;
private String address;
private String bankaccount;
private String card;
private int uid;
private double money;
public String getUsername() {
	return username;
}

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getBankaccount() {
	return bankaccount;
}
public void setBankaccount(String bankaccount) {
	this.bankaccount = bankaccount;
}
public String getCard() {
	return card;
}
public void setCard(String card) {
	this.card = card;
}

public double getMoney() {
	return money;
}

public void setMoney(double money) {
	this.money = money;
}


}
