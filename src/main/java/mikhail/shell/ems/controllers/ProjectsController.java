package mikhail.shell.ems.controllers;

import java.util.List;
import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import mikhail.shell.ems.models.AbstractTask;
import org.springframework.beans.factory.annotation.Qualifier;

@Controller
@RequestMapping("/projects")
public class ProjectsController extends AbstractController{
    
    public ProjectsController(ProjectDAO pDAO,  
            TaskListDAO tlDAO, ATaskDAO aDAO) 
    {
        super(pDAO, tlDAO, aDAO);
    }
    
    public String viewAll(Model model)
    {
        List<AbstractTask> p = pDAO.getAll();
        model.addAttribute("projects", p);
        return "/projects/index";
    }
    
    @Override
    public String view(Model model, @PathVariable("id") long id)
    {
        model.addAttribute("project", (Project)pDAO.getOne(id));
        return "/projects/project";
    }
    @Override
    public String startCreation(Model model)
    {
        model.addAttribute("project", new Project());
        return "/projects/create";
    }
    @Override
    public String endCreation(@ModelAttribute("project")
            AbstractTask project)
    {
        pDAO.create(project);
        return "redirect:/projects";
    }
    public String startEdit(Model model, 
            @PathVariable("id") long id)
    {
        model.addAttribute("project", (Project) pDAO.getOne(id));
        return "/projects/edit";
    }
    @Override
    public String endEdit(@ModelAttribute("project")AbstractTask project)
    {
        pDAO.edit(project);
        return "redirect:/projects";
    }
    @Override
    public String remove(@PathVariable("id")long id)
    {
        pDAO.remove(id);
        return "redirect:/projects";
    }

}
