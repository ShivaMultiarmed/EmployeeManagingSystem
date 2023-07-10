<%@page import="mikhail.shell.ems.models.AbstractTask"%>
<%@page import="mikhail.shell.ems.models.ATask"%>
<%@page import="mikhail.shell.ems.models.TaskList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    TaskList taskList = (TaskList) request.getAttribute("taskList");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Here is a single list</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="../blocks/sideBar.jsp">
            <jsp:param name="model" value="projects" />
            <jsp:param name="model" value="employees" />
        </jsp:include>
        <div>
            <h1>${taskList.title}</h1>
            <p>${taskList.description}</p>
            <ul>
                <% for (AbstractTask absTask : taskList.getInsides())
                    {
                        ATask task = (ATask) absTask;
                %>
                <li>
                    <a href="/task/<%= task.getId() %>">
                        <%= task.getTitle()%>"
                    </a>
                    <span> <%= task.getStart()%></span> 
                    <span> <%= task.getFinish()%> </span>
                    <a href="/task/<%= task.getAssignee().getId() %>">
                        <%= task.getAssignee().getName()%>
                    </a>
                </li>
                <% } %>
            </ul>
        </div>
        
    </body>
</html>
