var http = require("http");

var parts = {
		host:"services.runescape.com",
		path:"/m=itemdb_rs/api/catalogue/detail.json?item=",
		port:80,
		method:"GET"
	};

function lookup(api,callback) {
}

exports.lookup = lookup;