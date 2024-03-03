const router = require("express").Router();
import { getUser } from "../controller/profile.controller";

router.get("/user", [], (req, res) => {
  getUser(req, res);
});

export default router;
