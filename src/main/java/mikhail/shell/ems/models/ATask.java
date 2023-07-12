package mikhail.shell.ems.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public final class ATask extends AbstractTask<ATask> { 
    @Getter private List<Long> attachments;
    @Getter @Setter private int supertaskid, tasklistid;
    public ATask() {}
    public ATask(int id, int superTaskId, String title)
    {
        this.id = id;
        setSuperTaskId(superTaskId);
        setTitle(title);
    }

    public void setSuperTaskId(int id)
    {
        if (id >0 && insides!=null)
            insides = null;
        else if (id==0 && insides == null)
            insides = new ArrayList<ATask>();
        this.supertaskid = id;
    }
}
