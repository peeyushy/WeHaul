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
			icons : {
				time : "fa fa-clock-o",
				date : "fa fa-calendar",
				right : "fa fa-arrow-up",
				leftArrow : "fa fa-arrow-down"
			}
		});
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">
					<c:out value="${action}" />
					Load
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form:form method="post" modelAttribute="load">
					<c:set var="loadErrors">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty loadErrors}">
						<div class="row">
							<div class="col-lg-12">
								<div class="alert alert-danger alert-dismissible">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> ${loadErrors}
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="lpickuploc">Pick-Up Location</label>
								<form:input type="text" class="form-control" id="lpickuploc"
									path="lpickuploc" onFocus="geolocate()" placeholder="From"
									required="required" />
								<p class="note">This will be the source of your journey.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="ldroploc">Drop Location</label>
								<form:input type="text" path="ldroploc" class="form-control"
									id="ldroploc" onFocus="geolocate()" placeholder="To"
									required="required" />
								<p class="note">This will be the destination of your
									journey.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<form:checkbox id="lpickupdropflexi" path="lpickupdropflexi" />
								<label for="lpickupdropflexi">&nbsp;&nbsp;Flexible with
									the above Pick-up/Drop Point?</label>
								<p class="note">Flexible Pick-up/Drop point post are likely
									to hit more searches.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<label for="ltype">Load Type</label>
							<form:select class="form-control" path="ltype"
								required="required">
								<c:forEach var="ltype" items="${lTypeMap}">
									<c:choose>
										<c:when test="${fn:contains(selectedlType, ltype.key)}">
											<option value="${ltype.key}" selected="selected">
												${ltype.value}</option>
										</c:when>
										<c:otherwise>
											<option value="${ltype.key}">${ltype.value}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</form:select>
							<p class="note">Define your load, this will help us in
								getting you the best vehicle for this load.</p>
						</div>

						<div class="col-lg-6">
							<div class="form-group">
								<label for="lassistance">Load Assistance</label>								
								<form:select class="form-control" path="lassistance">
									<option>Select</option>
									<c:choose>
										<c:when test="${load.lassistance}">
											<option selected="selected">Yes</option>
											<option>No</option>
										</c:when>
										<c:otherwise>
											<option>Yes</option>
											<option selected="selected">No</option>
										</c:otherwise>
									</c:choose>									
								</form:select>
								<p class="note">Load assistance means you are agreeing to
									help in loading and unloading.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<div class="control-group">
									<label class="control-label">Date Time</label>
									<div class='input-group date' id='datetimepicker1'>
										<form:input type='text' class="form-control" path="ldatetime"
											id="ldatetime" required="required"
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
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<div class="form-group">
									<form:checkbox id="ldatetimeflexi" path="ldatetimeflexi" />
									<label for="flexidays">&nbsp;&nbsp;Flexible with the
										above date and Time?</label>
									<p class="note">Post will be dispalyed for +/- 3 days
										searches, gives you more visibility.</p>
								</div>
							</div>
						</div>
					</div>
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
						<div class="col-lg-12">
							<div class="form-group">
								<form:input type="hidden" path="status" value="DISABLED" />
								<form:checkbox path="status" value="ACTIVE" />
								<label for="status">&nbsp;&nbsp;Active</label>
								<p class="note">Uncheck to disable load.</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-8">
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