'use strict';

textAppp.controller('formController', function ($scope, $http) {
	$scope.arrayOfUsers = [{"id":1, "first_name":"Heather", "last_name":"Bell", "hobby":"Eating"},
	                       
	                      {"id":2,"first_name":"Andrea","last_name":"Dean","hobby":"Gaming"},
	                      
	                      {"id":3,"first_name":"Peter","last_name":"Barnes" ,"hobby":"Reading Books"},
	                      
	                      {"id":4,"first_name":"Harry", "last_name":"Bell" , "hobby":"Youtubing"},
	                      
	                      {"id":5,"first_name":"Deborah","last_name":"Burns","hobby":"Fishing"},
	                      
	                      { "id":6, "first_name":"Larry", "last_name":"Kim", "hobby":"Skipping"},
                          
	                      {"id":7, "first_name":"Jason","last_name":"Wallace","hobby":"Football"},
	                      
	                      {"id":8,"first_name":"xHeather","last_name":"ell","hobby":"sating"},
	                       
	                      {"id":9,"first_name":"omdr","last_name":"Sean","hobby":"Gaming"},
	                      {"id":10,"first_name":"weter","last_name":"Barnes","hobby":"seading Books"},

	                      {"id":11,"first_name":"zdrea","last_name":"Dean","hobby":"caming"},
	                     
	                      {"id":12,"first_name":"ieter","last_name":"Barnes","hobby":"Booking"},
	                     	                      
	                      {"id":13,"first_name":"garry","last_name":"Tell","hobby":"tytubing"},
	                     	                      
	                      {"id":14,"first_name":"Deborah","last_name":"Burns","hobby":"lishing"},
	                     	                      
	                      {"id":15,"first_name":"Larry","last_name":"rim","hobby":"Skipping"}
	                      
	                     ];
	                      
	                      
	                      

	
	                      $scope.sort = function(keyname){
	                          $scope.sortKey = keyname;   //set the sortKey to the param passed
	                          $scope.reverse = !$scope.reverse; //if true make it false and vice versa
	                      };
	
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







