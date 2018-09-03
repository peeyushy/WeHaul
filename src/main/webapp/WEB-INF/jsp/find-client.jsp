<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

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
				<form>
					<table id="table_client" class="display">
						<thead>
							<tr>
								<th>Name</th>
								<th>PostCode</th>
								<th>Contact No</th>
								<!-- <th>Subscription Type</th> -->
								<th>Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${clients}" var="client">
								<tr>
									<td>${client.clientname}</td>
									<td>${client.postcode}</td>
									<td>${client.contactno}</td>
									<%-- <td>${client.postcode}</td> --%>
									<td>${client.status}</td>
									<td><a href="/delete-client?type=${client.clienttype}&id=${client.clientid}"><span
											class="fa fa-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>
<%@ include file="common/footer.jspf"%>