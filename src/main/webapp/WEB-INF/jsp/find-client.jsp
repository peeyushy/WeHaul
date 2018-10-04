<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#table_client').DataTable();
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12" id="panel">
				<h2 class="section-heading">
					Find
					<c:out value="${title}" />
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
				<c:if test="${not empty msg}">
					<div class="row">
						<div class="col-lg-12">
							<div class="alert alert-success alert-dismissible">
								<a href="#" class="close" data-dismiss="alert"
									aria-label="close">&times;</a> ${msg}
							</div>
						</div>
					</div>
				</c:if>
				<table id="table_client" class="display">
					<thead>
						<tr>
							<th>Name</th>
							<!-- <th>PostCode</th> -->
							<th>Contact No</th>
							<!-- <th>Subscription Type</th> -->
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clients}" var="client">
							<tr>
								<td><a href="/edit-client?cid=${client.clientid}">${client.clientname}</a></td>
								<%-- <td>${client.postcode}</td> --%>
								<td>${client.contactno}</td>
								<%-- <td>${client.postcode}</td> --%>
								<td>${client.status}</td>
								<td><a
									href="/delete-client?type=${client.clienttype}&id=${client.clientid}" onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
										class="fa fa-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>
<%@ include file="common/footer.jspf"%>