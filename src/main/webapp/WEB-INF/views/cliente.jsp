<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-9">
	<div class="well">
		<h1 class="page-header">
			<tiles:getAsString name="title" />
		</h1>

		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-lg-6">
					<spring:url value="" var="urlActual" />
					<form:form id="clienteForm" modelAttribute="cliente"
						action="${urlActual}" method="post" role="form"
						novalidate="novalidate">
						<form:hidden path="id" />
						<div class="form-group">
							<form:label path="nombre">Nombre</form:label>
							<form:input path="nombre" cssClass="form-control"
								autofocus="autofocus" />
							<form:errors path="nombre" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="apellido">Apellido</form:label>
							<form:input path="apellido" cssClass="form-control" />
							<form:errors path="apellido" cssClass="errorMessage" />
						</div>

						<div class="form-group">
							<form:label path="sexo">Sexo</form:label>
							<form:select path="sexo" cssClass="form-control">
								<form:option value="" label="Seleccione un sexo" />
								<form:option value="Femenino" label="Femenino" />
								<form:option value="Masculino" label="Masculino" />
							</form:select>
							<form:errors path="sexo" cssClass="errorMessage" />
						</div>

						<div class="form-group">
							<form:label path="fechaNacimiento">Fecha de nacimiento</form:label>
							<form:input type="date" path="fechaNacimiento"
								cssClass="form-control" />
							<form:errors path="fechaNacimiento" cssClass="errorMessage" />
						</div>
						<div class="form-group">
							<form:label path="dni">DNI</form:label>
							<form:input type="number" path="dni" cssClass="form-control" />
							<form:errors path="dni" cssClass="errorMessage" />
						</div>
				</div>

				<div class="col-lg-6">
					<div class="form-group">
						<form:label path="telefono">Telefono</form:label>
						<form:input path="telefono" cssClass="form-control" />
						<form:errors path="telefono" cssClass="errorMessage" />
					</div>

					<div class="form-group">
						<form:label path="direccion">Direccion</form:label>
						<form:input path="direccion" cssClass="form-control" />
						<form:errors path="direccion" cssClass="errorMessage" />
					</div>
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:input path="email" cssClass="form-control"
							placeholder="Opcional" />
						<form:errors path="email" cssClass="errorMessage" />
					</div>

					<form:button type="submit" class="btn btn-default">
						<tiles:getAsString name="titleSubmit" />
					</form:button>
					</form:form>
				</div>

			</div>
		</div>
	</div>
</div>

