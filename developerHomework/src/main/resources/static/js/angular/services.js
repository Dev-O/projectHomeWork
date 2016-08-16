'use strict';

WeatherApp.factory('DataExchange', function () {
    var service = {};

	var x = 420;
	var y = 540;
	service.getData = function() {
		return x + y;
		};
	
    return service;
});

WeatherApp.factory('DataExchange2', function () {
	   var service2 = {};
		var x = 10;
		var y = 45;
		service2.getData = function() {
			return x + y;
		};
		
	    return service2;
});


WeatherApp.factory('DataExchange3', function () {
	 var service3 = {};
	    
		var x = 200;
		var y = 440;
		service3.getData = function() {
			return x + y;
			};	
			
	    return service3;
});