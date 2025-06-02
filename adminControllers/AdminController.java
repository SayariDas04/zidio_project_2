package Admin.admin.adminControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Admin.admin.adminModel.*;
import Admin.admin.adminServices.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private AdminService adminservice;
	
	@Autowired
	public AdminController(AdminService adminservice) {
		this.adminservice=adminservice;
	}
	
	@PostMapping("/c")
	public ResponseEntity<AdminModel> create(@RequestBody AdminModel admin){
		try {
			adminservice.createAdmin(admin);
			return new ResponseEntity<>(adminservice.getById(admin.getId()),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping()
	public ResponseEntity<List<AdminModel>>  getAdmins(){
		try {
			return new ResponseEntity<>(adminservice.getAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<AdminModel> getAdminById(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(adminservice.getById(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/u")
	public ResponseEntity<AdminModel> updateAdmin(@RequestBody AdminModel admin){
		try {
			return new ResponseEntity<>(adminservice.updateById(admin),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/d/{id}")
	public ResponseEntity<AdminModel> deleteAdmin(@PathVariable("id") int id){
		try {
			return new ResponseEntity<>(adminservice.deleteById(id),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find")
	public ResponseEntity<List<AdminModel>> find(@RequestParam("name") String name){
		System.out.println(name);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
