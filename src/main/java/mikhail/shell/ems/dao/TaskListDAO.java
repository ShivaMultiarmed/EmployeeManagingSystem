package mikhail.shell.ems.dao;

import java.util.ArrayList;
import java.util.List;
import mikhail.shell.ems.models.AbstractTask;
import mikhail.shell.ems.models.TaskList;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TaskListDAO extends AbstractDAO<TaskList> {
    private final List<TaskList> taskLists = new ArrayList<TaskList>();
    
    {
        for (int i = 0; i< 5; i++)
            taskLists.add(new TaskList(taskLists.size(), "Some list " + taskLists.size()));
    }
    public TaskListDAO(JdbcTemplate jdbc)
    {
        super(jdbc);
    }

    @Override
    public List<TaskList> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaskList getOne(long id) {
        List<TaskList> tls = getJdbc().query("SELECT * FROM `tasklists` "
                + "WHERE `id` = ?;", new String[] {id+""},
                new BeanPropertyRowMapper(TaskList.class));
        if (tls.isEmpty())
            return null;
        else
            return tls.get(0);
    }

    @Override
    public void create(TaskList taskList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(TaskList taskList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(long l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
