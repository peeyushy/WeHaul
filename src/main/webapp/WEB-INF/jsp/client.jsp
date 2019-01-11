<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script>
	$(document).ready(function() {
		$('#table_vehicles').DataTable();
		$('#table_loads').DataTable();
		$('#table_users').DataTable();
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12" id="panel">
				<h2 class="section-heading">
					<c:out value="${action}" />
					<c:out value="${title}" />
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
						<div class="alert alert-success alert-dismissible">
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
								<label for="contactno">Contact No</label>
								<form:input type="text" name="contactno" path="contactno"
									class="form-control" placeholder="01234567890"
									required="required" />
								<p class="note">Client contact no.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="addressline2">Full Address</label>
								<form:textarea name="address" path="address"
									class="form-control" placeholder="Full Address" rows="3" />
								<p class="note">Address of the client.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="contactno">Email Address</label>
								<form:input type="text" name="email" path="email"
									class="form-control" placeholder="something@gmail.com" />
								<p class="note">Client email address.</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group form-group">
								<form:checkbox id="broker" path="broker" />
								<label for="broker">&nbsp;&nbsp;Broker</label>
								<p class="note">Is this client a broker?</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group form-group">
								<form:checkbox id="verified" path="verified" />
								<label for="verified">&nbsp;&nbsp;Verified Client</label>
								<p class="note">Is this client verified?</p>
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
					<c:choose>
						<c:when test="${client.clienttype=='T'}">
							<hr>
							<div class="row">
								<div class="col-lg-12">
									<table id="table_vehicles" class="display">
										<thead>
											<tr>
												<th>Vehicle No</th>
												<th>Vehicle Type</th>
												<th>Load Type</th>
												<th>Available Load</th>
												<th>Status</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${vehicles}" var="vehicle">
												<tr>
													<td><a
														href="/edit-vehicle?cid=${client.clientid}&vid=${vehicle.vid}">${vehicle.regno}</a></td>
													<td>${vehicle.vtype.vtypename}</td>
													<td><c:forEach items="${vehicle.ltype}" var="ltype"
															varStatus="loop">
													${ltype.ltypename}<c:if test="${!loop.last}">,</c:if>
														</c:forEach></td>
													<td>${fn:length(vehicle.loads)}</td>
													<td>${vehicle.status}</td>
													<td><a
														href="/delete-vehicle?cid=${client.clientid}&vid=${vehicle.vid}"
														onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
															class="fa fa-trash"></span></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:when test="${client.clienttype=='S'}">
							<hr>
							<div class="row">
								<div class="col-lg-12">
									<table id="table_loads" class="display">
										<thead>
											<tr>
												<th>Load Id</th>
												<th>Pick-Up Location</th>
												<th>Drop Location</th>
												<th>Load Type</th>
												<th>Available Vehicle</th>
												<th>Status</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${loads}" var="load">
												<tr>
													<td><a
														href="/edit-load?cid=${client.clientid}&lid=${load.lid}">${load.lid}</a></td>
													<td>${load.lpickuploc}</td>
													<td>${load.ldroploc}</td>
													<td>${load.ltype.ltypename}</td>
													<%-- <fmt:parseDate value="${load.ldatetime}"
														pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
														type="both" />
													<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
															value="${parsedDateTime}" /></td> --%>
													<td>${fn:length(load.vehicles)}</td>
													<td>${load.status}</td>
													<td><a
														href="/delete-load?cid=${client.clientid}&lid=${load.lid}"
														onclick="return confirm('Are you sure? Delete cant be rolled back.')"><span
															class="fa fa-trash"></span></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					<hr>
					<div class="row">
						<div class="col-lg-12">
							<table id="table_users" class="display">
								<thead>
									<tr>
										<th>Name</th>
										<th>UserName</th>
										<th>Email</th>
										<th>Role</th>
										<th>Active</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${client.users}" var="user">
										<tr>
											<td><a
												href="/edit-user?cid=${client.clientid}&uid=${user.userid}">${user.name}</a></td>
											<td>${user.username}</td>
											<td>${user.email}</td>
											<td>${user.role.rolename}</td>
											<td>${user.active}</td>
											<td><a
												href="/delete-user?cid=${client.clientid}&uid=${user.userid}"
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
							</div>
							<p class="note">Any additional comments by sales/operations
								team.</p>
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
							<a href="/find-client?type=${client.clienttype}"
								class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
							<c:if test="${client.active}">
								<c:choose>
									<c:when test="${client.clienttype=='T'}">
										<a href="/add-vehicle?cid=${client.clientid}"
											class="btn btn-default btn-lg btn-style">Add Vehicle</a>&nbsp;
									</c:when>
									<c:when test="${client.clienttype=='S'}">
										<a href="/add-load?cid=${client.clientid}"
											class="btn btn-default btn-lg btn-style">Add Load</a>&nbsp;
									</c:when>
								</c:choose>
								<a href="/add-user?cid=${client.clientid}"
									class="btn btn-default btn-lg btn-style">Add User</a>&nbsp;
							</c:if>
						</c:if>
						<form:button type="submit"
							class="btn btn-default btn-lg btn-style" name="saveBtn">Save</form:button>
					</div>
				</div>
			</div>
			<form:input type="hidden" name="clienttype" path="clienttype" />
			<form:input type="hidden" name="revid" path="revid" />
		</form:form>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>