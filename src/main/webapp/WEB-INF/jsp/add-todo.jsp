<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
Hi ${name }<br/>
<form:form method="post" modelAttribute="todo">
	<form:hidden path="id"/>
	<fieldset class="form-group">
		<form:label path="desc">Description</form:label>
		<form:input path="desc" class="form-control" name="desc" type="text" required="required"/>
		<form:errors path="desc" cssClass="text-warning"/>
	</fieldset>
	
	<fieldset class="form-group">
		<form:label path="targetDate">Description</form:label>
		<form:input path="targetDate" class="form-control" name="desc" type="date" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"/>
	</fieldset>
	 
	<form:button class="btn btn-success" type="submit">Add</form:button> 
</form:form>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script	src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
		
	</div>
<%@ include file="common/footer.jspf" %>