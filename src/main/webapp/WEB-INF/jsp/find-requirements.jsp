<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {		
		$('#table_requirements').DataTable({
			"bLengthChange" : false,
			"order": [[ 0, "desc" ]]
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
					Requirements <a href="add-req"
						class="btn btn-default btn-sm btn-style pull-right">+ Add</a>
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
				<table id="table_requirements" class="display responsive nowrap"
					style="width: 100%">
					<thead>
						<tr>
							<th>Id</th>
							<th>Type</th>
							<th>Date/Time</th>
							<th class="none">Pick-Up</th>
							<th class="none">Drop</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th class="none">Client</th>
							</security:authorize>							
							<th class="none">Status</th>
							<th class="none">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requirements}" var="requirement">
							<tr>
								<td><a href="edit-req?reqid=${requirement.reqid}">${requirement.reqid}</a></td>
								<c:set var="reqtype" value="${requirement.reqtype}" />
								<td>${reqTypeMap[reqtype]}</td>
								<td><fmt:parseDate value="${requirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${requirement.reqpickuploc}</td>
								<td>${requirement.reqdroploc}</td>
								<%-- <td>${requirement.ltype.ltypename}</td>
								<td>${requirement.vtype.vtypename}</td> --%>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<td>${requirement.client.clientname}</td>
								</security:authorize>								
								<td>${fn:toUpperCase(requirement.status)}</td>
								<td><a href="delete-req?reqid=${requirement.reqid}"
									onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
										class="fa fa-trash"></span></a></td>
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