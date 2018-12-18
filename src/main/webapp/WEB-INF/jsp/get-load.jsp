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
			//minView : 2,//gets date only format drop time selection
			fontAwesome : true
		});

		$('#datetimepicker2').datetimepicker({
			format : 'dd/mm/yyyy hh:ii',
			autoclose : true,
			todayBtn : true,
			//minView : 2,//gets date only format drop time selection
			fontAwesome : true
		});
	});
</script>
<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">Get Load</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<form:form method="post" modelAttribute="loadSearchOptionsDto">
				<div class="col-lg-8">
					<c:set var="getloadErrors">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty getloadErrors}">
						<div class="row">
							<div class="col-lg-12">
								<div class="alert alert-danger alert-dismissible">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> ${getloadErrors}
								</div>
							</div>
						</div>
					</c:if>
					<div class="row">
						<c:forEach items="${LoadSearchResults}" var="load">

							<div class="col-md-6">
								<div class="card">
									<div class="card-image">
										<img class="img-responsive" src="/img/18122018.jpg"> <span
											class="card-title">${load.lpickuploc} - ${load.ldroploc}</span>
									</div>

									<div class="card-content">
										<div class="row" style="text-align: justify">
											<div class="col-xs-6" data-toggle="tooltip"
												data-placement="left"
												title="Load type">
												${load.ltype.ltypename}</div>
											<div class="col-xs-6" data-toggle="tooltip"
												data-placement="left" title="Travel date and time.">
												<span class="pull-right"><i class="fa fa-calendar"></i>
													${load.ldatetime}</span>
											</div>
										</div>
										<!--<hr style="margin: 10px 0"/>-->
									</div>

									<div class="card-action" style="min-height: 60px">
										<div class="row">
											<div class="col-xs-4" data-toggle="tooltip"
												data-placement="left"
												title="Cost of this load is further negotiable.">
												<span class="pull-left badge">£ 700</span>
											</div>
											<div class="col-xs-8">
												<div class="pull-right btn-group btn-group-xs">
													<button
														onclick="window.location.href='./vehicle-details.html'"
														type="button" class="btn btn-success"
														data-toggle="tooltip"
														data-placement="left"
														title="Click to get the details of this load.">DETAILS</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>

				<div class="col-lg-4 col-md-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="media">
								<div class="media-body">
									<h5>
										<strong>Pick-Up Location</strong>
									</h5>
									<form:input type="text" class="form-control" id="lpickuploc"
										path="load.lpickuploc" onFocus="geolocate()"
										placeholder="From" />
									<h5>
										<strong>Drop Location</strong>
									</h5>
									<form:input type="text" path="load.ldroploc"
										class="form-control" id="ldroploc" onFocus="geolocate()"
										placeholder="To" />
									<h5>
										<strong>Date Range Start</strong>
									</h5>
									<div class='input-group date' id='datetimepicker1'>
										<form:input type='text' class="form-control"
											path="ldatetime_start" id="ldatetime_start"
											placeholder="DD/MM/YYYY HH:MM" onkeypress="return false;" />
										<span class="input-group-addon"> <span
											class="fa fa-calendar"></span>
										</span>
									</div>
									<h5>
										<strong>Date Range End</strong>
									</h5>
									<div class='input-group date' id='datetimepicker2'>
										<form:input type='text' class="form-control"
											path="ldatetime_end" id="ldatetime_end"
											placeholder="DD/MM/YYYY HH:MM" onkeypress="return false;" />
										<span class="input-group-addon"> <span
											class="fa fa-calendar"></span>
										</span>
									</div>
									<h5>
										<strong>Vehicle Type</strong>
									</h5>
									<form:select class="form-control" path="vehicle.vtype">
										<option>Select</option>
										<c:forEach var="vtype" items="${vTypeMap}">											
											<option value="${vtype.key}"
											${vtype.key == selectedvType ? 'selected="selected"' : ''}>${vtype.value}</option>
										</c:forEach>
									</form:select>
									<hr>
									<div class="btn-group btn-group-sm">
										<form:button type="submit"
											class="btn btn-default btn-lg btn-style">search</form:button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>