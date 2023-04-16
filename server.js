const { debug } = require('console');
const http=require('http');
const app = require('./app')
const port = process.env.PORT || 3000;

const normalizePort = val => {
    var port = parseInt(val, 10);
    if(isNaN(port)){
        return val;
    }
    if(port >= 0){
        return port;
    }

    return false;
};

const onError = error => {
    if(error.syscall !== "listen")
     throw error;

const bind = typeof addr === "string" ? "pipe"+addr: "port"+port;
switch (error.code){
    case "EACCESS": 
    console.error(bind+"bind");
    process.exit(1);
    break;
    case "EADDRINUSE": 
    console.error(bind+"err");
    process.exit(1);
    break;
    default: 
    throw error;
}

};

 const onListening = ()=> {
     const addr = server.address();
     const bind = typeof addr==="string" ? "pipe"+addr: "port"+port;
     debug("listining"+bind);
 }
 // setting port
 app.set("port: ", port);

 // create server and serve it or listen
 const server = http.createServer(app);
 server.on("error: ", onError);
 server.on("listening: ", onListening);
 console.log("server started", port)
server.listen(port);