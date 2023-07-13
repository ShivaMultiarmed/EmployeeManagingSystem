package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.dao.TaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.AbstractTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public abstract class AbstractController<T extends AbstractTask> {
    //AnnotationConfigWebApplicationContext
    protected final ApplicationContext appContext;
    //@Autowired
    //@Qualifier("appSessionFactory")
    public static SessionFactory sf;
    protected Session session;
    protected final ProjectDAO pDAO;
    protected final TaskListDAO tlDAO;
    protected final TaskDAO tDAO;
    @Autowired
    public AbstractController(
            ApplicationContext appContext,
            ProjectDAO pDAO, 
            TaskListDAO tlDAO, TaskDAO tDAO)
    {
        this.appContext = appContext;
        this.pDAO = pDAO;
        this.tlDAO = tlDAO;
        this.tDAO = tDAO;
        
        //sf = appContext.getBean("appSessionFactory", SessionFactory.class);
        //System.out.println(appContext.hashCode());
    }
    @GetMapping("/{id}")
    public abstract String view(HttpServletRequest request,
            @PathVariable("id") int id);
    @PostMapping("/create")
    public abstract String create(T absTask);
    @PatchMapping("/{id}/edit")
    public abstract String edit(T absTask);
    @DeleteMapping("/{id}/remove")
    public abstract String remove(int id);
}
