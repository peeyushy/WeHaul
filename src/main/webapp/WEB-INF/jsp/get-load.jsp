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

		$('#table_LoadSearchResults').DataTable();
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
				<div class="col-lg-3">
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
										<strong>Start Date</strong>
									</h5>
									<div class='input-group date' id='datetimepicker1'>
										<form:input type='text' class="form-control"
											path="ldatetime_start" id="ldatetime_start"
											placeholder="dd/mm/yyyy hh:mm" onkeypress="return false;" />
										<span class="input-group-addon"> <span
											class="fa fa-calendar"></span>
										</span>
									</div>
									<h5>
										<strong>End Date</strong>
									</h5>
									<div class='input-group date' id='datetimepicker2'>
										<form:input type='text' class="form-control"
											path="ldatetime_end" id="ldatetime_end"
											placeholder="dd/mm/yyyy hh:mm" onkeypress="return false;" />
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

			<div class="col-lg-9">
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

					<table id="table_LoadSearchResults" class="display">
						<thead>
							<tr>
								<th>Load ID</th>
								<th>Pick-Up Location</th>
								<th>Drop Location</th>
								<th>Load Type</th>
								<!-- <th>Load Assistance</th> -->
								<th>Date Time</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${LoadSearchResults}" var="load">
								<tr>
									<td>${load.lid}</td>
									<td>${load.lpickuploc}</td>
									<td>${load.ldroploc}</td>
									<td>${load.ltype.ltypename}</td>
									<%-- <td>${load.lassistance}</td> --%>
									<td>
									<fmt:parseDate value="${load.ldatetime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
											value="${parsedDateTime}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>