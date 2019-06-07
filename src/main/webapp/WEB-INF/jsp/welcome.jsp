<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	function format(rowData) {
		var div = $('<div/>').addClass('loading').text('Loading...');
		//alert("------>>" + rowData);
		$.ajax({
			url : '/WeHaulWS/wehaul/req/getLatestQuotesByReqId/' + rowData[1],
			success : function(data) {
				//var childRows = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
				var childRows = '';
				// print each child item
				$.each(data, function(index, value) {
					childRows +='<tr><td>'+value.qOwnerName+'</td><td>Rs. '+value.quote+'</td><td>'+value.qOwnerContactNo+'</td></tr>';					
				}); // end each
				//childRows+='</table>';
				//alert(childRows);
				//div.html(JSON.stringify(data)).removeClass('loading');
				div.html(childRows).removeClass('loading');
			}
		});
		return div;
	}

	$(document).ready(
			function() {
				var table = $('#quoted_requirements').DataTable({
					"bLengthChange" : false,
					"bFilter" : false,
					"responsive" : false,
					"order" : [ [ 1, "desc" ] ],
					"columnDefs" : [ {
						"targets" : [ 0 ],
						"class": 'details-control',
		                "orderable": false,
		                "data": null,
		                "defaultContent": ''
					},{
						"targets" : [ 1 ],
						"visible" : false,
						"searchable" : false
					} ]
				});

				// Add event listener for opening and closing details
				$('#quoted_requirements tbody').on('click',
						'td.details-control', function() {
							var tr = $(this).parents('tr');
							var row = table.row(tr);

							if (row.child.isShown()) {
								// This row is already open - close it
								row.child.hide();
								tr.removeClass('shown');
							} else {
								// Open this row
								row.child(format(row.data())).show();
								tr.addClass('shown');
							}
						});

				$('#openandquoted_requirements').DataTable({
					"bLengthChange" : false,
					"order" : [ [ 0, "desc" ] ],
					"columnDefs" : [ {
						"targets" : [ 0 ],
						"visible" : false,
						"searchable" : false
					} ]
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
							<th></th>
							<th>Id</th>
							<th>Need</th>
							<th>Date/Time</th>
							<th>Source</th>
							<th>Destination</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th>Owner</th>
								<th>Delete</th>
							</security:authorize>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${quotedrequirements}" var="quotedrequirement">
							<tr>
								<td></td>
								<td>${quotedrequirement.reqid}</td>
								<c:set var="reqtype" value="${quotedrequirement.reqtype}" />
								<td><a href="edit-req?reqid=${quotedrequirement.reqid}">${reqTypeMap[reqtype]}</a></td>
								<td><fmt:parseDate value="${quotedrequirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
								<td>${quotedrequirement.reqpickuploc}</td>
								<td>${quotedrequirement.reqdroploc}</td>
								<security:authorize access="hasAnyAuthority('ADMIN')">
									<td>${quotedrequirement.client.clientname}</td>
									<td><a href="delete-req?reqid=${quotedrequirement.reqid}"
										onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
											class="fa fa-trash"></span></a></td>
								</security:authorize>
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
						Table 2: <i>List of all open requirements in the market.</i>
					</caption>
					<thead>
						<tr>
							<th>Id</th>
							<th>Need</th>
							<th>Date/Time</th>
							<th>Source</th>
							<th>Destination</th>
							<security:authorize access="hasAnyAuthority('ADMIN')">
								<th>Owner</th>
								<th>Status</th>
								<th>Delete</th>
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
										href="delete-req?reqid=${openandquotedrequirement.reqid}"
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