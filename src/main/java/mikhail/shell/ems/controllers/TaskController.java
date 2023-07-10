package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.ATask;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("tasks")
public class TaskController extends AbstractController <ATask> {

    public TaskController(ProjectDAO pDAO,  
            TaskListDAO tlDAO, ATaskDAO aDAO) 
    {
        super(pDAO, tlDAO, aDAO);
    }
    
    @Override
    public String view(HttpServletRequest request, long id) {
        ATask task = tDAO.getOne(id);
        request.setAttribute("task", task);
        return "tasks/task";
    } 

    @Override
    public String startCreation(HttpServletRequest request) {
        ATask emptyTask = new ATask();
        request.setAttribute("task", emptyTask);
        return "tasks/create";
    }

    @Override
    public String endCreation(ATask task) {
        tDAO.create(task);
        return "redirect:/tasks/" + task.getId();
    }

    @Override
    public String startEdit(HttpServletRequest request, long id) {
        ATask task =  (ATask)tDAO.getOne(id);
        request.setAttribute("task", task);
        return "/tasks/edit";
    }

    @Override
    public String endEdit(ATask task) {
        tDAO.edit(task);
        return "redirect:/tasks/" + task.getId();
    }

    @Override
    public String remove(long id) {
        tDAO.remove(id);
        return "redirect:/tasks/1";
    }
    
}
