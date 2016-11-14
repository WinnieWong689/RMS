$(document).ready(function() {
	
	$('#checkbox-all').click(function() {
		$('input[name="selector"]').prop("checked", $(this).prop("checked"));
		updateDeleteBtnStatus();
	});
	
	$('#js-delete-confirm').click(function() {
		var selections = $('input[name="selector"]:checked');
		var ids = "";
		for (var i=0; i<selections.length-1; i++) {
			ids += $(selections[i]).val() + ",";
		}
		ids += $(selections[i]).val();
		$.ajax({
			type: "post",
			url: "/rms/risk/delete",
			data: {
				ids: ids
			},
			success: function(data){
				if (data.result) {
					window.location.href = "/rms/risk/risk_list/" + $('#project-id').val();
				}
			},
			complete: function() {
				$('#del-confirm-modal').modal('hide');
			}
		});
	});
	
	$('input[name="selector"]').click(function() {
		updateDeleteBtnStatus();
	});
	
	function updateDeleteBtnStatus() {
		var selections = $('input[name="selector"]:checked');
		if (selections.length > 0) {
			$('#js-delete-btn').prop("disabled", false);
		} else {
			$('#js-delete-btn').prop("disabled", true);
		}
	}
})