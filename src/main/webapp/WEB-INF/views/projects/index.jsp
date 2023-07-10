<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Here are all projects</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Lists of  projects</div>
        <ul>
            <% for (Project project : (List<Project>) request.getAttribute("projects")) { %>
            <li>
                <a href="/projects/<%= project.getId() %>"><%= project.getTitle() %></a>
            </li>
            <% } %>
        </ul>
    </body>
</html>