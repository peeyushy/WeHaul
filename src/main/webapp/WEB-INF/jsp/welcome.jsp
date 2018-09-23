<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12" id="panel">
				<h2 class="section-heading">Welcome <c:out value="${name}" />!!</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
				<form>
					<div class="form-group">
						<label for="email">Full Name</label> <input class="form-control"
							id="name" name="name" type="text">
					</div>

					<div class="form-group">
						<label for="email">Email</label> <input class="form-control"
							id="Email" name="Email" type="text">
					</div>

					<div class="form-group">
						<label for="email">Mobile No</label> <input class="form-control"
							id="MobileNo" name="MobileNo" type="text">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>