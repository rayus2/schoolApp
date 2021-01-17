/**
 * 
 */

$(document).ready(function() {
	
	$("#logo").click(function() {
		$("#content").load("home");
	});

	$("#pelajaran").on("click", function() {
		var url = $(this).attr("href");
		var current = window.history.pushState(null, null,"pelajaran/fe_list")
		$.ajax({
			url: url+current,
			success: function(response){
				$("#content").html(response);
			}
		})
	});

	$("#siswa").click(function() {
		var url = $(this).attr("href");
		var current = window.history.pushState(null, null,"siswa/fe_list")
		$.ajax({
			url: url+current,
			success: function(response){
				$("#content").load("siswa/fe_list");
			}
		})
		
	});

	$("#nilai_siswa").click(function() {
		$("#content").load("nilai_siswa");
	});

});