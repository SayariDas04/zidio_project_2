package Admin.admin.adminRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Admin.admin.adminModel.*;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
}
