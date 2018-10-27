<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">
					<c:out value="${action}" />
					Vehicle
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form:form method="post" modelAttribute="vehicle">
					<c:set var="vehicleErrors">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty vehicleErrors}">
						<div class="row">
							<div class="col-lg-12">
								<div class="alert alert-danger alert-dismissible">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> ${vehicleErrors}
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="regno">Registration Number (Number Plate)</label>
								<form:input class="form-control" id="regno" name="regno"
									path="regno" type="text" required="required" />
								<p class="note">This is your vehicle's registration no. For
									e.g. TY12 YYX</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="vtype">Vehicle Type</label>
								<form:select class="form-control" name="vtype" path="vtype"
									required="required">
									<c:forEach var="vtype" items="${vTypeMap}">
										<option value="${vtype.key}"
											${vtype.key == selectedvType ? 'selected="selected"' : ''}>${vtype.value}</option>
									</c:forEach>
								</form:select>
								<p class="note">Define your vehicle type. This will help us
									in getting you the best load for this vehicle.</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="ltype">Load Type</label>
								<form:select class="form-control" name="ltype" path="ltype"
									required="required">
									<c:forEach var="ltype" items="${lTypeMap}">										
										<c:choose>
											<c:when
												test="${fn:contains(selectedlType, ltype.key)}">
												<option value="${ltype.key}" selected="selected">
													${ltype.value}</option>
											</c:when>
											<c:otherwise>
												<option value="${ltype.key}">${ltype.value}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</form:select>
								<p class="note">Define how your vehicle can be used. This
									will help us in getting you the best load for this vehicle.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="opcost">Operational Cost (£)</label>
								<form:input class="form-control" name="opcost" path="opcost"
									type="text" />
								<p class="note">
									This is the total operational cost of your vehicle per month.<a
										href="#"> Calculate</a>
								</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<form:input type="hidden" name="status" path="status"
									value="DISABLED" />
								<form:checkbox name="status" path="status" value="ACTIVE" />
								<label for="status">&nbsp;&nbsp;Active</label>
								<p class="note">Uncheck to disable vehicle.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Select Photo</label> <input type="file" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="group">
								<a href="/edit-client?cid=${cid}"
									class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
								<form:button type="submit"
									class="btn btn-default btn-lg btn-style">Save</form:button>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>