$(document).ready(function() {
	
	$('#checkbox-all').click(function() {
		$('input[name="user-selector"]').prop("checked", $(this).prop("checked"));		
	});
})