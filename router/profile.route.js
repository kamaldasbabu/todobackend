const router = require("express").Router();
const controller = require("../controller/profile.controller");

router.get("/user", [], (req, res) => {
  controller.getUser(req, res);
});

module.exports = router;
