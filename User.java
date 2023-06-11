
public class User {
private String name;
 private String password;
 private Profession pr;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Profession getPr() {
	return pr;
}
public void setPr(Profession pr) {
	this.pr = pr;
}
public User(String name, String password, Profession pr) {
	super();
	this.name = name;
	this.password = password;
	this.pr = pr;
}


}
