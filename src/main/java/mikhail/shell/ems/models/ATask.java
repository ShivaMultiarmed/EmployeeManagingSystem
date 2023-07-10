package mikhail.shell.ems.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public final class ATask extends AbstractTask<ATask> { 
    @Getter private List<Long> attachments;
    @Getter private boolean isSubTask;
    public ATask(boolean isSubTask){
        setIsSubTask(isSubTask);
    }
    public ATask(boolean isSubTask, long id, String title)
    {
        this(isSubTask);
        this.id = id;
        setTitle(title);
    }

    public ATask() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void setIsSubTask(boolean is)
    {
        if (is && insides!=null)
            insides = null;
        else if (!is && insides == null)
            insides = new ArrayList<ATask>();
    }
}
