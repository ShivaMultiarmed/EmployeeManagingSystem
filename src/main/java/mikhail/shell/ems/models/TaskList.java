package mikhail.shell.ems.models;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

public class TaskList extends AbstractTask<TaskList> {
    public TaskList() {}
    public TaskList(long id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
