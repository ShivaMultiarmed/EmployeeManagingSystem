package mikhail.shell.ems.dao;

import java.util.List;
import mikhail.shell.ems.models.Project;
import mikhail.shell.ems.models.TaskList;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ProjectDAO extends AbstractDAO<Project> {
    public ProjectDAO(JdbcTemplate jdbc)
    {
        super(jdbc);
    }
    @Override
    public List<Project> getAll(int userId)
    {
        return getJdbc().query("SELECT * FROM `projects`"
                + " WHERE assigneeid = ?;",
                new String[]{userId+""}
                ,new BeanPropertyRowMapper(Project.class));
    }
    @Override
    public Project getOne(int id) 
    {
        String sql = "SELECT * FROM `projects`"
                + " WHERE `id` = ?";
        List<Project> p = getJdbc().query(sql,
                new String[]{id+""}, 
                new BeanPropertyRowMapper(Project.class));
        if (p != null)
        return p.get(0);
            
        else 
            return null;
    }
    @Override
    public void create(Project project)
    {
        getJdbc().update("INSERT INTO `projects` ("
                + "`title`, `description`"
                + ") VALUES("
                + "?, ?"
                + ");", project.getTitle(), 
                project.getDescription());
    }
    @Override
    public void edit(Project project)
    {
        getJdbc().update("UPDATE `projects` "
                + "SET `title` = ?,"
                + "`description` = ?"
                + "WHERE `id` = ?", 
                project.getTitle(), 
                project.getDescription(),
                project.getId());
    }
    @Override
    public void remove(long id)
    {
        getJdbc().update("DELETE FROM `projects` WHERE `id`= ?", id);
    }
}
