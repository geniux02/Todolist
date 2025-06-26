<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h2>Your list todo: </h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done ?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todo}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
					<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href=add-todo class="btn btn-success">Add todo</a>
</div>
<%@ include file="common/footer.jspf"%>
