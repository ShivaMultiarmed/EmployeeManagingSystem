package mikhail.shell.ems.dao;

import java.util.List;
import mikhail.shell.ems.models.TaskList;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TaskListDAO extends AbstractDAO<TaskList> {
   
    public TaskListDAO(JdbcTemplate jdbc)
    {
        super(jdbc);
    }

    
    @Override
    public List<TaskList> getAll(int projId)
    {
        String sql = "SELECT * FROM `tasklists`"
                + "WHERE `projectid` = ?;";
        List<TaskList> tls = getJdbc().query(sql, new String[]{projId+""},
                new BeanPropertyRowMapper(TaskList.class));
        return tls;
    }

    @Override
    public TaskList getOne(int id) {
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
