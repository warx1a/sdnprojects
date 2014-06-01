var http = require("http");

var parts = {
		host:"services.runescape.com",
		path:"/m=itemdb_rs/api/catalogue/detail.json?item=",
		port:80,
		method:"GET"
	};

function lookup(api) {
	var response;
	parts.path += api.req.params.id.toString();
	console.log(parts.host+parts.path);
	var request = http.request(parts,function(resp) {
		resp.on("error",function(err) {
			console.log(err);
		});
		resp.on("data",function(grp) {
			response += grp;
		});
		resp.on("end",function() {
			response = JSON.parse(response.slice(9,response.length));
			console.log("parsed");
			api.res.write(response.item.current.price.toString());
			console.log("ending request");
		});
	});
	request.end();
	return api.next();
}

exports.lookup = lookup;