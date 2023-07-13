package mikhail.shell.ems.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;


@Entity
@Table(name = "departments")
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE)
    private short id;
    
    private String title; 
    private Employee manager;
    @Transient
    @Setter(AccessLevel.NONE)private final List<Employee> employees;
    @Transient
    @Setter(AccessLevel.NONE)private final List<Department> subDepartments;
    
    public Department(){
        employees = new ArrayList<Employee>();  
        subDepartments = new ArrayList<Department>();
    }
    public void setId(short id)
    {
        if (id !=0)
            this.id = id;
    }
    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }
    public Employee getEmployee(int id)
    {
        for (Employee emp : employees)
            if (emp.getId() == id)
                return emp;
        return null;
    }
    public Department getDepartment(short id)
    {
        for (Department dep : subDepartments)
            if (dep.getId() == id)
                return dep;
        return null;
    }
    public void addDepartment(Department department)
    {
        subDepartments.add(department);
    }
}
