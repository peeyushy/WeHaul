<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">
					<c:out value="${action}" />
					User
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<form:form method="post" modelAttribute="user">
			<c:set var="userErrors">
				<form:errors path="*" />
			</c:set>
			<c:if test="${not empty userErrors}">
				<div class="row">
					<div class="col-lg-12">
						<div class="alert alert-danger alert-dismissible">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							${userErrors}
						</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="name">Full Name</label>
								<form:input class="form-control" id="name" name="name"
									path="name" type="text" placeholder="FullName"
									required="required" />
								<p class="note">Please enter full name.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Email</label>
								<form:input class="form-control" id="email" name="email"
									path="email" type="text" placeholder="email@something.com"
									required="required" />
								<p class="note">User registered email.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="contactno">Mobile Number</label>
								<form:input class="form-control" id="contactno" name="contactno"
									path="contactno" type="text" placeholder="07676767676" />
								<p class="note">User registered mobile number.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="notificationtype">Notification Method</label>
								<form:select class="form-control" name="notificationtype"
									path="notificationtype">
									<option value="SMSANDEMAIL"
										${user.notificationtype == "SMSANDEMAIL" ? 'selected="selected"' : ''}>SMS
										and Email</option>
									<option value="SMS"
										${user.notificationtype == "SMS" ? 'selected="selected"' : ''}>SMS
										Only</option>
									<option value="EMAIL"
										${user.notificationtype == "EMAIL" ? 'selected="selected"' : ''}>Email
										Only</option>
									<option value="NONE"
										${user.notificationtype == "NONE" ? 'selected="selected"' : ''}>None</option>
								</form:select>
								<p class="note">Selected method will be used to send you
									notifications.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="username">User Name</label>
								<form:input class="form-control" id="username" name="username"
									path="username" type="text" placeholder="UserName"
									required="required" />
								<p class="note">Please enter user name.This will be used for
									login.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="password">Password</label>
								<form:input class="form-control" id="password" name="password"
									path="password" type="password" placeholder="******"
									required="required" />
								<p class="note">User password.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="confirmpassword">Confirm Password</label> <input
									class="form-control" id="confirmpassword"
									name="confirmpassword" type="password" placeholder="******"
									required="required" />
								<p class="note">Confirm user password.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="role">Role</label>
								<form:select class="form-control" name="role" path="role">
									<form:options items="${roleMap}" />
								</form:select>
								<p class="note">User access role.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:checkbox name="active" path="active" />
								<label for="flexidays">&nbsp;&nbsp;Active</label>
								<p class="note">Uncheck to disable user.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<a href="edit-client?cid=${cid}"
									class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
								<form:button type="submit"
									class="btn btn-default btn-lg btn-style">Save</form:button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="common/footer.jspf"%>