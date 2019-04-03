<%@page import="com.wehaul.constants.ReqStatus"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD6oFN8m53QEJHVAqyihDc5nRzYxktzUQI&libraries=places&callback=initAutocomplete"
	async defer></script>
<script type="text/javascript">
	$(document).ready(function() {
		//basic is working need to get old dates disable,icons, add today date etc.
		$('#datetimepicker1').datetimepicker({
			format : 'dd/mm/yyyy hh:ii',
			autoclose : true,
			todayBtn : true,
			fontAwesome : true
		});
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">
					<c:out value="${action}" />
					Requirement
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form:form method="post" modelAttribute="requirement">
					<c:set var="requirementErrors">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty requirementErrors}">
						<div class="row">
							<div class="col-lg-12">
								<div class="alert alert-danger alert-dismissible">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> ${requirementErrors}
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="type">Type</label>
								<form:select class="form-control" name="reqtype" path="reqtype">
									<form:options items="${reqTypeMap}" />
								</form:select>
								<p class="note">Please choose requirement type.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<div class="control-group">
									<label class="control-label">Date Time</label>
									<div class='input-group date' id='datetimepicker1'>
										<form:input type='text' class="form-control"
											path="reqdatetime" id="reqdatetime" required="required"
											placeholder="DD/MM/YYYY hh:mm" onkeypress="return false;" />
										<span class="input-group-addon"> <span
											class="fa fa-calendar"></span>
										</span>
									</div>
								</div>
								<p class="note">This will be the date and time of your
									journey.</p>
							</div>
						</div>
					</div>
					<%-- <div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:checkbox id="reqdatetimeflexi" path="reqdatetimeflexi" />
								<label for="reqdatetimeflexi">&nbsp;&nbsp;Flexible with
									the above date and Time?</label>
								<p class="note">Post will be dispalyed for +/- 3 days
									searches, gives you more visibility.</p>
							</div>
						</div>
					</div> --%>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="reqpickuploc">Pick-Up</label>
								<form:input type="text" class="form-control" id="reqpickuploc"
									path="reqpickuploc" onFocus="geolocate()" placeholder="From"
									required="required" />
								<p class="note">This will be the source of your journey.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="reqdroploc">Drop</label>
								<form:input type="text" path="reqdroploc" class="form-control"
									id="reqdroploc" onFocus="geolocate()" placeholder="To"
									required="required" />
								<p class="note">This will be the destination of your
									journey.</p>
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
										<option value="${ltype.key}"
											${ltype.key == selectedlType ? 'selected="selected"' : ''}>${ltype.value}</option>
									</c:forEach>
								</form:select>
								<p class="note">Define how your vehicle can be used. This
									will help us in getting you the best load for this vehicle.</p>
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

					<%-- <div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:checkbox id="reqpickupdropflexi" path="reqpickupdropflexi" />
								<label for="reqpickupdropflexi">&nbsp;&nbsp;Flexible
									with the above Pick-up/Drop Point?</label>
								<p class="note">Flexible Pick-up/Drop point post are likely
									to hit more searches.</p>
							</div>
						</div>
					</div> --%>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<label for="comments">Comments</label>
								<form:textarea class="form-control" rows="5" id="comments"
									path="comments" />
							</div>
							<p class="note">Please add any additional comments that
								defines your load, this will help transporter in understanding
								your requirements better.</p>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-8">
							<div class="group">
								<c:choose>
									<c:when test="${not empty cid}">
										<a href="/edit-client?cid=${cid}"
											class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
  									</c:when>
									<c:otherwise>
										<a href="/req" class="btn btn-default btn-lg btn-style">&larr;
											Back</a>&nbsp;
									</c:otherwise>
								</c:choose>
								<c:set var="newreq" value="<%=ReqStatus.NEW.getStatus()%>" />
								<c:choose>
									<c:when test="${requirement.status == newreq}">
										<form:button type="submit"
											class="btn btn-default btn-lg btn-style">Save</form:button>
									</c:when>
									<c:otherwise>										
										<c:out value="${requirement.status}" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="common/footer.jspf"%>