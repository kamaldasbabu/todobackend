import express, { Express, Request, Response } from "express";import { userRouter } from "./src/user/router/userRoutes";
import connect from "./src/config/db";
import { questionRouter } from "./src/question/router/questionRoutes";
import dotenv from "dotenv";
import { getCorsConfig } from "./cors/cors";
import cors from "cors";

// Load environment variables from .env file
dotenv.config();

const app: Express = express();
const PORT = process.env.PORT as string;
const serverEnv: string = process.env.SERVER_ENV || "development";

/**
 * HANDEL MIDDILEWIRE
 */
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const corsOptions: cors.CorsOptions = getCorsConfig(serverEnv);
app.use(cors(corsOptions));

/**
 * USER ROUTES
 */

app.use("/api/user", userRouter);
app.use("/api/qsn", questionRouter);

// SERVER PING TEST
app.get("/api/ping", (req: Request, res: Response) => {
  res.json({ message: "Server is running" });
});

// server listen
app.listen(PORT, async (): Promise<void> => {
  // DB Connection
  await connect();
  console.log(`server is running on ${PORT}`);
});
