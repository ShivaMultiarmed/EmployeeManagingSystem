<%@page import="mikhail.shell.ems.models.Project"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    Project project = (Project)request.getAttribute("project");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Создать проект</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    </head>
    <body>
        <jsp:include page="../../views/blocks/sideBar.jsp">
            <jsp:param name="model" value="projects" />
            <jsp:param name="model" value="employees" />
        </jsp:include>
        <div>
            <h1>Создать проект</h1>
        </div>
        <form method="POST"
              action="<%= request.getContextPath() %>/projects/create"
              commandName="project">
            <input type="hidden" name="_method" value="POST" />
            <input type="text" name="title"  placeholder="some title here" />
            <textarea name="description">          
            </textarea>
            <input type="submit" value="Создать" />
        </form>
    </body>
</html>
