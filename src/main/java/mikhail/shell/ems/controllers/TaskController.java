package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.dao.TaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.ATask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@RequestMapping("/tasks")
public class TaskController extends AbstractController <ATask> {

    
    public TaskController(
            AnnotationConfigWebApplicationContext appContext,
            ProjectDAO pDAO, 
            TaskListDAO tlDAO, TaskDAO aDAO) 
    {
        super(appContext,pDAO, tlDAO, aDAO);
    }
    
    @Override
    public String view(HttpServletRequest request, 
            @PathVariable("id") int id) {
        ATask task = tDAO.getOne(id);
        System.out.println("CURRENT TASK: " + task.getTitle());
        request.setAttribute("task", task);
        return "tasks/task";
    } 

    @Override
    public String create(ATask task) {
        tDAO.create(task);
        return "redirect:/tasks/" + task.getId();
    }

    @Override
    public String edit(ATask task) {
        tDAO.edit(task);
        return "redirect:/tasks/" + task.getId();
    }

    @Override
    public String remove(int id) {
        tDAO.remove(id);
        return "redirect:/tasks/1";
    }
    
}
