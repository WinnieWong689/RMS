$(document).ready(function() {
	
	$('#checkbox-all').click(function() {
		$('input[name="user-selector"]').prop("checked", $(this).prop("checked"));
		updateDeleteBtnStatus();
	});
	
	$('#js-delete-confirm').click(function() {
		var selections = $('input[name="user-selector"]:checked');
		var ids = "";
		for (var i=0; i<selections.length-1; i++) {
			ids += $(selections[i]).val() + ",";
		}
		ids += $(selections[i]).val();
		$.ajax({
			type: "post",
			url: "/rms/user/delete",
			data: {
				ids: ids
			},
			success: function(data){
				if (data.result) {
					window.location.href = "/rms/user";
				}
			},
			complete: function() {
				$('#del-confirm-modal').modal('hide');
			}
		});
	});
	
	$('input[name="user-selector"]').click(function() {
		updateDeleteBtnStatus();
	});
	
	$('#btn-search').click(function() {
		
	});
	
	function updateDeleteBtnStatus() {
		var selections = $('input[name="user-selector"]:checked');
		if (selections.length > 0) {
			$('#js-delete-btn').prop("disabled", false);
		} else {
			$('#js-delete-btn').prop("disabled", true);
		}
	}
})