import express, { Express, Request, Response } from "express";
import { userRouter } from "./src/user/router/userRoutes";
import connect from "./src/config/db";
import { questionRouter } from "./src/question/router/questionRoutes";
// import dotenv from "dotenv";
import { getCorsConfig } from "./config/cors";
import cors from "cors";
import limiter from "./config/limit"; // Import the limiter

// Load environment variables from .env file
// dotenv.config();

const app: Express = express();
const PORT = process.env.PORT as string;
const serverEnv: string = process.env.SERVER_ENV || "development";

/**
 * SERVER CONFIG MIDDILE WIRE
 */

// CORS
const corsOptions: cors.CorsOptions = getCorsConfig(serverEnv);
app.use(cors(corsOptions));

// USER SERVER HIT LIMIT
app.use(limiter); // Apply rate limiting to all routes

/**
 * HANDEL MIDDILEWIRE
 */
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

/**
 * ROUTES START
 */
app.use("/api/user", userRouter);
app.use("/api/qsn", questionRouter);

/**
 * ROUTES END
 */

// SERVER PING TEST
app.get("/api/ping", (req: Request, res: Response) => {
  res.json({ message: "Server is running" });
});

// server listen
app.listen(PORT, async (): Promise<void> => {
  // DB Connection
  await connect();
  console.log(`Server is running on ${PORT}`);
});
