'use strict';

textAppp.controller('formController', function ($scope, $http) {
	$scope.arrayOfCars = 

		[
		{
		    "id": 1,
		    "project": "we2012",
		    "date": "2013-01-26",
		},

		{
		    "id": 2,
		    "project": "wewe2013",
		    "date": "2014-02-26",
		},

		{
		    "id": 3,
		    "project": "wewe2014",
		    "date": "2015-02-26",
		},

		{
		    "id": null,
		    "project": "wewe2015",
		    "date": "2016-02-26",
		},

		{
		    "id": null,
		    "project": "wewe20163",
		    "date": "2016-08-26",
		},

		{
		    "id": 6,
		    "project": "wewe20153",
		    "date": "2016-07-26",
		},

		{
		    "id": null,
		    "project": "wewe20103",
		    "date": "2016-06-26",
		},

		{
		    "id": 8,
		    "project": "wewe20103",
		    "date": "2016-06-26",
		},
		{
		    "id": null,
		    "project": "wewe20103",
		    "date": "2016-06-26",
		}
		];

	
	$scope.processForm = function(isValid) {
		var address = $scope.posting.city;
		$scope.submitted = true;
		if (!isValid) {
		      alert('correct Form errors');
	    }
		
	  $http({ 
	  method  : 'POST',
	  url     : '/texts',
	  data    : $.param($scope.posting),  // pass in data as strings
	  headers : { 'Content-Type': 'application/x-www-form-urlencoded'}  // set the headers so angular passing info as form data (not request payload)
	 })
	  .then(function(response) {
		  console.log(response);
		// if successful, bind success message to message
	      $scope.responseStatusText = response.statustext;
	      $scope.responseData = response.data;
	      $scope.responseDatatext = response.data.text;
	      $scope.FullResponse = response;
	      $scope.dataPassedAsString = $.param($scope.greeting);
	      $scope.formValues= $scope.posting;
	    
	  },   function(error) {
	          //Second function handles error
	         $scope.contentent = "Something went wrong";
	         $scope.errorName = response.status + error;
	                  
	      });
	   
	      // if not successful, bind errors to error variables
	     	   
	  };
	  
	 

});







