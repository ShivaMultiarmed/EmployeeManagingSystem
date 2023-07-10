<%@page import="mikhail.shell.ems.models.ATask"%>
<%@page import="mikhail.shell.ems.models.TaskList"%>
<%@page import="mikhail.shell.ems.models.AbstractTask"%>
<%
    TaskList list = (TaskList) request.getAttribute("list");
%>
<div class="list">
    <h1>${list.title}</h1>
    <p>${list.description}</p>
    <%
        if (!list.getInsides().isEmpty())
        {
            for(AbstractTask absTask : list.getInsides())
            {
                ATask task = (ATask) absTask;
                %>
                <li><%=task.getTitle()%></li>
                <%
            }
        }
    %>
</div>