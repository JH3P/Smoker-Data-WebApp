angular.module('smokerApp',['ngResource','nvd3'])
    .factory('DataService',function($resource){
        return {
            All: $resource('/smokerTrends/all'),
            Total:  $resource('/smokerTrends/total'),
            Genders: $resource('/smokerTrends/genders')
        };
    })
    .factory('DataHeadersService',function($resource){
        return {
            Genders: ["All","Male","Female"],
            Definitions:  $resource('/headers/allDefinitions'),
            Years:  $resource('/headers/allYears')
        };
    })
    .controller('AppController',['$scope', function($scope) {
    }])
    .controller('BarGraphCtrl',['$scope', 'DataService','DataHeadersService','$filter', function($scope, DataService,DataHeadersService, $filter) {
        DataService.All.get(function(data){
            var allData = $filter('optionsFilter')(data.values, "Total");
            $scope.data = [allData];
            getLeastYr();
        });


        $scope.genders= DataHeadersService.Genders;
        DataHeadersService.Definitions.get(function(data){
            $scope.definitions = data.values;
        });
        $scope.optionsChange = function() {
            if ($scope.selected_gender === "All") {
                DataService.All.get(function(data){
                    var allData = $filter('optionsFilter')(data.values, "Total", $scope.selected_definition);
                    $scope.data = [allData];
                    getLeastYr();
                });
            } else {
                DataService.All.get(function(data){
                    var genderData = $filter('optionsFilter')(data.values, $scope.selected_gender, $scope.selected_definition);
                    $scope.data = [genderData];
                    getLeastYr();
                });
            }
        };
        function getLeastYr(){
            switch($scope.selected_definition) {
                case "Definition of smoker expanded in 1996":
                    $scope.least_yr ="1984";
                    $scope.greatest_yr="1995";
                    break;
                case "Survey methods changed in 2012":
                    $scope.least_yr ="1996";
                    $scope.greatest_yr="2011";
                    break;
                case "New survey methods":
                    $scope.least_yr ="2012";
                    $scope.greatest_yr="2013";
                    break;
                default:
                    $scope.least_yr="1984";
                    $scope.greatest_yr="2013";
            }
        }
        function getGreatestYr(){

        }
        $scope.options = {
            chart: {
                type: 'discreteBarChart',
                height: 450,
                margin: {
                    top: 50,
                    right: 50,
                    bottom: 50,
                    left: 60
                },
                x: function (d) {
                    return d.year;
                },
                y: function (d) {
                    return d.percentage;
                },
                showValues: true,
                valueFormat: function (d) {
                    return d3.format()(d);
                },
                duration: 500,
                xAxis: {
                    axisLabel: 'Year'
                },
                yAxis: {
                    axisLabel: 'Percentage of Smokers'
                }
            }
        };
    }])
    .controller('PieChartCtrl',['$scope', 'DataHeadersService','DataService', '$filter',function($scope, DataHeadersService,DataService, $filter) {
        DataHeadersService.Years.get(function(data){
            $scope.years = data.values;
        });
        DataService.Genders.get(function(data){
            $scope.genData = data.values;
        });

        $scope.selected_item = "";
        $scope.selectedItemChanged = function(){
            $scope.data = $filter('getByYear')($scope.genData, $scope.selected_item);
        };

        $scope.options = {
            chart: {
                type: 'pieChart',
                height: 500,
                x: function(d){return d.gender;},
                y: function(d){return d.percentage;},
                showLabels: true,
                duration: 500,
                labelThreshold: 0.01,
                labelSunbeamLayout: true,
                legend: {
                    margin: {
                        top: 5,
                        right: 35,
                        bottom: 5,
                        left: 0
                    }
                }
            }
        };
    }])
    .filter('getByYear', function() {
        return function(input, id) {
            var i=0, len=input.length, matchArr=[],totNumResp=0, maleNum,femaleNum;
            for (; i<len; i++) {
                if (+input[i].year == +id && input[i].gender==="Male") {
                    totNumResp += +input[i].numRespondents;
                    maleNum = getGenderTotal(input[i].percentage,input[i].numRespondents);
                }else if(+input[i].year == +id && input[i].gender =="Female"){
                    totNumResp+= +input[i].numRespondents;
                    femaleNum = getGenderTotal(input[i].percentage,input[i].numRespondents);
                }
            }
            matchArr.push({"gender": "Female", "percentage": (femaleNum/totNumResp) * 100});
            matchArr.push({"gender": "Male", "percentage": (maleNum/totNumResp) * 100});
            matchArr.push({"gender": "Non-Smoker", "percentage": ((totNumResp-(femaleNum+maleNum))/totNumResp) * 100});
            return matchArr;
    };
       function getGenderTotal(percentage, total){
          return (percentage/100) * total;
       }
    })
    .filter('optionsFilter', function(){
        return function(input, gender, defn){
            var i= 0,len=input.length, matchArr = {values:[]};
            for(;i<len;i++){
                if(defn) {
                    if (input[i].gender === gender && input[i].definition === defn) {
                        matchArr.values.push(input[i]);
                    }
                }else{
                    if (input[i].gender === gender) {
                        matchArr.values.push(input[i]);
                    }
                }
            }
            return matchArr;
        };
    });