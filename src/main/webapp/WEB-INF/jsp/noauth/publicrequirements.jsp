<%@ include file="../common/header.jspf"%>
<%@ include file="../common/publicnavigation.jspf"%>
<script>
	$(document).ready(
			function() {
				$('#openandquoted_requirements').DataTable({
					"bLengthChange" : false,
					"order" : [ [ 1, "desc" ] ],
					"columnDefs" : [ {
						"targets" : [ 0 ],
						"visible" : false,
						"searchable" : false
					} ]
				});

				$('#openandquoted_requirements tbody').on(
						'click',
						'tr',
						function() {
							var data = $('#openandquoted_requirements')
									.DataTable().row(this).data();
							//alert('You clicked on ' + data[4]+ '\'s row');
							var ecid = encodeURIComponent('${param.cid}');
							//alert(ecid);
							$(location).attr(
									'href',
									'/noauth/sendquotes?cid=' + ecid
											+ '&reqid=' + data[0])
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
				<h2 class="section-heading">Marketplace</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
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
							<th>Source</th>
							<th>Destination</th>
							<th>Quotes (Rs.)</th>
							<th>Comments</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${openandquotedrequirements}"
							var="openandquotedrequirement">
							<tr>
								<td>${openandquotedrequirement.reqid}</td>
								<td>${openandquotedrequirement.reqtype}</td>
								<td><fmt:parseDate
										value="${openandquotedrequirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${openandquotedrequirement.reqpickuploc}</td>
								<td>${openandquotedrequirement.reqdroploc}</td>
								<td><c:choose>
										<c:when test="${empty openandquotedrequirement.quote}">
											<p class="text-danger">Click to send quotes.</p>
										</c:when>
										<c:otherwise>
											${openandquotedrequirement.quote}
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when
											test="${empty openandquotedrequirement.quote && empty openandquotedrequirement.clientComment}">
											<p class="text-danger">Click to send quotes.</p>
										</c:when>
										<c:otherwise>
											${openandquotedrequirement.clientComment}
										</c:otherwise>
									</c:choose></td>
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