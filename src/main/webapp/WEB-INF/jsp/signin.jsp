<%@ include file="common/header.jspf"%>
<%@ include file="common/publicnavigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">Sign In</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<form name='f' action="/login" method='POST'>
					<c:if test="${param.error}">
						<div class="alert alert-danger">Invalid username or
							password.</div>
					</c:if>
					<c:if test="${param.logout}">
						<div class="alert alert-info">You have been logged out.</div>
					</c:if>
					<div class="form-group">
						<label for="username">User Name</label> <input
							class="form-control" id="username" name="username"
							required="required" type="text">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input class="form-control"
							id="password" name="password" type="password" required="required">
					</div>
					<div class="group">
						<button type="submit" class="btn btn-primary btn-sm btn-style">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</div>

<%@ include file="common/footer.jspf"%>