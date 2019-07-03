<%@page import="com.wehaul.constants.ReqStatus"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">Booking Details</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-hover" id="tablediv">
					<tbody>
						<tr>
							<td>Need</td>
							<td>${bookingDetails.reqType}</td>
						</tr>
						<tr>
							<td>When</td>
							<td><fmt:parseDate value="${bookingDetails.reqDateTime}"
									pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
								<fmt:formatDate pattern="dd/MM/yyyy HH:mm"
									value="${parsedDateTime}" /></td>
						</tr>
						<tr>
							<td>Source</td>
							<td>${bookingDetails.reqPickupLoc}</td>
						</tr>
						<tr>
							<td>Destination</td>
							<td>${bookingDetails.reqDropLoc}</td>
						</tr>
						<tr>
							<td>Load Type</td>
							<td>${bookingDetails.lType}</td>
						</tr>
						<tr>
							<td>Vehicle Type</td>
							<td>${bookingDetails.vType}</td>
						</tr>
						<tr>
							<td>Original Comment</td>
							<td>${bookingDetails.reqComment}</td>
						</tr>
						<tr>
							<td>Quote (Rs.)</td>
							<td>${bookingDetails.quote}</td>
						</tr>
						<tr>
							<td>From</td>
							<td>${bookingDetails.quoteOwner}</td>
						</tr>
						<tr>
							<td>Comment</td>
							<td>${bookingDetails.quoteComment}</td>
						</tr>
						<security:authorize access="hasAnyAuthority('ADMIN')">
							<tr>
								<td>Contact</td>
								<td>${bookingDetails.quoteContact}</td>
							</tr>
							<tr>
								<td>Received On</td>
								<td><fmt:parseDate
										value="${bookingDetails.quoteReceivedDateTime}"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedQuoteRecvDateTime"
										type="both" /> <fmt:formatDate pattern="dd/MM/yyyy HH:mm"
										value="${parsedQuoteRecvDateTime}" /></td>
							</tr>
						</security:authorize>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="form-group">
					<a href="/home" class="btn btn-default btn-lg btn-style">&larr;
						Back</a>&nbsp; <a href="/home"
						class="btn btn-default btn-lg btn-style">Confirm</a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="common/footer.jspf"%>