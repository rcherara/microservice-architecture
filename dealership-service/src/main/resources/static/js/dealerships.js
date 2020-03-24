angular.module('dealerships', ['ngResource', 'ui.bootstrap']).
    factory('Dealership', function ($resource) {
        return $resource('dealerships');
    }).
    factory('Dealership', function ($resource) {
        return $resource('dealership/:id', {id: '@id'});
    }).
    factory("EditorStatus", function () {
        var editorEnabled = {};

        var enable = function (id, fieldName) {
            editorEnabled = { 'id': id, 'fieldName': fieldName };
        };

        var disable = function () {
            editorEnabled = {};
        };

        var isEnabled = function(id, fieldName) {
            return (editorEnabled['id'] == id && editorEnabled['fieldName'] == fieldName);
        };

        return {
            isEnabled: isEnabled,
            enable: enable,
            disable: disable
        }
    });

function dealershipsController($scope, $modal, dealerships, dealership, Status) {
    function list() {
        $scope.dealerships = dealerships.query();
    }

    function clone (obj) {
        return JSON.parse(JSON.stringify(obj));
    }

    function savedealership(dealership) {
        dealerships.save(dealership,
            function () {
                Status.success("Dealership saved");
                list();
            },
            function (result) {
                Status.error("Error saving Dealership: " + result.status);
            }
        );
    }

    $scope.adddealership = function () {
        var addModal = $modal.open({
            templateUrl: 'templates/dealershipForm.html',
            controller: dealershipModalController,
            resolve: {
                dealership: function () {
                    return {};
                },
                action: function() {
                    return 'add';
                }
            }
        });

        addModal.result.then(function (dealership) {
            savedealership(dealership);
        });
    };

    $scope.updatedealership = function (dealership) {
        var updateModal = $modal.open({
            templateUrl: 'templates/dealershipForm.html',
            controller: dealershipModalController,
            resolve: {
                dealership: function() {
                    return clone(dealership);
                },
                action: function() {
                    return 'update';
                }
            }
        });

        updateModal.result.then(function (dealership) {
            savedealership(dealership);
        });
    };

    $scope.deletedealership = function (dealership) {
        dealership.delete({id: dealership.id},
            function () {
                Status.success("Dealership deleted");
                list();
            },
            function (result) {
                Status.error("Error deleting dealership: " + result.status);
            }
        );
    };

    $scope.setdealershipsView = function (viewName) {
        $scope.dealershipsView = "templates/" + viewName + ".html";
    };

    $scope.init = function() {
        list();
        $scope.setdealershipsView("grid");
        $scope.sortField = "name";
        $scope.sortDescending = false;
    };
}

function dealershipModalController($scope, $modalInstance, dealership, action) {
    $scope.dealershipAction = action;
    $scope.yearPattern = /^[1-2]\d{3}$/;
    $scope.dealership = dealership;

    $scope.ok = function () {
        $modalInstance.close($scope.dealership);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
};

function dealershipEditorController($scope, dealerships, Status, EditorStatus) {
    $scope.enableEditor = function (dealership, fieldName) {
        $scope.newFieldValue = dealership[fieldName];
        EditorStatus.enable(dealership.id, fieldName);
    };

    $scope.disableEditor = function () {
        EditorStatus.disable();
    };

    $scope.isEditorEnabled = function (dealership, fieldName) {
        return EditorStatus.isEnabled(dealership.id, fieldName);
    };

    $scope.save = function (dealership, fieldName) {
        if ($scope.newFieldValue === "") {
            return false;
        }

        dealership[fieldName] = $scope.newFieldValue;

        dealerships.save({}, dealership,
            function () {
                Status.success("Dealership saved");
                list();
            },
            function (result) {
                Status.error("Error saving Dealership: " + result.status);
            }
        );

        $scope.disableEditor();
    };

    $scope.disableEditor();
}

angular.module('dealerships').
    directive('inPlaceEdit', function () {
        return {
            restrict: 'E',
            transclude: true,
            replace: true,

            scope: {
                ipeFieldName: '@fieldName',
                ipeInputType: '@inputType',
                ipeInputClass: '@inputClass',
                ipePattern: '@pattern',
                ipeModel: '=model'
            },

            template:
                '<div>' +
                    '<span ng-hide="isEditorEnabled(ipeModel, ipeFieldName)" ng-click="enableEditor(ipeModel, ipeFieldName)">' +
                        '<span ng-transclude></span>' +
                    '</span>' +
                    '<span ng-show="isEditorEnabled(ipeModel, ipeFieldName)">' +
                        '<div class="input-append">' +
                            '<input type="{{ipeInputType}}" name="{{ipeFieldName}}" class="{{ipeInputClass}}" ' +
                                'ng-required ng-pattern="{{ipePattern}}" ng-model="newFieldValue" ' +
                                'ui-keyup="{enter: \'save(ipeModel, ipeFieldName)\', esc: \'disableEditor()\'}"/>' +
                            '<div class="btn-group btn-group-xs" role="toolbar">' +
                                '<button ng-click="save(ipeModel, ipeFieldName)" type="button" class="btn"><span class="glyphicon glyphicon-ok"></span></button>' +
                                '<button ng-click="disableEditor()" type="button" class="btn"><span class="glyphicon glyphicon-remove"></span></button>' +
                            '</div>' +
                        '</div>' +
                    '</span>' +
                '</div>',

            controller: 'DealershipEditorController'
        };
    });
