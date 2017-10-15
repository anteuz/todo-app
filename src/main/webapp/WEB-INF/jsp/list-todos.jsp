<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
	Hi ${name }
	<br />
	<table class="table table-striped">
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
					<td>${todo.done}</td>
					<td><a href="/update-todo?id=${todo.id}" type="button" class="btn btn-success">Update</a></td>
					<td><a href="/delete-todo?id=${todo.id}" type="button" class="btn btn-warning">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="button" href="/add-todo">Add Todo</a>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
<%@ include file="common/footer.jspf" %>