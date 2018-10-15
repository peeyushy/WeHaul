<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2 class="section-heading">
					<c:out value="${action}" />
					Vehicle
				</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form>
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Registration Number (Number Plate)</label> <input
									class="form-control" id="user_login" name="user[login]"
									type="text" />
								<p class="note">This is your vehicle's registration no. For
									e.g. TY12 YYX</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Vehicle Type</label> <select
									class="form-control">
									<option selected>White Van</option>
									<option>12f Flatbed</option>
									<option>18f Flatbed</option>
									<option>26f Flatbed</option>
									<option>Refrigerated Containers</option>
									<option>Other</option>
								</select>
								<p class="note">Define your vehicle type. This will help us
									in getting you the best load for this vehicle.</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Load Type</label> <select
									class="selectpicker form-control" multiple
									data-actions-box="true">
									<option selected>Small Boxes</option>
									<option>Furniture</option>
									<option>Housemove</option>
									<option>Construction Material Only</option>
									<option>Liquids Only</option>
									<option>Heavy Equipments Only</option>
									<option>Pets Only</option>
									<option>Cars</option>
									<option>Motorcycles</option>
									<option>Other Vehicles</option>
									<option>Beverages</option>
									<option>Other</option>
								</select>
								<p class="note">Define how your vehicle can be used. This
									will help us in getting you the best load for this vehicle.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Dimensions (H/W/L)</label> <input
									class="form-control" id="orgridecost" name="orgridecost"
									type="text" />
								<p class="note">
									This is available space in the vehicle. <a href="#"> Size
										Guide</a>
								</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Capacity/Payload</label> <input
									class="form-control" id="orgridecost" name="orgridecost"
									type="text" />
								<p class="note">This is the maximum payload vehicle can
									take. i.e 9 People or 1800Kg.</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="email">Operational Cost (£)</label> <input
									class="form-control" id="orgridecost" name="orgridecost"
									type="text" />
								<p class="note">
									This is the total operational cost of your vehicle per month.<a
										href="#"> Calculate</a>
								</p>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<label for="email">Select Photo</label> <input type="file" />
							</div>
						</div>
					</div>

					<div class="row" id="savebuttondiv">
						<div class="col-lg-8">
							<div class="group">
								<a href="/edit-client?cid=${cid}"
									class="btn btn-default btn-lg btn-style">&larr; Back</a>&nbsp;
								<a href="/add-vehicle?cid=${cid}"
									class="btn btn-default btn-lg btn-style">Save</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>