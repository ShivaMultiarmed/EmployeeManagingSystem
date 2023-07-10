package mikhail.shell.ems.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Department {

    @Getter private short id;
    @Getter @Setter private String title; 
    @Getter @Setter private Employee manager;
    @Getter private final List<Employee> employees;
    @Getter private final List<Department> subDepartments;
    
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
