<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#quoted_requirements').DataTable({
			"bLengthChange" : false,
			"bFilter": false,
			"order": [[ 0, "desc" ]]
		});
		$('#openandquoted_requirements').DataTable({
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
				<h2 class="section-heading">Dashboard</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<table id="quoted_requirements" class="display responsive nowrap"
					style="width: 100%">
					<caption>
						Table 1: <i>List of all quoted requirements.</i>
					</caption>
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
						<c:forEach items="${quotedrequirements}" var="quotedrequirement">
							<tr>
								<td><a href="/edit-req?reqid=${quotedrequirement.reqid}">${quotedrequirement.reqid}</a></td>
								<c:set var="reqtype" value="${quotedrequirement.reqtype}" />
								<td>${reqTypeMap[reqtype]}</td>
								<td><fmt:parseDate value="${quotedrequirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${quotedrequirement.reqpickuploc}</td>
								<td>${quotedrequirement.reqdroploc}</td>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<td>${quotedrequirement.client.clientname}</td>
								</security:authorize>

								<td>${fn:toUpperCase(quotedrequirement.status)}</td>
								<td><a href="/delete-req?reqid=${quotedrequirement.reqid}"
									onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
										class="fa fa-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-lg-12">
				<table id="openandquoted_requirements"
					class="display responsive nowrap" style="width: 100%">
					<caption>
						Table 2: <i>List of all open and quoted requirements.</i>
					</caption>
					<thead>
						<tr>
							<th>Id</th>
							<th>Type</th>
							<th>Date/Time</th>
							<th class="none">Pick-Up</th>
							<th class="none">Drop</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th class="none">Client</th>
								<th class="none">Status</th>
								<th class="none">Delete</th>
							</security:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${openandquotedrequirements}"
							var="openandquotedrequirement">
							<tr>
								<td>${openandquotedrequirement.reqid}</td>
								<c:set var="reqtype" value="${openandquotedrequirement.reqtype}" />
								<td>${reqTypeMap[reqtype]}</td>
								<td><fmt:parseDate
										value="${openandquotedrequirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${openandquotedrequirement.reqpickuploc}</td>
								<td>${openandquotedrequirement.reqdroploc}</td>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<td>${openandquotedrequirement.client.clientname}</td>
									<td>${fn:toUpperCase(openandquotedrequirement.status)}</td>
									<td><a
										href="/delete-req?reqid=${openandquotedrequirement.reqid}"
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