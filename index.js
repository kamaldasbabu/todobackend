// const bodyParser = require("body-parser");
const express = require("express");
var cors = require("cors");
const Post = require("./model/postSchema.js");
// const mongoose = require("mongoose");
const profileRouter = require("./router/profile.route.js")
// const url = "mongodb+srv://todolistkamal:SYvJFLnhLahK8YBw@cluster0.nlafqnt.mongodb.net/db2?retryWrites=true&w=majority"
// // mongoose.connect(url, {userNewUrlParser: true}).then(()=> {
// mongoose
//   .connect(url)
//   .then(() => {
//     console.log("connected to db");
//   })
//   .catch(() => {
//     console.log("failed db");
//   });
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
// app.use("/api/v1/products", profileRouter);
// app.use("/api/v1/projects", profileRouter);

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

// app.get("/api/readposts", (req, res, next) => {
//   Post.find().then((documents) => {
//     res.status(200).json({
//       message: "Successfully",
//       posts: documents,
//     });
//   });
// });
// app.post("/api/createpost", (req, res, next) => {
//   const newPost = new Post({
//     title: req.body.title,
//     content: req.body.content,
//   });
//   newPost.save();
//   console.log("server" + newPost);
//   res.status(201).json({
//     message: "Post Success",
//   });
// });
// app.delete("/api/deletepost/:id", (req, res, next) => {
//   Post.deleteOne(req.param.id)
//     .then(() => {
//       res.status(200).send("DELETED");
//     })
//     .catch((err) => {
//       res.status(500).send(err);
//     });
// });
app.listen(port, () => {
  console.log("Running on port : "+port);
});


module.exports = app;

