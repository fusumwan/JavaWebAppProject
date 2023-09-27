/**************************************************
 // Author: Sum Wan,FU
 // Date: 7-5-2023
 // Description: app.domain.services javascript
 **************************************************/
window["app.domain.services"] = {
    BusinessIntelligence: {
        UpdateAccount: function(account) {
            var result = null;
            result = app.domain.models.account.update(account);
            return result;
        },
        SignIn: function(account) {
            account = app.domain.models.account.create(account);
            if (account != null) {
                return true;
            }
            return false;
        },
        Login: function(username, password, callback) {
            var _valid = true;

            // 如果驗證未通過，可在此處添加代碼返回或顯示錯誤消息
            if (!_valid) return;

            // 使用Fetch API發送POST請求，並使用contextPath變量
            fetch(contextPath + "/authenticateTheUser", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: `username=${username}&password=${password}`
                })
                .then(response => {
                    callback(response)
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        },
        Logout: function(callback) {
            // 使用Fetch API發送POST請求，並使用contextPath變量
            fetch(contextPath + "/logout", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: null
                })
                .then(response => {
                    callback(response)
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }
    },
    accountservice: {
        getByAccountUsernamePassword: function(username_00, password_01, Limit) {
            var result = null;
            result = app.domain.models.repositories.accountdao.getByAccountUsernamePassword(username_00, password_01, Limit);
            return result;
        },
        getByAccountUsername: function(username_01, Limit) {
            var result = null;
            result = app.domain.models.repositories.accountdao.getByAccountUsername(username_01, Limit);
            return result;
        },
        getByAccount: function(Limit) {
            var result = null;
            result = app.domain.models.repositories.accountdao.getByAccount(Limit);
            return result;
        }
    },
    bookingservice: {},
    ratingservice: {
        getByRating: function(Limit) {
            var result = null;
            result = app.domain.models.repositories.ratingdao.getByRating(Limit);
            return result;
        },
        getByRatingAccountId: function(account_id_01, Limit) {
            var result = null;
            result = app.domain.models.repositories.ratingdao.getByRatingAccountId(account_id_01, Limit);
            return result;
        }
    },
    restaurant_timeperiod_accountservice: {
        getByRestaurantTimeperiodAccount: function(Limit) {
            var result = null;
            result = app.domain.models.repositories.restaurant_timeperiod_accountdao.getByRestaurantTimeperiodAccount(Limit);
            return result;
        }
    },
    restaurantservice: {
        getByRestaurant: function(Limit) {
            var result = null;
            result = app.domain.models.repositories.restaurantdao.getByRestaurant(Limit);
            return result;
        }
    },
    tablesservice: {
        getByTablesRestaurantIdAccountId: function(restaurant_id_01, account_id_02, Limit) {
            var result = null;
            result = app.domain.models.repositories.tablesdao.getByTablesRestaurantIdAccountId(restaurant_id_01, account_id_02, Limit);
            return result;
        }
    },
    timeperiodservice: {
        getByTimeperiodAccountIdStartPeriodEndPeriod: function(start_period_01, end_period_02, account_id_03, Limit) {
            var result = null;
            result = app.domain.models.repositories.timeperioddao.getByTimeperiodAccountIdStartPeriodEndPeriod(start_period_01, end_period_02, account_id_03, Limit);
            return result;
        }
    }
}