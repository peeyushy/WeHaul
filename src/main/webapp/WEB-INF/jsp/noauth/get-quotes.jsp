<%@ include file="../common/header.jspf"%>
<%@ include file="../common/publicnavigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#openandquoted_requirements').DataTable({
			"bLengthChange" : false,
			"order" : [ [ 0, "desc" ] ]
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
				<h2 class="section-heading">Requirements</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<table id="openandquoted_requirements"
					class="display responsive nowrap" style="width: 100%">
					<caption>
						Table 2: <i>List of all available requirements.</i>
					</caption>
					<thead>
						<tr>
							<th>Id</th>
							<th>Type</th>
							<th>Date/Time</th>
							<th class="none">Pick-Up</th>
							<th class="none">Drop</th>
							<th class="none">Load</th>
							<th class="none">Vehicle</th>
							<th class="none">Comments</th>
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
								<td>${openandquotedrequirement.ltype.ltypename}</td>
								<td>${openandquotedrequirement.vtype.vtypename}</td>
								<td>${openandquotedrequirement.comments}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="../common/footer.jspf"%>