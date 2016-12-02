(function() {
	for(var i=500;i<520;i++) {
	$EXEC(curl -i -H"status:$i" http://192.168.99.100:8080/statustest/resources/statuses);
	console.log($OUT);
	}
};))();
