<%@include file="/libs/wcm/global.jsp" %>
<%
%>
<%@ page import="java.util.Iterator,
                 com.day.cq.wcm.api.PageFilter" %>
<%
    String listroot = currentStyle.get("listroot", currentPage.getPath());
    Page rootPage = pageManager.getPage(listroot);
    if (rootPage != null) {
        Iterator<Page> children = rootPage.listChildren(new PageFilter(request));
%>
<div class="newslist"><%
    while (children.hasNext()) {
        Page child = children.next();
        String title = child.getTitle() == null ? child.getName() : child.getTitle();
        String date = child.getProperties().get("date", "");
%>
    <div class="item">
        <a href="<%= child.getPath() %>.html"><b><%= title %>
        </b></a>
        <span><%= date %></span><br>
        <%= child.getProperties().get("jcr:description", "") %><br>
    </div>
    <%
        }
    %></div>
<%
    }
%>