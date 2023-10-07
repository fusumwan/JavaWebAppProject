/**************************************************
 // Author: Sum Wan,FU
 // Date: 7-5-2023
 // Description: app.domain.utils
 **************************************************/

window["app.domain.utils"] = {
    CalendarToDBDateFormat: function(value) {
        values = value.split('/');
        var _value = "";
        if (values.length == 0) {
            return value;
        }
        for (var i = values.length - 1; i >= 0; i--) {
            if (_value != "") {
                _value += "-";
            }
            _value += values[i];
        }
        return _value;
    },
    DBDateFormatToCalendar: function(value) {
        values = value.split('-');
        var _value = "";
        if (values.length == 0) {
            return value;
        }
        for (var i = values.length - 1; i >= 0; i--) {
            if (_value != "") {
                _value += "/";
            }
            _value += values[i];
        }
        return _value;
    },
    SetCookie: function(user_session_name, value, expiry_date) {
        var _GMT = new Date();
        _GMT.setTime(_GMT.getTime() + (expiry_date * 24 * 60 * 60 * 1000));
        var _expires = "expires=" + _GMT.toGMTString();
        if (window.contextPath!=undefined){
            document.cookie = user_session_name + "=" + value + ";" + _expires + ";path="+window.contextPath;
        }else{
            document.cookie = user_session_name + "=" + value + ";" + _expires + ";";
        }
    },
    DelCookie: function(user_session_name) {
        console.log("Deleting cookie: " + user_session_name);
        document.cookie = user_session_name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    },
    GetCookie: function(user_session_name) {
        var _user_session_name = user_session_name + "=";
        var _decoded_cookie = decodeURIComponent(document.cookie);
        var ca = _decoded_cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(_user_session_name) == 0) {
                return c.substring(_user_session_name.length, c.length);
            }
        }
        return "";
    },
    SessionToCookie: function(user_session_name,user_session) {
        if (user_session != undefined) {
            if (user_session.account_id != "" && user_session.account_id != undefined) {
                var user = JSON.stringify(user_session);
                this.SetCookie(user_session_name, JSON.stringify(user_session), 30);
                return user;
            } else {
                return "";
            }
        }
    },
    SetUserSession:function(usersession){
        var method="POST";
        var _result = null;
        if (window.contextPath==undefined){return _result}
        var url = window.contextPath + "/usersession/set_usersession";
        $.ajax({
            type: method,
            url: url,
            dataType: "json",
            data: JSON.stringify(usersession), // Convert user session object to string
            contentType: "application/json", // Set content type to JSON
            headers: app.domain.utils.JWT.headers("JSON"),
            async: false,
            success: function(data) {
                data=app.domain.utils.JWT.json_process_jwt(data);
                _result = data;
            },
            error: function(xhr, status, error) {
                console.error("Status: ", status);
                console.error("Error: ", error);
                console.error("Response: ", xhr.responseText);
            }
        });
        return _result;
    },
    GetUserSession: function() {
        var method="GET";
        var _result = null;
        if (window.contextPath==undefined){return _result}
        var url = window.contextPath + "/usersession/get_usersession";
        $.ajax({
            type: method,
            url: url,
            dataType: "json",
            headers: app.domain.utils.JWT.headers("JSON"),
            async: false, // Make the request synchronous
            success: function(data) {
                if (data != undefined && data != "") {
                    try {
                        data=app.domain.utils.JWT.json_process_jwt(data);
                        _result = data;
                    } catch (e) {
                        console.error("Failed to parse JSON response:", e);
                    }
                }
            },
            error: function(xhr, status, error) {
                console.error("Error:", error);
            }
        });

        return _result;
    },
    EmptyPageSession: function() {
        var page_session = {
            "index": {
                "reserve_date": "",
                "person": "",
                "numbers":[]
            },
            "login": "",
            "signup": "",
            "restaurant_manage":{
                "person":""
            },
            "manage_booking": "",
            "confirm_booking": "",
            "accountInfo": "",
            "map": {
                "tables": "",
                "reserve_date": ""
            },
            "result": {
                "tables": "",
                "reserve_date": ""
            },
            "numbers":[],
            "orders":[]
            
        };
        return page_session;
    },
    GetPageSession: function() {
        var method="GET";
        var _result = null;
        if (window.contextPath==undefined){return _result}
        var url = window.contextPath + "/usersession/get_pagesession";
        $.ajax({
            type: method,
            url: url,
            dataType: "json",
            headers: app.domain.utils.JWT.headers("JSON"),
            async: false, // Make the request synchronous
            success: function(data) {
                if (data != undefined && data != "") {
                    try {
                        data=app.domain.utils.JWT.json_process_jwt(data);
                        _result = data;
                    } catch (e) {
                        console.error("Failed to parse JSON response:", e);
                    }
                }
            },
            error: function(xhr, status, error) {
                console.error("Status: ", status);
                console.error("Error: ", error);
                console.error("Response: ", xhr.responseText);
            }
        });

        return _result;
    },
    SetPageSession: function(page_session) {
        var method="POST";
        var _result = null;
        if (window.contextPath==undefined){return _result}
        var url = window.contextPath + "/usersession/set_pagesession";
        $.ajax({
            url: url,
            type: method,
            dataType: "json",
            data: JSON.stringify(page_session), // Convert user session object to string
            contentType: "application/json", // Set content type to JSON
            headers: app.domain.utils.JWT.headers("JSON"),
            async: false,
            success: function(data) {
                data=app.domain.utils.JWT.json_process_jwt(data);
                _result = data;
            },
            error: function(xhr, status, error) {
                console.error("Status: ", status);
                console.error("Error: ", error);
                console.error("Response: ", xhr.responseText);
            }
        });
        return _result;
    },
    DelPageSession: function() {
        var page_session = this.PageSession();
        var empty_session = this.EmptyPageSession();
        var This = this;
        var _session = {
            index: function() {
                page_session.index = {
                    "reserve_date": "",
                    "person": ""
                };
                return This.SetPageSession(page_session);
            },
            login: function() {
                page_session.login = "";
                return This.SetPageSession(page_session);
            },
            signup: function() {
                page_session.signup = "";
                return This.SetPageSession(page_session);
            },
            restaurant_manage: function() {
                page_session.restaurant_manage = "";
                return This.SetPageSession(page_session);
            },
            manage_booking: function() {
                page_session.manage_booking = "";
                return This.SetPageSession(page_session);
            },
            confirm_booking: function() {
                page_session.confirm_booking = "";
                return This.SetPageSession(page_session);
            },
            accountInfo: function() {
                page_session.accountInfo = "";
                return This.SetPageSession(page_session);
            },
            map: function() {
                page_session.map = {
                    "tables": "",
                    "reserve_date": ""
                };
                return This.SetPageSession(page_session);
            },
            result: function() {
                page_session.result = {
                    "tables": "",
                    "reserve_date": ""
                };
                return This.SetPageSession(page_session);
            },
            all: function() {
                return This.SetPageSession(empty_session);
            }
        };
        return _session;
    },
    UTFEncode: function(value) {
        value = value.replace(/\r\n/g, "\n");
        var str = "";
        for (var n = 0; n < value.length; n++) {
            var c = value.charCodeAt(n);
            if (c < 128) {
                str += String.fromCharCode(c);
            } else if ((c > 127) && (c < 2048)) {
                str += String.fromCharCode((c >> 6) | 192);
                str += String.fromCharCode((c & 63) | 128);
            } else {
                str += String.fromCharCode((c >> 12) | 224);
                str += String.fromCharCode(((c >> 6) & 63) | 128);
                str += String.fromCharCode((c & 63) | 128);
            }
        }
        return str;
    },
    UTFDecode: function(value) {
        var str = "";
        var i = 0;
        var c = c1 = c2 = 0;
        while (i < value.length) {
            c = value.charCodeAt(i);
            if (c < 128) {
                str += String.fromCharCode(c);
                i++;
            } else if ((c > 191) && (c < 224)) {
                c2 = value.charCodeAt(i + 1);
                str += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = value.charCodeAt(i + 1);
                c3 = value.charCodeAt(i + 2);
                str += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return str;
    },
    EncodeOrDecodeKey: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
    Encode: function(value) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;
        value = this.UTFEncode(value);
        while (i < value.length) {
            chr1 = value.charCodeAt(i++);
            chr2 = value.charCodeAt(i++);
            chr3 = value.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
                this.EncodeOrDecodeKey.charAt(enc1) + this.EncodeOrDecodeKey.charAt(enc2) +
                this.EncodeOrDecodeKey.charAt(enc3) + this.EncodeOrDecodeKey.charAt(enc4);
        }
        return output;
    },
    Decode: function(value) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;
        value = value.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < value.length) {
            enc1 = this.EncodeOrDecodeKey.indexOf(value.charAt(i++));
            enc2 = this.EncodeOrDecodeKey.indexOf(value.charAt(i++));
            enc3 = this.EncodeOrDecodeKey.indexOf(value.charAt(i++));
            enc4 = this.EncodeOrDecodeKey.indexOf(value.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = this.UTFDecode(output);
        return output;
    },
    SqlToHQLService: {
        parseValue: function(input) {
            if (/^-?\d+$/.test(input)) {
                return parseInt(input, 10);
            } else {
                return input.replace(/^'|'$/g, '');
            }
        },
        extractBetweenConditions: function(sql) {
            const betweenConditions = [];

            return betweenConditions;
        },
        SqlBetweenKeyWordProcess: function(sql) {

            return sql;
        },
        conditionprocess: function(condition) {
            let result = {
                ColumnName: "",
                Operator: "",
                Value: []
            };

            
            return result;
        },
        SqlToHQLJSON: function(sql) {
            
            return {
                "hql": "",
                "dataValues": []
            };
        }
    },
    TextUtils: {
        capitalizeFirstWord: function(word) {
            let result = "";
            if (word) {
                if (word.includes("_")) {
                    let words = word.split("_");
                    for (let w of words) {
                        if (w.length > 0) {
                            result += w[0].toUpperCase() + w.slice(1);
                        }
                    }
                } else {
                    if (word.length > 0) {
                        result += word[0].toUpperCase() + word.slice(1);
                    }
                }
            }
            return result;
        },
        uncapitalizeFirstWord: function(word) {
            let result = "";
            if (word) {
                if (word.includes("_")) {
                    let words = word.split("_");
                    for (let w of words) {
                        if (w.length > 0) {
                            result += w[0].toLowerCase() + w.slice(1);
                        }
                    }
                } else {
                    if (word.length > 0) {
                        result += word[0].toLowerCase() + word.slice(1);
                    }
                }
            }
            return result;
        }
    },
    BCryptPasswordEncoder: {
        Encode: function(value) {
			var bcrypt = dcodeIO.bcrypt;
            // A loop that generates a salt and uses it 10 times
            const salt = bcrypt.genSaltSync(10);
            // Use salt to encrypt value
            const hashedValue = bcrypt.hashSync(value, salt);
            return hashedValue;
        }
    },
    Date:{
		formatConvert:function(date, inputPattern, outputPattern) {
		    const dateParts = date.split(/[-T:/. ]/);  // Adjusted the regex to include 'T' and ':'
		    let day, month, year, hour = 0, minute = 0, second = 0;
		    inputPattern.split(/[-T:/. ]/).forEach((pattern, index) => {  // Adjusted the regex to include 'T' and ':'
		        switch (pattern) {
		            case "dd":
		                day = parseInt(dateParts[index], 10);
		                break;
		            case "MM":
		                month = parseInt(dateParts[index], 10);
		                break;
		            case "yyyy":
		                year = parseInt(dateParts[index], 10);
		                break;
		            case "HH":
		                hour = parseInt(dateParts[index], 10);
		                break;
		            case "mm":
		                minute = parseInt(dateParts[index], 10);
		                break;
		            case "ss":
		                second = parseInt(dateParts[index], 10);
		                break;
		        }
		    });
		
		    const dateObj = new Date(year, month - 1, day, hour, minute, second);
		
		    // Format date based on output mode
		    return outputPattern.replace(/dd|MM|yyyy|HH|mm|ss/g, match => {
		        switch (match) {
		            case "dd":
		                return String(dateObj.getDate()).padStart(2, '0');
		            case "MM":
		                return String(dateObj.getMonth() + 1).padStart(2, '0');
		            case "yyyy":
		                return dateObj.getFullYear();
		            case "HH":
		                return String(dateObj.getHours()).padStart(2, '0');
		            case "mm":
		                return String(dateObj.getMinutes()).padStart(2, '0');
		            case "ss":
		                return String(dateObj.getSeconds()).padStart(2, '0');
		        }
		    });
		},
        now(){
		    const now = new Date();
		
		    const yyyy = now.getFullYear();
		    const MM = String(now.getMonth() + 1).padStart(2, '0'); // January is 0!
		    const dd = String(now.getDate()).padStart(2, '0');
		    const HH = String(now.getHours()).padStart(2, '0');
		    const mm = String(now.getMinutes()).padStart(2, '0');
		    const ss = String(now.getSeconds()).padStart(2, '0');
		
		    return `${yyyy}-${MM}-${dd} ${HH}:${mm}:${ss}`;
		},
		moment(){
			return moment().format('YYYY-MM-DD HH:mm:ss');
		}
	},
    Value:{
		isNumeric:function(str) {
		  if (typeof str != "string") return false // we only process strings!  
		  return !isNaN(str) && // use type coercion to parse the _entirety_ of the string (`parseFloat` alone does not do this)...
		         !isNaN(parseFloat(str)) // ...and ensure strings of whitespace fail
		}
	},
    JWT:{
		headers:function(content_type){
			var h={};
			if (window.app.jwt.enable==true){
				if(content_type=="JSON"){
					// If content_type is JSON that mean your data is JSON need to data: JSON.stringify(data)
					h={
						"Content-Type": "application/json",
					    "Authorization": localStorage.getItem('jwtToken')
					}
				}else{
					// If content_type is formData that mean your data is var formData = new FormData() no need to set Content-Type
					h={
					    "Authorization": localStorage.getItem('jwtToken')
					}
				}
			}
			return h;
		},
		json_process_jwt:function(jsonData){
            var data="";
            if(jsonData!="" && jsonData!=null && jsonData!=undefined){
                console.log(jsonData);
                if (window.app.jwt.enable==true){
                    jsonData=JSON.parse(jsonData);
                    // Store the token
                    localStorage.setItem('jwtToken', jsonData.token);
                    if(jsonData.data!="" && jsonData.data!=null && jsonData.data!=undefined){
                        data=JSON.parse(jsonData.data);
                    }
                    return data;
                }else{
                    data=JSON.parse(jsonData);
                    return data;
                }
            }
            return data;
        },
        json_callback_process_jwt:function(jsonData){
            var data="";
            if(jsonData!="" && jsonData!=null && jsonData!=undefined){
                console.log(jsonData);
                if (window.app.jwt.enable==true){
                    jsonData=JSON.parse(jsonData);
                    // Store the token
                    localStorage.setItem('jwtToken', jsonData.token);
                    return jsonData;
                }else{
                    data=JSON.parse(jsonData);
                    return data;
                }
            }
            return data;
        }
    }
}
