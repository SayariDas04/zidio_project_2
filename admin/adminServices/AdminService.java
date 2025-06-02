package Admin.admin.adminServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Admin.admin.adminModel.*;
import Admin.admin.adminRepository.*;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminrepo;
    public void createAdmin(AdminModel admin) {
    	adminrepo.save(admin);
    }
    public AdminModel getById(int id) {
    	Optional<AdminModel> admins =adminrepo.findById(id);
    	if(!admins.isEmpty()) {
    		return admins.get();
    	}
    	else {
    		return null;
    	}
    }
    public List<AdminModel> getAll(){
    	return adminrepo.findAll();
    }
    public AdminModel updateById(AdminModel admin) {
    	adminrepo.save(admin);
    	AdminModel updated=this.getById(admin.getId());
    	return updated;
    }
    public AdminModel deleteById(int id) {
    	AdminModel deleted = this.getById(id);
    	adminrepo.deleteById(id);
    	return deleted;
    }
}
