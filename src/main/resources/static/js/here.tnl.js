//Step 1: initialize communication with the platform
var APPLICATION_ID = 'tOIxqvcfoT98Onj4bped', APPLICATION_CODE = '-4klQLvsgr_cuqkSkYNwfw';
var AUTOCOMPLETION_URL = 'https://autocomplete.geocoder.api.here.com/6.2/suggest.json', ajaxRequest = new XMLHttpRequest(), query = '';
var COUNTRY = 'IND';
// Attach the event listeners to the XMLHttpRequest object
ajaxRequest.addEventListener("load", onAutoCompleteSuccess);
ajaxRequest.addEventListener("error", onAutoCompleteFailed);
ajaxRequest.responseType = "json";
/**
 * If the text in the text box has changed, and is not empty, send a geocoding
 * auto-completion request to the server.
 * 
 * @param {Object}
 *            textBox the textBox DOM object linked to this event
 * @param {Object}
 *            event the DOM event which fired this listener
 */
function autoCompleteListener(textBox, event) {
	if (query != textBox.value) {
		if (textBox.value.length >= 1) {
			/**
			 * A full list of available request parameters can be found in the
			 * Geocoder Autocompletion API documentation.
			 * 
			 */
			var params = '?' + 'query=' + encodeURIComponent(textBox.value)
					+ '&maxresults=10' + '&country=' + COUNTRY + '&app_id='
					+ APPLICATION_ID + '&app_code=' + APPLICATION_CODE;
			// alert(params);
			ajaxRequest.open('GET', AUTOCOMPLETION_URL + params);
			ajaxRequest.send();
		}
	}
	query = textBox.value;
}

/**
 * This is the event listener which processes the XMLHttpRequest response
 * returned from the server.
 */
function onAutoCompleteSuccess() {
	/*
	 * In this context, 'this' means the XMLHttpRequest itself.
	 */
	addSuggestionsToPanel(this.response);
}

/**
 * This function will be called if a communication error occurs during the
 * XMLHttpRequest
 */
function onAutoCompleteFailed() {
	alert('Ooops!');
}

/**
 * Format the geocoding autocompletion repsonse object's data for display
 * 
 * @param {Object}
 *            response
 */
function addSuggestionsToPanel(response) {
	var parsedJSON = JSON.parse(JSON.stringify(response, null, ' '));
	$('#reqpickuploc').autocomplete({
		source : parsedJSON.suggestions,
		select : function(event, ui) {
			// display the selected text
			$("#reqpickuploc").val(ui.item.label);
			// save selected id to hidden input
			//alert("pickuplocid:"+ui.item.locationId);
			//$("input[id=reqdetails.pickuplocid]").val(ui.item.locationId);
			$("#reqDetails\\.pickuplocid").val(ui.item.locationId);
			return false;
		}
	});
	$('#reqdroploc').autocomplete({
		source : parsedJSON.suggestions,
		select : function(event, ui) {
			// display the selected text
			$("#reqdroploc").val(ui.item.label);
			// save selected id to hidden input
			//alert("droplocid:"+ui.item.locationId);
			//$("input[id=reqdetails.droplocid]").val(ui.item.locationId);
			$("#reqDetails\\.droplocid").val(ui.item.locationId);
			return false;
		}
	});
}