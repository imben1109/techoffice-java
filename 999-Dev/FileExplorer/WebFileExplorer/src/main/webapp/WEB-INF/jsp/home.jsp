<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
	<style>
		.meta{
			display: none;
		}
	</style>
    <script src="webjars/jquery/3.1.0/jquery.min.js"></script>
    <script>
    	$(function(){
			function goToPath(){
    			var pathValue = $("#path").val();
	    		$.ajax({
	    			url: '/fileExplorer/list',
	    			data: {parent: pathValue},
	    			success: function(response){
	    				var ul = $("<ul></ul>")
	    				var files = response;
	    				for (var i=0; i<files.length; i++){
	    					var file = files[i];
	    					var li = $("<li></li>");
	    					var fileDiv = $("<div class='fileCell'></div>");
	    					var filenameSpan = $("<span class='filename'></span>");
	    					var fileMetaSpan = $("<span class='meta'></span>");
	    					var fileMetaTypeSpan = $("<span class='meta_type'></span>");
	    					fileMetaTypeSpan.html(file.type);
	    					fileMetaSpan.append(fileMetaTypeSpan);
	    					filenameSpan.html(file.name);
	    					fileDiv.append(filenameSpan);
	    					fileDiv.append(fileMetaSpan);
	    					li.append(fileDiv);
	    					ul.append(li);
	    				}
	    				$("#fileList").html(ul);
	    	    		$(".fileCell").click(function(event){
	    	    			var clicked = event.currentTarget;
	    	    			var selectedFile = clicked.getElementsByClassName("filename")[0].innerHTML;
	    	    			var selectedFileType = clicked.getElementsByClassName("meta_type")[0].innerHTML;
	    	    			if (selectedFileType == 'FOLDER'){
	    	    				var path = $("#path");
	    	    				var newPath = path.val();
	    	    				if (newPath != "/"){
	    	    					var newPath = newPath + "/" + selectedFile;	
	    	    				}else {
	    	    					var newPath = newPath + selectedFile;
	    	    				}
		    	    			path.val(newPath);
		    	    			goToPath();	
	    	    			}
	    	    		});
	    			}
	    		});
			}
			
			$("#goBtn").click(function(){
				goToPath();	
			});
			
			$('#path').keyup(function(e){
			    if(e.keyCode == 13){
			    	goToPath();	    
			    }
			});

			// default
			goToPath();
    	});
    </script>
<title>Insert title here</title>
</head>
<body>
	<div>
		Path<input id="path" value="."/><button id="goBtn">Go</button>
	</div>
	<div id="fileList"></div>
</body>
</html>