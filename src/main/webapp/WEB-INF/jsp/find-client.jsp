<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {		
		$('#table_client').DataTable({
			"bLengthChange" : false
		});
	});
</script>
<style>
.dataTables_wrapper .dataTables_length, .dataTables_wrapper .dataTables_filter,
	.dataTables_wrapper .dataTables_info {
	float: none;
	text-align: left;
}
</style>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
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
				<table id="table_client" class="display responsive nowrap"
					style="width: 100%">
					<thead>
						<tr>
							<th>Name</th>
							<th class="none">Contact No</th>
							<th class="none">Address</th>
							<th class="none">City</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th class="none">Type</th>
								<th class="none">Active</th>
								<th class="none">Delete</th>
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
	<!-- /.container-fluid -->
</div>
<%@ include file="common/footer.jspf"%>