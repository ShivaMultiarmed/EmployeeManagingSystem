package mikhail.shell.ems.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class AbstractTask<T extends AbstractTask>
        implements Serializable {
    @Getter protected int id;
    @Getter @Setter protected String title, description;
    @Getter @Setter protected Date start, finish;
    @Getter @Setter protected Employee assignee;
    @Getter protected List<T> insides;
    @Getter @Setter protected Progress progress;
    public AbstractTask() {
        insides = new ArrayList<T>();
        progress = Progress.TODO;
    }
    public void setId(int id)
    {   
        if (id != 0)
            this.id = id; 
    }
    public void addInside(T inside)
    {
        insides.add(inside);
    }
}
