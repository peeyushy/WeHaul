<%@page import="com.wehaul.constants.ReqStatus"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/publicnavigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">Send Quote</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<form:form method="post" modelAttribute="requirement"
			accept-charset="UTF-8">
			<div class="row">
				<div class="col-lg-12">
					<c:set var="sendQuotesErrors">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty sendQuotesErrors}">
						<div class="row">
							<div class="col-lg-12">
								<div class="alert alert-danger alert-dismissible">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> ${sendQuotesErrors}
								</div>
							</div>
						</div>
					</c:if>
					<table class="table table-hover" id="tablediv">
						<tbody>
							<tr>
								<td>Need</td>
								<td>${requirement.reqtype}</td>
							</tr>
							<tr>
								<td>Date Time</td>
								<td><fmt:parseDate value="${requirement.reqdatetime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
									<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedDateTime}" /></td>
							</tr>
							<tr>
								<td>Source</td>
								<td>${requirement.reqpickuploc}</td>
							</tr>
							<tr>
								<td>Destination</td>
								<td>${requirement.reqdroploc}</td>
							</tr>
							<tr>
								<td>Load Type</td>
								<td>${requirement.ltype}</td>
							</tr>
							<tr>
								<td>Vehicle Type</td>
								<td>${requirement.vtype}</td>
							</tr>
							<tr>
								<td>Owner's Comment</td>
								<td>${requirement.reqComment}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<div class="form-group">
						<label for="quote">Quote (Rs.)</label>
						<form:input class="form-control" id="quote" type="number"
							path="quote" required="required" placeholder="Rs." />
						<p class="note">Please add/update your quote for this
							requirement.</p>
					</div>

				</div>
				<div class="col-lg-6">
					<div class="form-group">
						<label for="comments">Comments</label>
						<form:textarea class="form-control" rows="2" id="comments"
							path="clientComment" placeholder="Leave a comment" />
						<p class="note">Please add additional comments, this will help
							us understand your quote better.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="group">
						<c:choose>
							<c:when test="${not empty cid}">
								<c:url value="${pageContext.request.contextPath}/noauth"
									var="url">
									<c:param name="cid" value="${cid}" />
								</c:url>
								<a href="${url}" class="btn btn-default btn-lg btn-style">&larr;
									Back</a>&nbsp;
  									</c:when>
						</c:choose>
						<form:button type="submit"
							class="btn btn-default btn-lg btn-style">Send</form:button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="../common/footer.jspf"%>