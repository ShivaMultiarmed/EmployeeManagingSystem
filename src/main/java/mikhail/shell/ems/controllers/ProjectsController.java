package mikhail.shell.ems.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import mikhail.shell.ems.dao.TaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.ATask;
import mikhail.shell.ems.models.Project;
import mikhail.shell.ems.models.TaskList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


@Controller
@RequestMapping("/projects")
public class ProjectsController extends AbstractController<Project>{
    
    @Autowired
    public ProjectsController(
            ApplicationContext appContext,
            ProjectDAO pDAO,  
            TaskListDAO tlDAO, TaskDAO aDAO)
    {
        super(appContext,pDAO, tlDAO, aDAO);
    }
    
    
    @Override
    public String view(HttpServletRequest request
            , @PathVariable("id") int id)
    {
        Project p = pDAO.getOne(id);
        List<TaskList> lists  = tlDAO.getAll(id);
        List<ATask> tasks = null;
        for (TaskList list : lists)
        {
            p.addInside(list);
            tasks = tDAO.getAll(list.getId());
            
            for (ATask task : tasks)
            {    list.addInside(task);
            }
        }
        request.setAttribute("project", p);
        return "/projects/project"; 
    }
    /*@Override
    public String startCreation(HttpServletRequest request)
    {
        Project p = new Project();
        List<Project> ps = pDAO.getAll();
                    //appContext.getBean("project", Project.class);
        request.setAttribute("project", p);
        request.setAttribute("projects", ps);
        return "/projects/create";
    }*/
    @Override
    public String create(@ModelAttribute("project")
            Project project)
    {
        pDAO.create(project);
        return "redirect:/projects/"+project.getId();
    }
    @Override
    public String edit(@ModelAttribute("project")Project project)
    {
        pDAO.edit(project);
        return "redirect:/projects";
    }
    @Override
    public String remove(@PathVariable("id")int id)
    {
        pDAO.remove(id);
        return "redirect:/projects/1";
    }

}
