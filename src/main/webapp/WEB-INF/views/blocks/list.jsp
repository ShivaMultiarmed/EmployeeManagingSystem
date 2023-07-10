<%@page import="mikhail.shell.ems.models.ATask"%>
<%@page import="mikhail.shell.ems.models.TaskList"%>
<%@page import="mikhail.shell.ems.models.AbstractTask"%>
<%
    TaskList list = (TaskList) request.getAttribute("taskList");
%>
<div class="list">
    <h1>${list.title}</h1>
    <p>${list.description}</p>
    <ul>
    <%
        if (!list.getInsides().isEmpty())
        {
            for(ATask task : list.getInsides())
            {
                %>
                <li><%=task.getTitle()%></li>
                <%
            }
        }
    %>
    </ul>
</div>