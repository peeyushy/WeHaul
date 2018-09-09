<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

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
								<label for="addressline1">Address Line1</label>
								<form:input type="text" name="addressline1" path="addressline1"
									class="form-control" placeholder="Address" />
								<p class="note">Address of the client.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="addressline2">Address Line2</label>
								<form:input type="text" name="addressline2" path="addressline2"
									class="form-control" placeholder="Address" />
								<p class="note">Address of the client.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="city">Town/City</label>
								<form:input type="text" name="city" path="city"
									class="form-control" placeholder="Town/City" />
								<p class="note">Town/City of the client.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="postcode">Postcode</label>
								<form:input type="text" name="postcode" path="postcode"
									class="form-control" placeholder="Postcode" />
								<p class="note">Postcode of the client.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="country">Country</label>
								<form:select name="country" path="country" class="form-control">
									<option value="UK">United Kingdom</option>
								</form:select>
								<p class="note">Country client is registered.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="website">Website</label>
								<form:input type="text" name="website" path="website"
									class="form-control" placeholder="www.client.com" />
								<p class="note">Website of the client.</p>
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
						<div class="col-lg-12">
							<div class="form-group">
								<label for="email">Client Logo</label>
								<form:input type="file" path="clientlogo" />
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
							<div class="form-group">
								<label for="comments">Comments</label>
								<form:textarea name="comments" path="comments"
									class="form-control" rows="5" />
							</div>
							<p class="note">Any additional comments by sales/operational
								team.</p>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:input type="hidden" name="status" path="status"
									value="DISABLED" />
								<form:checkbox name="status" path="status" value="ACTIVE" />
								<label for="status">&nbsp;&nbsp;Active</label>
								<p class="note">Uncheck to disable client.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="group">
						<form:button type="submit"
							class="btn btn-default btn-lg btn-style">Save</form:button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>