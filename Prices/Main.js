var restify = require("restify"),http = require("http");

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
	var response;
	parts.path += req.params.id.toString();
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
			res.setHeader("application-type","text/plain");
			res.write(response.item.current.price.toString());
			console.log("ending request");
		});
	});
	request.end();
	return next();
}

var server = restify.createServer();
server.listen(8080);
server.get("/price",home);
server.get("/price/:id",price_pass);