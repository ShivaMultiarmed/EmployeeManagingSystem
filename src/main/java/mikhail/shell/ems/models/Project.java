package mikhail.shell.ems.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class Project extends AbstractTask {
    public Project(){}
    public Project(long id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
