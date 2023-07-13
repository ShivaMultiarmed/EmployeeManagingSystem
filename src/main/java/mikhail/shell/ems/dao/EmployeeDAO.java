package mikhail.shell.ems.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mikhail.shell.ems.controllers.AbstractController;
import mikhail.shell.ems.models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
    
    protected final SessionFactory sf;
    protected Session session;
    
    //@Autowired
    //@Qualifier("appSessionFactory")
    public EmployeeDAO(SessionFactory sf)
    {
        this.sf = sf;
        
    }
    public  List<Employee> getAll(){
        Session s = sf.openSession();
        s.get(Employee.class, (long)1);
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        Query query = s.createQuery(cq);
        
        List<Employee> employees = query.getResultList();
        for (Employee employee : employees)
            System.out.println(employee.getName());
        
        return employees;
    }
    public Employee getOne(int id){
        Session s = AbstractController.sf.getCurrentSession();
        String sql = "FROM Employee WHERE id = :id;";
        Query<Employee> query = s.createQuery(sql);
        Employee e = query.uniqueResult();
        return e;
    }
    public void create(Employee e){}
    public int edit(Employee e){
        Session s = AbstractController.sf.getCurrentSession();
        String sql = "UPDATE Employee SET";
        return 0;
    }
    public int remove(long id){
        Session s = AbstractController.sf.getCurrentSession();
        String sql = "DELETE FROM Employee WHERE id = :id;";
        Query query = s.createQuery(sql);
        int r = query.executeUpdate();
        return r;
    }
    
}
