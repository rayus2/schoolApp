/**
 * 
 */

$(document).ready(function() {
	$("#content").load("home");

	$("#logo").click(function() {
		$("#content").load("home");
		
	});
	
	$("#pelajaran").click(function() {
		$("#content").load("pelajaran/fe_list");
	});
	
	$("#siswa").click(function() {
		$("#content").load("siswa/fe_list");
	});
	
});