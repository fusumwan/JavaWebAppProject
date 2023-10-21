window["app.domain.services"]={
	BusinessIntelligence:{
        UpdateAccount:function(account){
            var result = null;
            result=app.domain.models.account.update(account);
            return result;
        },
        SignIn:function(account){
            account=app.domain.models.account.create(account);
            if (account!=null){
                return true;
            }
            return false;
        },
        Login:function(username,password, callback){
            var method = "POST";
            var data = {
                username: username,
                password: password
            };
            var url = window.contextPath + "/authenticateTheUser";
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                data: JSON.stringify(data), // Convert the JavaScript object into a JSON string
                headers: app.domain.utils.JWT.headers("JSON"),
                async: false,
                success: function(response) {
                    response=app.domain.utils.JWT.json_callback_process_jwt(response);
                    callback(response);
                },
                error: function(xhr, status, error) {
                    console.error("Status: ", status);
                    console.error("Error: ", error);
                    console.error("Response: ", xhr.responseText);
                }
            });
        },
        LoginWithOutJWT:function(username,password, callback){
            var method = "POST";
            var data = {
                username: username,
                password: password
            };
            var url = window.contextPath + "/authenticateTheUser";
            $.ajax({
                url: url,
                type: method,
                dataType: "json",
                contentType: "application/json", // Specify the data type being sent
                data: JSON.stringify(data), // Convert the JavaScript object into a JSON string
                async: false,
                success: function(response) {
                    callback(response);
                },
                error: function(xhr, status, error) {
                    console.error("Status: ", status);
                    console.error("Error: ", error);
                    console.error("Response: ", xhr.responseText);
                }
            });
        },
        Logout:function(callback){
            // Send POST request using Fetch API and use contextPath variable
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
	accountservice:{
        getByAccountUsernamePassword:function(username_00,password_01,Limit){
            var result = null;
            result=app.domain.models.repositories.accountdao.getByAccountUsernamePassword(username_00,password_01,Limit);
            return result;
        }
		,
        getByAccountUsername:function(username_00,Limit){
            var result = null;
            result=app.domain.models.repositories.accountdao.getByAccountUsername(username_00,Limit);
            return result;
        }
	},
	subject_sentenceservice:{
	}
}
