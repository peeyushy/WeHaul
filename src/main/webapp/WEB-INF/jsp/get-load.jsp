<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD6oFN8m53QEJHVAqyihDc5nRzYxktzUQI&libraries=places&callback=initAutocomplete"
	async defer></script>
<script type="text/javascript">
	$(document).ready(function() {
		//basic is working need to get old dates disable,icons, add today date etc.
		$('#datetimepicker1').datetimepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			todayBtn : true,
			minView: 2,//gets date only format drop time selection
			fontAwesome: true
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
			<div class="col-lg-8">
				<div class="row">
					<div class="col-md-12"></div>
				</div>
			</div>

			<div class="col-lg-4 col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="media">
							<form:form method="post" modelAttribute="load">
								<div class="media-body">
									<h5>
										<strong>Pick-Up Location</strong>
									</h5>
									<form:input type="text" class="form-control" id="lpickuploc"
										path="lpickuploc" onFocus="geolocate()" placeholder="From" />
									<h5>
										<strong>Drop Location</strong>
									</h5>
									<form:input type="text" path="ldroploc" class="form-control"
										id="ldroploc" onFocus="geolocate()" placeholder="To"
										required="required" />
									<h5>
										<strong>Date</strong>
									</h5>
									<div class='input-group date' id='datetimepicker1'>
										<form:input type='text' class="form-control" path="ldatetime"
											id="ldatetime" required="required" placeholder="DD/MM/YYYY"
											onkeypress="return false;" />
										<span class="input-group-addon"> <span
											class="fa fa-calendar"></span>
										</span>
									</div>
									<h5>
										<strong>Load Type</strong>
									</h5>
									<form:select class="form-control" path="ltype">
										<option>Select</option>
										<c:forEach var="ltype" items="${lTypeMap}">
											<option value="${ltype.key}">${ltype.value}</option>
										</c:forEach>
									</form:select>
									<h5>
										<strong>Load Assistance</strong>
									</h5>
									<form:select class="form-control" path="lassistance">
										<option>Select</option>
										<option>Yes</option>
										<option>No</option>
									</form:select>									
									<h5>
										<strong>Vehicle Type</strong>
									</h5>
									<form:select class="form-control" path="ltype">
										<option>Select</option>
										<c:forEach var="ltype" items="${lTypeMap}">
											<option value="${ltype.key}">${ltype.value}</option>
										</c:forEach>
									</form:select>
									<hr>
									<div class="btn-group btn-group-xs">
										<a href="./get-load-results.html"
											class="btn btn-default btn-lg"><span class="btn-style">search</span></a>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>







<%@ include file="common/footer.jspf"%>