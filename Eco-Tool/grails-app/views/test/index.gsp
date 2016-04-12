<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 10/03/16
  Time: 12:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
        <meta name="layout" content="main"/>
        <title>Welcome to th Eco-Tool</title>
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">
                Eco Tool Test
            </h3>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <g:form role="form" action="test">
                <div class="form-group">

                    <label for="iv1">
                        IV1 -
                    </label>
                    <input class="form-control" id="iv1" name="iv1" type="text" value="${params.iv1}"/>
                </div>
                <div class="form-group">

                    <label for="iv2">
                        IV2 -
                    </label>
                    <input class="form-control" id="iv2" name="iv2" type="text" value="${params.iv2}"/>
                </div>
                <div class="form-group">

                    <label for="iv3">
                        IV3 -
                    </label>
                    <input class="form-control" id="iv3" name="iv3" type="text" value="${params.iv3}"/>
                </div>
                <div>
                    <label for="lens">
                        Lens Production -
                    </label>
                    <select name="lens" id="lens">
                        <g:each in="${params.counties}" var="it">
                            <g:if test="${it.equals(params.lens)}">
                                <option selected>
                            </g:if>
                            <g:else><option></g:else>
                            ${it}</option>
                        </g:each>
                    </select>
                </div>
                <div>
                    <label for="frontal">
                        Frontal Production -
                    </label>
                    <select name="frontal" id="frontal">
                        <g:each in="${params.counties}" var="it">
                            <g:if test="${it.equals(params.frontal)}">
                                <option selected>
                            </g:if>
                            <g:else><option></g:else>
                            ${it}</option>
                        </g:each>
                    </select>
                </div>
                <div>
                    <label for="ti">
                        Ti Frontal -
                    </label>

                    <input type="checkbox" name="ti" id="ti" value="true" >

                <div>
                    <label for="temple">
                        Temple Production -
                    </label>
                    <select name="temple" id="temple">
                        <g:each in="${params.counties}" var="it">
                            <g:if test="${it.equals(params.temple)}">
                                <option selected>
                            </g:if>
                            <g:else><option></g:else>
                            ${it}</option>
                        </g:each>
                    </select>
                </div>

                </div>
                <button type="submit" class="btn btn-default">
                    Submit
                </button>
            </g:form>
        </div>

        <div class="col-md-2">
        </div>
        <div class="col-md-4">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        operation
                    </th>
                    <th>
                        result
                    </th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${params}" var="it">
                    <g:if test="${it.key.toString().contains("operation")}">
                        <tr>
                        <td>${it.key}</td>
                        <td>${it.value}</td>
                        </tr>
                    </g:if>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>