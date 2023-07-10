<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit a project</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Edit a project</h1>
        <form action="edit" method="post" modelAttribute="project">
            <input type="hidden" name="_method" value="PATCH" />
            <input type="text" name="title" value="${project.title}" />
            <textarea name="description">${project.description}</textarea>
            <input type="submit" value="edit" />
        </form>
    </body>
</html>

