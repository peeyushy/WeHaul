<%@ include file="header.jspf"%>
<%@ include file="publicnavigation.jspf"%>

<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" id="panel">
                <h2 class="section-heading">Error!!</h2>
				<hr class="section-heading-spacer">
                <div class="clearfix"></div>
				Something went wrong! Please contact Support.<br><br>
				Exception : <c:out value="${exception}" />
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jspf"%>