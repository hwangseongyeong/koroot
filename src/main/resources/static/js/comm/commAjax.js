$.ajaxSetup({
	beforeSend: function(xhr) {
		console.log("beforeSend==========>");
		// common.blockUI();
	},
	complete : function(xhr,status) {
		console.log("complete==========>", status);
		// common.unblockUI();
	},
	error : function(xhr,status,error){
		console.log("error==========>");
		// common.unblockUI();
	}
});

var commAjax = {
	get: function(url, param){
		return new Promise(function(resolve, reject) {
			console.log("!FormData", param, JSON.stringify(param));
			var ajaxObject = {
			    async : false,
				type: "GET",
				url: url,
				cache: false,
				data: param,
				success: function(res) {
					console.log('res =>', res);
					resolve(res);
				},
				error: function(err) {
					console.log(err);
					if( err.status == "401" ){
						alert(err.responseText);
						window.location.href="/login.do?lang=in";
					}else{
						reject(err);
					}
				}
			};

			$.ajax(ajaxObject);
		})
	},
	post: function(url, param){
		return new Promise(function(resolve, reject) {

			var ajaxObject = {
				async : false,
				type: "POST",
				url: url,
				cache: false,
				success: function(res) {
					console.log('res =>', res);
					resolve(res);
				},
				error: function(err) {
					console.log("err==========>", err.status === 500 );
					console.log(err);
					if( err.status == "401" ){
						alert(err.responseText);
						window.location.href="/login.do?lang=in";
					}else if( err.status == "500" ){
						alert(err.statusText);
					}else{
						reject(err);
					}
				},
			};

			// when formData
			if (param instanceof FormData) {
				console.log("FormData");
				ajaxObject['processData'] = false;
				ajaxObject['contentType'] = false;
				ajaxObject['data'] = param;
			}
			// when json
			else {
				console.log("!FormData", param, JSON.stringify(param));
				ajaxObject['contentType'] = "application/json; charset=utf-8";
				ajaxObject['data'] = JSON.stringify(param);
			}

			$.ajax(ajaxObject);
		});
	},
}