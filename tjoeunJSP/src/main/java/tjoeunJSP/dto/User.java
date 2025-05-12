package tjoeunJSP.dto;

import java.util.List;

public class User {
	String id;;
	String passwd;
	String name;
	String phone;
	String sex;
	List<String> hobby;
	String comment;

	public User() {
	}

	public User(String id, String passwd, String name, String phone, String sex, List<String> hobby, String comment) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.hobby = hobby;
		this.comment = comment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
