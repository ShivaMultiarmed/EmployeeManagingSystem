package mikhail.shell.ems.controllers;

import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.AbstractTask;
import mikhail.shell.ems.models.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taskLists")
public class TaskListController extends AbstractController {
    
    @Autowired
    public TaskListController(ProjectDAO pDAO, 
            TaskListDAO tlDAO, ATaskDAO aDAO) 
    {
        super(pDAO, tlDAO, aDAO);
    }

    public String view(Model model,  @PathVariable("id") long id) {
        AbstractTask taskList = tlDAO.getOne(id);
        model.addAttribute("taskList",taskList);
        return "taskLists/list";
    }

    @Override
    public String viewAll(Model model) {
        return null;
    }

    @Override
    public String startCreation(Model model) {
        AbstractTask taskList = new TaskList();
        model.addAttribute("taskList", taskList);
        return "taskLists/create";
    }

    @Override
    public String endCreation(@ModelAttribute("taskList")
            AbstractTask taskList) {
        return "redirect: /taskLists/{id}";
    }

    @Override
    public String startEdit(Model model, @PathVariable("id") long id) {
        AbstractTask taskList = tlDAO.getOne(id);
        model.addAttribute("taskList", taskList);
        return "/taskLists/edit";
    }

    @Override
    public String endEdit(@ModelAttribute("taskList")
            AbstractTask taskList) {
        tlDAO.edit(taskList);
        return "redirect: /tasklists/{id}";
    }

    @Override
    public String remove(@PathVariable("id") long id) {
        tlDAO.remove(id);
        return "redirect";
    }
}
