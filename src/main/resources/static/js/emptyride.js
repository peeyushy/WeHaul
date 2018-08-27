var placeSearch, autocomplete_from, autocomplete_to;
var componentForm = {
street_number: 'short_name',
route: 'long_name',
locality: 'long_name',
administrative_area_level_1: 'short_name',
country: 'long_name',
postal_code: 'short_name'
};

function initAutocomplete() {
// Create the autocomplete_from object, restricting the search to geographical
// location types.
autocomplete_from = new google.maps.places.Autocomplete(
	/** @type {!HTMLInputElement} */(document.getElementById('autocomplete_from')),
	{types: ['geocode']});
	
autocomplete_to = new google.maps.places.Autocomplete(
	/** @type {!HTMLInputElement} */(document.getElementById('autocomplete_to')),
	{types: ['geocode']});

// When the user selects an address from the dropdown, populate the address
// fields in the form.
autocomplete_from.addListener('place_changed', fillInAddress);
autocomplete_to.addListener('place_changed', fillInAddress);
}

function fillInAddress() {
// Get the place details from the autocomplete_from object.
var place_from = autocomplete_from.getPlace();
var place_to = autocomplete_to.getPlace();

for (var component in componentForm) {
  document.getElementById(component).value = '';
  document.getElementById(component).disabled = false;
}

// Get each component of the address from the place details
// and fill the corresponding field on the form.
for (var i = 0; i < place_from.address_components.length; i++) {
  var addressType = place_from.address_components[i].types[0];
  if (componentForm[addressType]) {
	var val = place_from.address_components[i][componentForm[addressType]];
	document.getElementById(addressType).value = val;
	}
}

for (var i = 0; i < place_to.address_components.length; i++) {
  var addressType = place_to.address_components[i].types[0];
  if (componentForm[addressType]) {
	var val = place_to.address_components[i][componentForm[addressType]];
	document.getElementById(addressType).value = val;
	}
}
}

// Bias the autocomplete_from object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
if (navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(function(position) {
	var geolocation = {
	  lat: position.coords.latitude,
	  lng: position.coords.longitude
	};
	var circle = new google.maps.Circle({
	  center: geolocation,
	  radius: position.coords.accuracy
	});
	autocomplete_from.setBounds(circle.getBounds());
	autocomplete_to.setBounds(circle.getBounds());
  });
}
}		