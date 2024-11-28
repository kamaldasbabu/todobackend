import express, { Request, Response, Router } from "express";import {
  userLogin,
  allUsers,
  newUser,
  updateUser,
  viewProfile,
} from "../controllers/userControler";
// import multer from 'multer';
// const upload = multer({ dest: 'uploads/' });
import { upload } from "../middlewares/uploadMiddleware";

import { authMiddleware } from "../middlewares/authMiddleware";
const userRouter: Router = express.Router();

userRouter
  .post("/signin", userLogin)
  .get("/", [authMiddleware], allUsers)
  .post("/signup", newUser)
  .post("/update", [authMiddleware], updateUser)
  .get("/profile/", [authMiddleware], viewProfile);

// [upload.single("profilePicture")],
export { userRouter };
