package mikhail.shell.ems.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component; 

@Component 
@Scope("prototype")
public class Project extends AbstractTask<TaskList> {
    public Project(){}
    public Project(long id, String title)
    {
        System.out.println("PROJECT IN THE NEW DEPLOY");
        this.id = id;
        this.title = title;
    }
}
