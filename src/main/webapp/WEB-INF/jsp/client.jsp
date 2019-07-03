<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#table_req').DataTable({
			"bLengthChange" : false,
			"order": [[ 0, "desc" ]]
		});
		$('#table_users').DataTable({
			"bLengthChange" : false,
			"bFilter" : false
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
					<c:out value="${action}" />
					Client
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<form:form method="post" modelAttribute="client">
			<c:set var="newClientErrors">
				<form:errors path="*" />
			</c:set>
			<c:if test="${not empty msg}">
				<div class="row">
					<div class="col-lg-12">
						<div class="alert alert-info alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							${msg}
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty newClientErrors}">
				<div class="row">
					<div class="col-lg-12">
						<div class="alert alert-danger alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							${newClientErrors}
						</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="clientname">Company Name</label>
								<form:input type="text" name="clientname" path="clientname"
									class="form-control" placeholder="Name" required="required" />
								<p class="note">Name of the client.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="clientname">Client Type</label>
								<form:select class="form-control" name="clienttype"
									path="clienttype">
									<form:options items="${clientTypeMap}" />
								</form:select>
								<p class="note">Type of the client.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="contactno">Contact No</label>
								<form:input type="text" name="contactno" path="contactno"
									class="form-control" placeholder="+911234567890"
									required="required" />
								<p class="note">Client contact no.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="role">City</label>
								<form:select class="form-control" name="city" path="city">
									<form:options items="${cityMap}" />
								</form:select>
								<p class="note">Client's home city.</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="contactno">Email Address</label>
								<form:input type="text" name="email" path="email"
									class="form-control" placeholder="something@gmail.com" />
								<p class="note">Client email address.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="addressline2">Full Address</label>
								<form:textarea name="address" path="address"
									class="form-control" placeholder="Full Address" rows="3"
									required="required" />
								<p class="note">Address of the client.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group form-group">
								<form:checkbox id="verified" path="verified" />
								<label for="verified">&nbsp;&nbsp;Verified</label>
								<p class="note">Is this client's data verified?</p>
							</div>
						</div>
					</div>
					<!-- <hr>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Subscription Type</label> <select
									class="form-control">
									<option>Select</option>
									<option selected>Monthly</option>
									<option>Yearly</option>
								</select>
								<p class="note">
									Current subscription type. <a href="#">Payment history</a>.
								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Bank Sort Code</label> <input
									class="form-control" id="user_login" name="sortcode"
									type="text" placeholder="12 34 45" />
								<p class="note">Bank sort code as shown on the card.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Account Number</label> <input
									class="form-control" id="user_login" name="user[login]"
									type="text" placeholder="**** **** **** 1234" />
								<p class="note">Bank account number.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">CVV</label> <input class="form-control"
									id="user_login" name="user[login]" type="password"
									placeholder="123" />
								<p class="note">As shown on the back of card.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Expiry Date</label> <input
									class="form-control" id="user_login" name="user[login]"
									type="text" placeholder="MM/YYYY" />
								<p class="note">Card's expiry date.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Postcode</label> <input class="form-control"
									id="user_login" name="user[login]" type="text"
									placeholder="IG2 6LQ" />
								<p class="note">Postcode registored with this card.</p>
							</div>
						</div>
					</div> -->
					<hr>
					<div class="row">
						<div class="col-lg-12">
							<table id="table_req" class="display responsive nowrap"
								style="width: 100%">
								<caption>
									Table 1: <i>List of all requirements.</i>
								</caption>
								<thead>
									<tr>
										<th>Req No</th>
										<th>Req Type</th>
										<th>Source</th>
										<th>Delivery</th>
										<th>Status</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requirements}" var="req">
										<tr>
											<td><a
												href="edit-client-req?cid=${client.clientid}&reqid=${req.reqid}">${req.reqid}</a></td>
											<td>${req.reqtype}</td>
											<td>${req.reqpickuploc}</td>
											<td>${req.reqdroploc}</td>
											<td>${req.status}</td>
											<td><a
												href="delete-req?cid=${client.clientid}&reqid=${req.reqid}"
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
							<table id="table_users" class="display responsive nowrap"
								style="width: 100%">
								<caption>
									Table 2: <i>List of all users.</i>
								</caption>
								<thead>
									<tr>
										<th>Name</th>
										<th>UserName</th>
										<th>Email</th>
										<th>Role</th>
										<th>Active</th>
										<th>Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${client.users}" var="user">
										<tr>
											<td><a
												href="edit-user?cid=${client.clientid}&uid=${user.userid}">${user.name}</a></td>
											<td>${user.username}</td>
											<td>${user.email}</td>
											<td>${user.role.rolename}</td>
											<td>${fn:toUpperCase(user.active)}</td>
											<td><a
												href="delete-user?cid=${client.clientid}&uid=${user.userid}"
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
							<div class="form-group">
								<label for="comments">Comments</label>
								<form:textarea name="comments" path="comments"
									class="form-control"
									placeholder="Any other details like client website,email address,phone conversation etc."
									rows="5" />
								<p class="note">Any additional comments by sales/operations
									team.</p>
							</div>

						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:checkbox name="active" path="active" />
								<label for="active">&nbsp;&nbsp;Active</label>
								<p class="note">Uncheck to disable client. Please note this
									will disable all users for this client.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="group">
						<c:if test="${action=='Edit'}">
							<a href="clients" class="btn btn-default btn-lg btn-style">&larr;
								Back</a>&nbsp;
							<c:if test="${client.active}">
								<a href="add-client-req?cid=${client.clientid}"
									class="btn btn-default btn-lg btn-style">Add Req</a>&nbsp;
								<a href="add-user?cid=${client.clientid}"
									class="btn btn-default btn-lg btn-style">Add User</a>&nbsp;
							</c:if>
						</c:if>
						<form:button type="submit"
							class="btn btn-default btn-lg btn-style" name="saveBtn">Save</form:button>
					</div>
				</div>
			</div>
			<form:input type="hidden" name="revid" path="revid" />
		</form:form>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="common/footer.jspf"%>