package mikhail.shell.ems.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component; 

@Component 
@Scope("prototype")
public class Project extends AbstractTask<TaskList> {
    public Project(){}
}
