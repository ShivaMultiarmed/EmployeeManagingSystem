package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.AbstractTask;
import mikhail.shell.ems.models.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasklists")
public class TaskListController extends AbstractController<TaskList> {
    
    @Autowired
    public TaskListController(ProjectDAO pDAO, 
            TaskListDAO tlDAO, ATaskDAO aDAO) 
    {
        super(pDAO, tlDAO, aDAO);
    }

    @Override
    public String view(HttpServletRequest request,
            @PathVariable("id") long id) {
        TaskList taskList = tlDAO.getOne(id); 
        System.out.println(taskList.getTitle());
        System.out.println(taskList.getDescription());
        request.setAttribute("taskList",taskList);
        return "tasklists/list";
    }

    @Override
    public String startCreation(HttpServletRequest request) {
        TaskList taskList = new TaskList();
                //appContext.getBean("taskList",
                //TaskList.class);
        request.setAttribute("taskList", taskList);
        return "tasklists/create";
    }

    @Override 
    public String endCreation(@ModelAttribute("taskList") 
            TaskList taskList) {
        tlDAO.create(taskList);
        return "redirect: /tasklists/" + taskList.getId();
    }

    @Override
    public String startEdit(HttpServletRequest request, @PathVariable("id") long id) {
        AbstractTask taskList = tlDAO.getOne(id);
        request.setAttribute("taskList", taskList);
        return "/tasklists/edit";
    }

    @Override 
    public String endEdit(@ModelAttribute("taskList") 
            TaskList taskList) {
        tlDAO.edit(taskList);
        return "redirect: /tasklists/{id}";
    }

    @Override
    public String remove(@PathVariable("id") long id) {
        tlDAO.remove(id);
        return "redirect: /";
    }

}
