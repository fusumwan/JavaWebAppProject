window["app.domain.models"] = {
    uuidv4:function () {
		return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
			var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
			return v.toString(16);
		});
	},
	create:function(table,json_data){
		var _result=null;
		if(table!=undefined && json_data!=undefined){
			var fieldNames = Object.keys(json_data);
			var formData = new FormData();
	        // add other form fields
	        formData.append("_method", "PUT"); // Simulate a PUT request
	        for(var i=0;i<fieldNames.length; i++ ){
				formData.append(fieldNames[i], json_data[fieldNames[i]]);
			}
			var method = "POST";
		    var tableName = table;
		    var CreateMethod = "create";
            var url = "";
	        if (app.runat != "" && app.runat != undefined) {
				url += app.runat;
			}
			if (tableName != "" && tableName!= undefined) {
				url += "/" + tableName + "/" + CreateMethod;
			}

	        $.ajax({
	            url: url,
	            type: method,
	            dataType: "json",
	            data: formData,
	            processData: false,
	            contentType: false,
                headers: app.domain.utils.JWT.headers("FORMDATA"),
	            async: false,
	            success: function(data) {
                	data=app.domain.utils.JWT.json_process_jwt(data);  
					_result=data;
	            },
	            error: function(xhr, status, error) {
	                console.log(xhr.responseText);
	            }
	        });
        }
		return _result;
	},
    get:function(table,datakeyname,id){
		var _result=null;
		if(app.runat!=undefined && table!=undefined){
			
			var formData = new FormData();
	        // add other form fields
	        formData.append("_method", "PUT"); // Simulate a PUT request
	        formData.append(datakeyname, id);
			var method = "POST";
		    var tableName = table;
		    var GetMethod = "get";
			
            var url = "";
	        if (app.runat != "" && app.runat != undefined) {
				url += app.runat;
			}
			if (tableName != "" && tableName!= undefined) {
				url += "/" + tableName + "/" + GetMethod;
			}

	        $.ajax({
	            url: url,
	            type: method,
	            dataType: "json",
	            data: formData,
	            processData: false,
	            contentType: false,
                headers: app.domain.utils.JWT.headers("FORMDATA"),
	            async: false,
	            success: function(data) {
                	data=app.domain.utils.JWT.json_process_jwt(data);
					_result=data;
	            },
	            error: function(xhr, status, error) {
	                console.log(xhr.responseText);
	            }
	        });
        }
		return _result;
	},
    update:function(table,json_data){
		var _result=null;
		if(table!=undefined && json_data!=undefined){
			var fieldNames = Object.keys(json_data);
			var formData = new FormData();
	        // add other form fields
	        formData.append("_method", "PUT"); // Simulate a PUT request
	        for(var i=0;i<fieldNames.length; i++ ){
				formData.append(fieldNames[i], json_data[fieldNames[i]]);
			}
			var method = "POST";
		    var tableName = table;
		    var UpdateMethod = "update";
            var url = "";
            if (app.runat != "" && app.runat != undefined) {
				url += app.runat;
			}
            if (tableName != "" && tableName!= undefined) {
                url += "/" + tableName + "/" + UpdateMethod;
            }

	        $.ajax({
	            url: url,
	            type: method,
	            dataType: "json",
	            data: formData,
	            processData: false,
	            contentType: false,
                headers: app.domain.utils.JWT.headers("FORMDATA"),
	            async: false,
	            success: function(data) {
                	data=app.domain.utils.JWT.json_process_jwt(data);
					_result=data;
	            },
	            error: function(xhr, status, error) {
	                console.log(xhr.responseText);
	            }
	        });
        }
		return _result;
	},
    delete:function(table,datakeyname,id){
		var _result=false;
		if(table!=undefined && datakeyname!=undefined && id!=undefined){
			var formData = new FormData();
	        // add other form fields
	        formData.append("_method", "PUT"); // Simulate a PUT request
	        formData.append(datakeyname, id);
			var method = "POST";
		    var tableName = table;
		    var DeleteMethod = "delete";

            var url = "";
            if (app.runat != "" && app.runat != undefined) {
				url += app.runat;
			}
            if (tableName != "" && tableName!= undefined) {
                url += "/" + tableName + "/" + DeleteMethod;
            }
	        $.ajax({
	            url: url,
	            type: method,
	            dataType: "json",
	            data: formData,
	            processData: false,
	            contentType: false,
                headers: app.domain.utils.JWT.headers("FORMDATA"),
	            async: false,
	            success: function(data) {
					data=app.domain.utils.JWT.json_process_jwt(data);
					_result=true;
	            },
	            error: function(xhr, status, error) {
					_result=false;
	                console.log(xhr.responseText);
	            }
	        });
        }
		return _result;
	},
    mapInputTypes:[
    {
        "TableName": "account",
        "Fields": [
            {
                "FieldName": "account_id",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "first_name",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "last_name",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "username",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "email",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "contact_number",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "password",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "user_type",
                "HtmlInputType": "text"
            }
        ]
    },
    {
        "TableName": "subject_sentence",
        "Fields": [
            {
                "FieldName": "subject_sentence_id",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "situation",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "event",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "sentence_type",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "article_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "subject_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "conjunction_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "adverb_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "auxiliary_verb_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "verb_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "infinitive_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "conjunction_02",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "adverb_02",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "preposition_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "pronoun_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "article_02",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "adjective_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "noun_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "noun_phase_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "gerund_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "preposition_02",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "clause_01",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "full_sentence",
                "HtmlInputType": "text"
            },
            {
                "FieldName": "traditional_chinese",
                "HtmlInputType": "text"
            }
        ]
    }
]
        ,
	account: {
		new: function() {
			var obj = {
			"account_id": null,
			"first_name": ""
			,
			"last_name": ""
			,
			"username": ""
			,
			"email": ""
			,
			"contact_number": ""
			,
			"password": ""
			,
			"user_type": "" };
			return obj;
		},
		create: function(data) {
			return app.domain.models.create("account", data);
		},
		get: function(id) {
			return app.domain.models.get("account","account_id", id);
		},
		update: function(data) {
			return app.domain.models.update("account", data);
		},
		delete: function(id) {
			return app.domain.models.delete("account","account_id", id);
		}
	},
	subject_sentence: {
		new: function() {
			var obj = {
			"subject_sentence_id": null,
			"situation": ""
			,
			"event": ""
			,
			"sentence_type": ""
			,
			"article_01": ""
			,
			"subject_01": ""
			,
			"conjunction_01": ""
			,
			"adverb_01": ""
			,
			"auxiliary_verb_01": ""
			,
			"verb_01": ""
			,
			"infinitive_01": ""
			,
			"conjunction_02": ""
			,
			"adverb_02": ""
			,
			"preposition_01": ""
			,
			"pronoun_01": ""
			,
			"article_02": ""
			,
			"adjective_01": ""
			,
			"noun_01": ""
			,
			"noun_phase_01": ""
			,
			"gerund_01": ""
			,
			"preposition_02": ""
			,
			"clause_01": ""
			,
			"full_sentence": ""
			,
			"traditional_chinese": "" };
			return obj;
		},
		create: function(data) {
			return app.domain.models.create("subject_sentence", data);
		},
		get: function(id) {
			return app.domain.models.get("subject_sentence","subject_sentence_id", id);
		},
		update: function(data) {
			return app.domain.models.update("subject_sentence", data);
		},
		delete: function(id) {
			return app.domain.models.delete("subject_sentence","subject_sentence_id", id);
		}
	}
};
