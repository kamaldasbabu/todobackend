// const { debug } = require('console');
// const http=require('http');
// const app = require('./index');

// console.log(app);


// const port = process.env.PORT || 3000;

// const normalizePort = val => {
//     var port = parseInt(val, 10);
//     if(isNaN(port)){
//         return val;
//     }
//     if(port >= 0){
//         return port;
//     }

//     return false;
// };

// const onError = error => {
//     if(error.syscall !== "listen")
//      throw error;

// const bind = typeof addr === "string" ? "pipe"+addr: "port"+port;
// switch (error.code){
//     case "EACCESS": 
//     console.error(bind+"bind");
//     process.exit(1);
//     break;
//     case "EADDRINUSE": 
//     console.error(bind+"err");
//     process.exit(1);
//     break;
//     default: 
//     throw error;
// }

// };

//  const onListening = ()=> {
//      const addr = server.address();
//      const bind = typeof addr==="string" ? "pipe"+addr: "port"+port;
//      debug("listining"+bind);
//  }
//  // setting port
//  app.set("port: ", port);

//  // create server and serve it or listen
//  const server = http.createServer(app);
//  server.on("error: ", onError);
//  server.on("listining", onListening);
// //  server.on("listening", onListening);
//  console.log("server started", port);

// server.listen(port);


const express = require("express");
var cors = require("cors");
const Post = require("./model/postSchema.js");
const profileRouter = require("./router/profile.route.js")

const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// app.use((req, res, next)=> {
//     res.setHeader("Access-Control-Allow-Origin", "*");
//     res.setHeader(
//         "Access-Control-Allow-Headers",
//         "Origin, X-Requested-With, Content-Type, Accept",
//         "HttpHeaders"

//     );
//     res.setHeader("Access-Control-Allow-Methods",
//     "GET","POST", "PUT", "DELETE", "PATCH", "UPDATE"
//     );
//     next();
// });
app.use(cors("*"));
const version = process.env.VERSION || "v1";
const port = process.env.PORT || 3000;

app.use("/api/v1/profile", profileRouter);

app.get("/", (req, res) => {
  res.json({
    msg: "Working Backend..."
  })
})

app.get("/ping", (req, res) => {
  res.json({
    msg: "Working Backend... PING SUCCESS !!!"
  })
})

app.listen(port, () => {
  console.log("Running on port : "+port);
});


