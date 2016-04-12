<%@ page import="eco.tool.EcoToolValues" %>



<div class="fieldcontain ${hasErrors(bean: ecoToolValuesInstance, field: 'unit', 'error')} ">
	<label for="unit">
		<g:message code="ecoToolValues.unit.label" default="Unit" />
		
	</label>
	<g:textField name="unit" value="${ecoToolValuesInstance?.unit}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ecoToolValuesInstance, field: 'value', 'error')} ">
	<label for="value">
		<g:message code="ecoToolValues.value.label" default="Value" />
		
	</label>
	<g:field name="value" value="${fieldValue(bean: ecoToolValuesInstance, field: 'value')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ecoToolValuesInstance, field: 'indicator', 'error')} required">
	<label for="indicator">
		<g:message code="ecoToolValues.indicator.label" default="Indicator" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="indicator" required="" value="${ecoToolValuesInstance?.indicator}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ecoToolValuesInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="ecoToolValues.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${ecoToolValuesInstance?.name}"/>

</div>


</div>

