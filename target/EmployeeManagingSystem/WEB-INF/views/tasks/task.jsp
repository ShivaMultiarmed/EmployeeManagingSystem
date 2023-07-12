<%@page import="mikhail.shell.ems.models.AbstractTask"%>
<%@page import="mikhail.shell.ems.models.ATask"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    ATask task = (ATask)request.getAttribute("task");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>A single task</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="../blocks/sideBar.jsp">
            <jsp:param name="model" value="projects" />
            <jsp:param name="model" value="employees" />
        </jsp:include>
        <div>
            <h1>${task.title}</h1>
            <p>${task.description}</p>
            <ul>
                <% if (task.getSupertaskid() > 0
                    && !task.getInsides().isEmpty()) { 
                for (ATask subTask : task.getInsides())
                {
            %>
                    <li>
                        <a href="/tasks/<%=subTask.getId()%>">
                            <%=subTask.getTitle()%>
                        </a>
                        <span><%=subTask.getStart()%></span>
                        <span><%=subTask.getFinish()%></span>
                        <a href="/tasks/<%=subTask.getAssignee().getId()%>">
                            <%=subTask.getAssignee().getId()%>
                        </a>
                    </li>
            <% } 
            } %>
            </ul>
            <p><%=task.getStart()%></p>
            <p><%=task.getFinish()%></p>
            <p>here should be files</p>
        </div>
    </body>
</html>
