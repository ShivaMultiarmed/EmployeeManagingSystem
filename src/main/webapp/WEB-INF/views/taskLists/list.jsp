<%@page import="mikhail.shell.ems.models.TaskList"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    TaskList list = (TaskList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Here is a single list</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%--<jsp:include page="../blocks/sideBar.jsp">
            <jsp:param name="model" value="projects" />
            <jsp:param name="model" value="employees" />
        </jsp:include>-->
        <form method="POST" action="<%= request.getContextPath() %>/tasklists/${list.id}/remove">
            <input type="hidden" name="_method" value="DELETE" />
            <input type="submit" value="Remove" />
        </form>   
            <div>
                    <jsp:include page="../blocks/list.jsp">
                        <jsp:param name="model" value="list" />
                    </jsp:include>
            </div>
        
    </body>
</html>
