package mikhail.shell.ems.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class AbstractTask {
    @Getter protected long id;
    @Getter @Setter protected String title, description;
    @Getter @Setter protected Date start, finish;
    @Getter @Setter protected Employee assignee;
    @Getter protected List<AbstractTask> insides;
    @Getter @Setter protected Progress progress;
    public AbstractTask() {
        insides = new ArrayList<AbstractTask>();
        progress = Progress.TODO;
    }
    public void setId(long id)
    {   
        if (id != 0)
            this.id = id;
    }
    public void addInside(AbstractTask inside)
    {
        insides.add(inside);
    }
}
