<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD6oFN8m53QEJHVAqyihDc5nRzYxktzUQI&region=GB&callback=initMap">
	
</script>
<script>
	// Initialize and add the map
	function initMap() {
		// The location of Uluru
		var uluru = {
			lat : 55.378051,
			lng : -3.435973
		};
		// The map, centered at Uluru
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 5,
			center : uluru
		});
		// The marker, positioned at Uluru
		var marker = new google.maps.Marker({
			position : uluru,
			map : map
		});
	}
</script>

<!-- Page Content -->
<div class="content-section-b">
	<div class="container">
		<div class="row">
			<div class="col-lg-12" id="panel">
				<h2 class="section-heading">Dashboard</h2>
				<hr class="section-heading-spacer">
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body" style="min-height: 400px" id="map"></div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->
</div>

<%@ include file="common/footer.jspf"%>