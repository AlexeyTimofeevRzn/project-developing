package ru.timofeev.project_developing.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.timofeev.project_developing.model.EmployeeProjectRole;

import java.util.List;

@Repository
public interface EmployeeProjectRoleRepository extends JpaRepository<EmployeeProjectRole, Long> {

//    @Transactional
//    @Modifying
//    @Override
//    @Query(nativeQuery = true, value = """
//    INSERT INTO employee_project_role (role, employee_id, project_id)
//    VALUES (:#{#projectRole.role.name()}, :#{#projectRole.employee.id}, :#{#projectRole.project.id})
//    """)
//    Long save(@Param("projectRole") EmployeeProjectRole projectRole);

    List<EmployeeProjectRole> getEmployeeProjectRoleByEmployee_Id(Long employeeId);

    List<EmployeeProjectRole> getEmployeeProjectRoleByProject_Id(Long projectId);
}
