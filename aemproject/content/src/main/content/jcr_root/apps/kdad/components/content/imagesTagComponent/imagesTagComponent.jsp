<%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling" %>
<%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%@include file="/libs/foundation/global.jsp" %>--%>

<%--<cq:include script="/libs/wcm/core/components/init/init.jsp"/>--%>

<cq:defineObjects/>

<sling:adaptTo adaptable="${resource}" adaptTo="com.aem.models.ImageTagsPageModel" var="trainingPageComponent"/>
<label>Images by tag</label>
<div class="container_16">

    <c:forEach items="${trainingPageComponent.imagePathArrayList}" var="item">
        <img src=${item}><br><br>
    </c:forEach>

</div>