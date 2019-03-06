<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#table_requirements').DataTable();
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12" id="panel">
				<h2 class="section-heading">
					Requirements <a href="/add-req"
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
				<table id="table_requirements" class="display">
					<thead>
						<tr>
							<th>Id</th>
							<th>Type</th>
							<th>Pick-Up Location</th>
							<th>Drop Location</th>
							<!-- <th>Load Type</th>
							<th>Vehicle Type</th> -->
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th>Client</th>
							</security:authorize>
							<th>Date/Time</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requirements}" var="requirement">
							<tr>
								<td><a href="/edit-req?reqid=${requirement.reqid}">${requirement.reqid}</a></td>
								<c:set var="reqtype" value="${requirement.reqtype}" />
								<td>${reqTypeMap[reqtype]}</td>
								<td>${requirement.reqpickuploc}</td>
								<td>${requirement.reqdroploc}</td>
								<%-- <td>${requirement.ltype.ltypename}</td>
								<td>${requirement.vtype.vtypename}</td> --%>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<td>${requirement.client.clientname}</td>
								</security:authorize>
								<td><fmt:parseDate value="${requirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${fn:toUpperCase(requirement.status)}</td>
								<td><a href="/delete-req?reqid=${requirement.reqid}"
									onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
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