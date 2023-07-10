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
                <% if (!task.isSubTask() && !task.getInsides().isEmpty()) { 
                for (AbstractTask aTask : task.getInsides())
                {
                    ATask theTask = (ATask) aTask;
            %>
                    <li>
                        <a href="/task/<%=theTask.getId()%>">
                            <%=theTask.getTitle()%>
                        </a>
                        <span><%=theTask.getStart()%></span>
                        <span><%=theTask.getFinish()%></span>
                        <a href="/task/<%=theTask.getAssignee().getId()%>">
                            ${theTask.assignee.name}"
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
