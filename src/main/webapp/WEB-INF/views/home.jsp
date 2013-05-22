<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Home</title>
        <script src="//code.jquery.com/jquery-2.0.0.min.js" type="text/javascript"></script>
        <script async defer>
        $(function(){
        	var deferred = null;
        	$("#submitBtn").click(function() {
        		deferred = $.ajax({url:'wait',dataType:"jsonp",crossDomain:true});
        		deferred.then(function() {
        			$("#status").text("success.");
        		},function() {
        			$("#status").text("failed/canceled.");
        		}).always(function() {
        			$("#submitBtn").show();
            		$("#cancelBtn").hide();
            		deferred = null;
        		});
        		$("#submitBtn").hide();
        		$("#status").text("pending...");
        		$("#cancelBtn").show();
        	});
        	$("#cancelBtn").click(function() {
        		if (deferred) {
        			deferred.abort();
        		}
        	});
        });
        </script>
    </head>
    <body>
       <div id="submitBtn">Go</div>
       <div id="cancelBtn" style="display:none;">Cancel<img src="https://f.cloud.github.com/assets/1291018/502039/387effd4-bca6-11e2-85e1-b6f6c89076eb.gif"></div>
       <div id="status"></div>
    </body>
</html>