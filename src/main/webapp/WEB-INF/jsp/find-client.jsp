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
					Clients
					<security:authorize access="hasAnyAuthority('ADMIN')">
						<a href="/add-client"
							class="btn btn-default btn-sm btn-style pull-right">+ Add</a>
					</security:authorize>
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
							<th>Contact No</th>
							<th>Address</th>
							<th>City</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th>Type</th>
								<th>Active</th>
								<th>Action</th>
							</security:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clients}" var="client">
							<tr>
								<td><security:authorize access="hasAnyAuthority('ADMIN')">
										<a href="/edit-client?cid=${client.clientid}">
									</security:authorize> ${client.clientname} <security:authorize
										access="hasAnyAuthority('ADMIN')">
										</a>
									</security:authorize></td>

								<td>${client.contactno}</td>
								<td>${client.address}</td>
								<c:set var="city" value="${client.city}" />
								<td>${cityMap[city]}</td>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<c:set var="ctype" value="${client.clienttype}" />
									<td>${clientTypeMap[ctype]}</td>
									<td>${fn:toUpperCase(client.active)}</td>
									<td><a
										href="/delete-client?type=${client.clienttype}&id=${client.clientid}"
										onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
											class="fa fa-trash"></span></a></td>
								</security:authorize>
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