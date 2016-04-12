
<%@ page import="eco.tool.EcoToolValues" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ecoToolValues.label', default: 'EcoToolValues')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ecoToolValues" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				%{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
			</ul>
		</div>
		<div id="show-ecoToolValues" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ecoToolValues">
			
				<g:if test="${ecoToolValuesInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="ecoToolValues.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:fieldValue bean="${ecoToolValuesInstance}" field="unit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ecoToolValuesInstance?.value}">
				<li class="fieldcontain">
					<span id="value-label" class="property-label"><g:message code="ecoToolValues.value.label" default="Value" /></span>
					
						<span class="property-value" aria-labelledby="value-label"><g:fieldValue bean="${ecoToolValuesInstance}" field="value"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ecoToolValuesInstance?.indicator}">
				<li class="fieldcontain">
					<span id="indicator-label" class="property-label"><g:message code="ecoToolValues.indicator.label" default="Indicator" /></span>
					
						<span class="property-value" aria-labelledby="indicator-label"><g:fieldValue bean="${ecoToolValuesInstance}" field="indicator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ecoToolValuesInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="ecoToolValues.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${ecoToolValuesInstance}" field="name"/></span>
					
				</li>
				</g:if>
			

			
			</ol>
			<g:form url="[resource:ecoToolValuesInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${ecoToolValuesInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
