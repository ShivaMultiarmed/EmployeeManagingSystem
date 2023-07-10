<%@page import="mikhail.shell.ems.models.AbstractTask"%>
<%@page import="java.util.List"%>
<%@page import="mikhail.shell.ems.models.Project"%>
<%@page import="mikhail.shell.ems.models.Employee"%>
<%
    List<AbstractTask> projects = (List<AbstractTask>) 
            request.getAttribute("projects");
%>
<aside>
    <div>
        Employees
        <ul>
            <%-- for (Employee employee : employees) {%>
            <li>
                <a href="/employees/<%=employee.getId()%>">
                    <%=employee.getTitle()%>
                </a>
            </li>
            <%}--%>
        </ul>
    </div>
    <div>
        Projects
        <ul>
            <% for (AbstractTask project : projects) {%>
            <li>
                <a href="/project/<%=project.getId()%>">
                    <%=project.getTitle()%>
                </a>
            </li>
            <% } %>
        </ul>
    </div>
</aside>