<%@page import="mikhail.shell.ems.models.ATask"%>
<%
    ATask task = (ATask) request.getAttribute("task");
%>
<div class="list">
    <h1>${task.title}</h1>
    <p>${task.description}</p>
    <%
        if (!task.getInsides().isEmpty())
        {
            for(ATask subTask : task.getInsides())
            {
                %>
                <li><%=subTask.getTitle()%></li>
                <%
            }
        }
    %>
</div>