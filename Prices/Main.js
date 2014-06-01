var restify = require("restify"),http = require("http"),lookup = require("./Lookup");

var parts = {
		host:"services.runescape.com",
		path:"/m=itemdb_rs/api/catalogue/detail.json?item=",
		port:80,
		method:"GET",
		headers: {
			"application-type":"text/json"
		}
	};

function home(req,res,next) {
	console.log("requesting home");
	res.send("Hello");
	return next();
}

function price_pass(req,res,next) {
	var api = {};
	api.req = req;
	api.res = res;
	api.next = next;
	lookup.lookup(api);
}

var server = restify.createServer();
server.listen(8080);
server.get("/price",home);
server.get("/price/:id",price_pass);