package mikhail.shell.ems.controllers;

import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public abstract class AbstractController {
    protected final ProjectDAO pDAO;
    protected final TaskListDAO tlDAO;
    protected final ATaskDAO aDAO;
    @Autowired
    public AbstractController(ProjectDAO pDAO, 
            TaskListDAO tlDAO, ATaskDAO aDAO)
    {
        this.pDAO = pDAO;
        this.tlDAO = tlDAO;
        this.aDAO = aDAO;
    }
    @GetMapping("/{id}")
    public abstract String view(Model model, @PathVariable("id") long id);
    @GetMapping()
    public abstract String viewAll(Model model);
    @GetMapping("/create")
    public abstract String startCreation(Model model);
    @PostMapping("/create")
    public abstract String endCreation(AbstractTask absTask);
    @GetMapping("/{id}/edit")
    public abstract String startEdit(Model model, long id);
    @PatchMapping("/{id}/edit")
    public abstract String endEdit(AbstractTask absTask);
    @DeleteMapping("/{id}/remove")
    public abstract String remove(long id);
}
