<%@ include file="header.jspf"%>
<%@ include file="navigation.jspf"%>

<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" id="panel">
                <h2 class="section-heading">Error!!</h2>
				<hr class="section-heading-spacer">
                <div class="clearfix"></div>
				Something went wrong! please contact support.<br><br>
				Status Code : <c:out value="${status}" /> <br>
				Error Message : <c:out value="${error}" />
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jspf"%>