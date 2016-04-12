
<%@ page import="eco.tool.EcoToolValues" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ecoToolValues.label', default: 'EcoToolValues')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-ecoToolValues" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				%{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
			</ul>
		</div>
		<div id="list-ecoToolValues" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>

						<g:sortableColumn property="indicator" title="${message(code: 'ecoToolValues.indicator.label', default: 'Indicator')}" />
						<g:sortableColumn property="name" title="${message(code: 'ecoToolValues.name.label', default: 'Name')}" />



						<g:sortableColumn property="value" title="${message(code: 'ecoToolValues.value.label', default: 'Value')}" />
						<g:sortableColumn property="unit" title="${message(code: 'ecoToolValues.unit.label', default: 'Unit')}" />




					</tr>
				</thead>
				<tbody>
				<g:each in="${ecoToolValuesInstanceList}" status="i" var="ecoToolValuesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ecoToolValuesInstance.id}">${fieldValue(bean: ecoToolValuesInstance, field: "indicator")}</g:link></td>
						<td>${fieldValue(bean: ecoToolValuesInstance, field: "name")}</td>

						<td>${fieldValue(bean: ecoToolValuesInstance, field: "value")}</td>

						<td>${fieldValue(bean: ecoToolValuesInstance, field: "unit")}</td>
					

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ecoToolValuesInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
