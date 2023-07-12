<%@page import="mikhail.shell.ems.models.TaskList"%>
<%@page import="java.util.List"%>
<%@page import="mikhail.shell.ems.models.Project"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    Project project = (Project)request.getAttribute("project");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>A single project</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <div>
            <h1>${project.title}</h1>
            <p>Описание <br /><%= project.getDescription() %></p>
        </div>
        <a href="<%= request.getContextPath() %>/projects/${project.id}/edit">edit</a>

        <form method="POST" action="<%= request.getContextPath() %>/projects/${project.id}/remove">
            <input type="hidden" name="_method" value="DELETE" />
            <input type="submit" value="Remove" />
        </form>   
            <div>
                <%
                    List<TaskList> lists = project.getInsides();
                    for (TaskList list : lists)
                    {
                        request.setAttribute("list", list);
                    %>
                    
                    <jsp:include page="../blocks/list.jsp">
                        <jsp:param name="model" value="list" />
                    </jsp:include>
                    
                    <%
                    }
                %>
            </div>
    </body>
</html>
