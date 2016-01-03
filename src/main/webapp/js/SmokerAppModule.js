angular.module('smokerApp',['ngResource','nvd3'])
    .factory('AllDataService',function($resource, $q){
        return $resource('/smokerTrends/all');
    })
    .factory('TotalDataService', function($resource){
        return $resource('/smokerTrends/total');
    })
    .factory('GenderDataService',function($resource){
        return $resource('/smokerTrends/genders');
    })
    .factory('YearService', function($resource){
        return $resource('/smokerTrends/allYears')
    })
    .controller('AppController',['$scope', function($scope) {
        $scope.allData = TotalDataService.get();
    }])
    .controller('BarGraphCtrl',['$scope', 'TotalDataService', function($scope, TotalDataService) {
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
        TotalDataService.get(function(data){
            $scope.data = [data];
        });
    }])
    .controller('PieChartCtrl',['$scope', 'GenderDataService','YearService', '$filter',function($scope, GenderDataService, YearService, $filter) {
        YearService.get(function(data){
            $scope.years = data.values;
        });
        GenderDataService.get(function(data){
            $scope.genData = data.values;
        });

        $scope.selected_item = "";
        $scope.selectedItemChanged = function(){
            var found = $filter('getByYear')($scope.genData, $scope.selected_item);
            $scope.data = found;
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
       };
});