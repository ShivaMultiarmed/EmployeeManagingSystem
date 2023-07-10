package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import mikhail.shell.ems.models.AbstractTask;


@Controller
@RequestMapping("/projects")
public class ProjectsController extends AbstractController<Project>{
    
    public ProjectsController(ProjectDAO pDAO,  
            TaskListDAO tlDAO, ATaskDAO tDAO) 
    {
        super(pDAO, tlDAO, tDAO);
    }
    
    @Override
    public String view(HttpServletRequest request
            , @PathVariable("id") long id)
    {
        request.setAttribute("project", (Project)pDAO.getOne(id));
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
    public String remove(@PathVariable("id")long id)
    {
        pDAO.remove(id);
        return "redirect:/projects/1";
    }

}
