<%@page import="com.wehaul.constants.ReqStatus"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#table_quotes').DataTable({
					"bLengthChange" : false,
					"bFilter" : false,
					"order" : [ [ 1, "asc" ] ]
				});
				//need to get old dates disable, check why minutes is not set as 00 etc.
				$("#datetimepicker1").datetimepicker({
					minView : 1,
					format : "dd/mm/yyyy hh:ii",
					autoclose : true,
					todayBtn : true,
					todayHighlight : 1,
					fontAwesome : true
				});
				
 				/* $("#datetimepicker1").datetimepicker().on("changeDate",function(e) {
					var datetimepicker1 = new Date(e.date.setMinutes(0));
					//timezone correction
					datetimepicker1.setHours(datetimepicker1.getHours()+ datetimepicker1.getTimezoneOffset() / 60);
					alert("reqdatetime::" + datetimepicker1)
					alert("1--->"+$("#datetimepicker1"));
					$("#datetimepicker1").val("abbc");
					alert("2--->"+$("#reqdatetime"));
					$("#reqdatetime").val("xyzz");
					alert("3--->"+$("#date input[type=text]").val());
					$("#date input[type=text]").val("text here");
					alert("4--->"+$("#date").children(":input").val());
					$("#date").children(":input").val("ddtext here");					
					//$("#second").datetimepicker('setStartDate', first); 
					//other = $("#first").find("input").val(); 
					//$("#second").datetimepicker('setStartDate', other); //works also
				}); */
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
								<label for="type">Need</label>
								<form:select class="form-control" name="reqtype" path="reqtype">
									<form:options items="${reqTypeMap}" />
								</form:select>
								<p class="note">Please specify your need.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<div class="control-group">
									<label class="control-label">When</label>
									<div class="input-group date"
										id="datetimepicker1">
										<form:input type="text" class="form-control"
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
								<label for="reqpickuploc">Source</label>
								<form:input type="text" class="form-control autocomplete"
									id="reqpickuploc" path="reqpickuploc"
									onkeyup="return autoCompleteListener(this, event);"
									placeholder="From" required="required" />
								<form:input type="hidden" id="reqDetails.pickuplocid"
									path="reqDetails.pickuplocid" />
								<p class="note">This will be the source of your journey.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="reqdroploc">Destination</label>
								<form:input type="text" class="form-control autocomplete"
									id="reqdroploc" path="reqdroploc"
									onkeyup="return autoCompleteListener(this, event);"
									placeholder="To" required="required" />
								<form:input type="hidden" id="reqDetails.droplocid"
									path="reqDetails.droplocid" />
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
								<p class="note">Define your load type. This will help us in
									getting you the best vehicle for this load.</p>
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
									with the above Source/Destination Point?</label>
								<p class="note">Flexible Source/Destination point post are likely
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
								<p class="note">Please add any additional comments that
									defines your need, this will help us in understanding your
									requirement better.</p>
							</div>
						</div>
					</div>
					<c:if test="${fn:length(quotes) gt 0}">
						<hr>
						<div class="row">
							<div class="col-lg-12">
								<table id="table_quotes" class="display responsive nowrap"
									style="width: 100%">
									<caption>
										Table 1: <i>Available quotes for the requirement.</i>
									</caption>
									<thead>
										<tr>
											<th>From</th>
											<th>Quote (Rs.)</th>
											<th>Comments</th>
											<security:authorize access="hasAnyAuthority('ADMIN')">
												<th>Contact No</th>
												<th>Received On</th>
											</security:authorize>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${quotes}" var="q">
											<tr>
												<td>${q.qOwnerName}</td>
												<td>${q.quote}</td>
												<td>${q.qComment}</td>
												<security:authorize access="hasAnyAuthority('ADMIN')">
													<td>${q.qOwnerContactNo}</td>
													<td><fmt:parseDate value="${q.qDatetime}"
															pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
															type="both" /> <fmt:formatDate
															pattern="dd/MM/yyyy HH:mm" value="${parsedDateTime}" /></td>
												</security:authorize>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
					<div class="row">
						<div class="col-lg-12">
							<div class="group">
								<c:choose>
									<c:when test="${not empty cid}">
										<a href="edit-client?cid=${cid}"
											class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
  									</c:when>
									<c:otherwise>
										<a href="req" class="btn btn-default btn-lg btn-style">&larr;
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