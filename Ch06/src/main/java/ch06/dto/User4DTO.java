package ch06.dto;

public class User4DTO {

	private String name;
	private String gender;
	private String age;
	private String addr;
	private String seq;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "User4DTO [name=" + name + ", gender=" + gender + ", age=" + age + ", addr=" + addr + ", seq=" + seq
				+ "]";
	}
	
	
}
