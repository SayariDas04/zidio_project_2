package Admin.admin.adminModel;

import jakarta.persistence.*;

@Entity
@Table(name="Admins")
public class AdminModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name",length=40,nullable=false)
	private String name;
	
	@Column(name="ContactNo")
	private double contactNo;
	
	@Column(name="Email",nullable=false)
	private String email;
	
	//Constructors
	public AdminModel() {
		this.id=0;
		this.name=null;
		this.contactNo=0;
		this.email=null;
	}
	
	public AdminModel(String name,double contactNo,String email) {
		super();
		this.name=name;
		this.contactNo=contactNo;
		this.email=email;
	}
	
	
	//Getters
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public double getContactNo() {
		return this.contactNo;
	}
	public String getEmail() {
		return this.email;
	}
	
	
	//Setters
	public void setName(String name) {
		this.name=name;
	}
	public void setContactNo(double contactNo) {
		this.contactNo=contactNo;
	}
	public void setPrice(String email) {
		this.email=email;
	}
	
	
	//ToString method
	public String toString() {
		return "Admin:- \nId: "+this.id+"\nName: "+this.name+"\nContactNo: "+this.contactNo+"\nEmail: "+this.email;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

