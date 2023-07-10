package mikhail.shell.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import mikhail.shell.ems.config.AppConfig;
import mikhail.shell.ems.dao.ATaskDAO;
import mikhail.shell.ems.dao.ProjectDAO;
import mikhail.shell.ems.dao.TaskListDAO;
import mikhail.shell.ems.models.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public abstract class AbstractController<T extends AbstractTask> {
    protected AnnotationConfigApplicationContext appContext;
    protected final ProjectDAO pDAO;
    protected final TaskListDAO tlDAO;
    protected final ATaskDAO tDAO;
    @Autowired
    public AbstractController(
            ProjectDAO pDAO, 
            TaskListDAO tlDAO, ATaskDAO tDAO)
    {
        //appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.pDAO = pDAO;
        this.tlDAO = tlDAO;
        this.tDAO = tDAO;
    }
    @GetMapping("/{id}")
    public abstract String view(HttpServletRequest request,
            @PathVariable("id") long id);
    @GetMapping("/create")
    public abstract String startCreation(HttpServletRequest request);
    @PostMapping("/create")
    public abstract String endCreation(T absTask);
    @GetMapping("/{id}/edit")
    public abstract String startEdit(HttpServletRequest request, long id);
    @PatchMapping("/{id}/edit")
    public abstract String endEdit(T absTask);
    @DeleteMapping("/{id}/remove")
    public abstract String remove(long id);
}
