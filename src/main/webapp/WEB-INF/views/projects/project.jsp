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
            <h1><%= project.getTitle() %></h1>
            <p>Описание <br /><%= project.getDescription() %></p>
        </div>
        <a href="<%= request.getContextPath() %>/projects/${project.id}/edit">edit</a>

        <form method="POST" action="<%= request.getContextPath() %>/projects/${project.id}/remove">
            <input type="hidden" name="_method" value="DELETE" />
            <input type="submit" value="Remove" />
        </form>   
        
    </body>
</html>
