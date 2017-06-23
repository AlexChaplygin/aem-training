<%@include file="/libs/foundation/global.jsp" %>
<%@ taglib prefix="sling1" uri="http://sling.apache.org/taglibs/sling" %>

<sling1:adaptTo adaptable="${resource}" adaptTo="com.aem.models.TrainingPage" var="trainingPageComponent"/>

<div class="container_16">
    <div class="grid_16">
        <cq:include path="breadcrumb" resourceType="foundation/components/breadcrumb" />
        <cq:include path="par" resourceType="foundation/components/parsys"/>
    </div>

    <h3>Title: ${trainingPageComponent.title} </h3>
    <h3>Resource: ${trainingPageComponent.resource} </h3>
    <h3>Resource.path: ${trainingPageComponent.resource.path} </h3>

    <div class="grid_4 right_container">
        <cq:include path="newslist" resourceType="kdad/components/content/listchildren" />

    </div>
    <div class="clear"></div>

</div>
<p class="myclass">Trying design</p>