/**************************************************
 // Author: Sum Wan,FU
 // Date: 7-5-2023
 // Description: app.domain.models.repositories javascript
 **************************************************/
window["app.domain.models.repositories"] = {
    accountdao: {
        getByAccountUsernamePassword: function(username_00, password_01, Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("username_00", username_00);
            formData.append("password_01", password_01);
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "account";
            var getMethod = "getByAccountUsernamePassword";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        },
        getByAccountUsername: function(username_01, Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("username_01", username_01);
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "account";
            var getMethod = "getByAccountUsername";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        },
        getByAccount: function(Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "account";
            var getMethod = "getByAccount";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    },
    bookingdao: {},
    ratingdao: {
        getByRating: function(Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "rating";
            var getMethod = "getByRating";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        },
        getByRatingAccountId: function(account_id_01, Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("account_id_01", account_id_01);
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "rating";
            var getMethod = "getByRatingAccountId";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    },
    restaurant_timeperiod_accountdao: {
        getByRestaurantTimeperiodAccount: function(Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "restaurant_timeperiod_account";
            var getMethod = "getByRestaurantTimeperiodAccount";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    },
    restaurantdao: {
        getByRestaurant: function(Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "restaurant";
            var getMethod = "getByRestaurant";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    },
    tablesdao: {
        getByTablesRestaurantIdAccountId: function(restaurant_id_01, account_id_02, Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("restaurant_id_01", restaurant_id_01);
            formData.append("account_id_02", account_id_02);
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "tables";
            var getMethod = "getByTablesRestaurantIdAccountId";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    },
    timeperioddao: {
        getByTimeperiodAccountIdStartPeriodEndPeriod: function(start_period_01, end_period_02, account_id_03, Limit) {
            var formData = new FormData();
            // add other form fields
            formData.append("_method", "PUT"); // Simulate a PUT request
            formData.append("start_period_01", start_period_01);
            formData.append("end_period_02", end_period_02);
            formData.append("account_id_03", account_id_03);
            formData.append("Limit", Limit);

            var method = "POST";
            var tableName = "timeperiod";
            var getMethod = "getByTimeperiodAccountIdStartPeriodEndPeriod";
            var result = null;
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
                url += app.runat;
            }
            if (tableName != "" && tableName != undefined) {
                url += "/" + tableName + "/" + getMethod;
            }
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: formData,
                processData: false,
                contentType: false,
                async: false,
                success: function(data) {
                    console.log(data);
                    result = JSON.parse(data);
                },
                error: function(xhr, status, error) {
                    alert('An error occurred while loading the ' + tableName);
                    console.log(xhr.responseText);
                }
            });
            return result;
        }
    }
}