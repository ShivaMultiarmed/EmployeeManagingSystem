package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.dao.TaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Controller
@RequestMapping("/tasklists")
public class TaskListController extends AbstractController<TaskList> {
    
    public TaskListController(
            ApplicationContext appContext,
            ProjectDAO pDAO, 
            TaskListDAO tlDAO, TaskDAO aDAO) 
    {
        super(appContext,pDAO, tlDAO, aDAO);
    }

    @Override
    public String view(HttpServletRequest request,
            @PathVariable("id") int id) {
        TaskList list = tlDAO.getOne(id); 
        request.setAttribute("list",list);
        return "tasklists/list";
    }

    @Override 
    public String create(@ModelAttribute("taskList") 
            TaskList taskList) {
        tlDAO.create(taskList);
        return "redirect: /tasklists/" + taskList.getId();
    }

    @Override 
    public String edit(@ModelAttribute("taskList") 
            TaskList taskList) {
        tlDAO.edit(taskList);
        return "redirect: /tasklists/{id}";
    }

    @Override
    public String remove(@PathVariable("id") int id) {
        tlDAO.remove(id);
        return "redirect: /";
    }

}
