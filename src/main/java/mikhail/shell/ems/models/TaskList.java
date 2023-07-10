package mikhail.shell.ems.models;

public class TaskList extends AbstractTask<ATask> {
    public TaskList() {}
    public TaskList(long id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
