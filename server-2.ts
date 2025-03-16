import express, { Express, Request, Response } from "express";
import { userRouter } from "./src/user/router/userRoutes";
import { questionRouter } from "./src/question/router/questionRoutes";
import connect from "./src/config/db";
import { getCorsConfig } from "./config/cors";
import cors from "cors";
import limiter from "./config/limit"; // Import the limiter
import { Worker, isMainThread, parentPort } from "worker_threads";
import cluster from "cluster";
import os from "os";

const PORT = process.env.PORT || "5000";
const serverEnv: string = process.env.SERVER_ENV || "development";
const numCPUs = os.cpus().length; // Get the number of CPU cores

if (isMainThread && cluster.isPrimary) {
  // MAIN THREAD: Spawn worker threads
  console.log(`Master process ${process.pid} is running`);

  for (let i = 0; i < numCPUs; i++) {
    cluster.fork();
  }

  // Restart worker if it crashes
  cluster.on("exit", (worker, code, signal) => {
    console.log(`Worker ${worker.process.pid} died, restarting...`);
    cluster.fork();
  });
} else {
  // WORKER THREAD: Runs the Express server
  const app: Express = express();

  // CORS Configuration
  const corsOptions: cors.CorsOptions = getCorsConfig(serverEnv);
  app.use(cors(corsOptions));

  // Rate Limiting
  app.use(limiter);

  // Middleware
  app.use(express.json());
  app.use(express.urlencoded({ extended: true }));

  // Routes
  app.use("/api/user", userRouter);
  app.use("/api/qsn", questionRouter);

  // Health Check Route
  app.get("/api/ping", (req: Request, res: Response) => {
    res.json({ message: "Server is running" });
  });

  // Database Connection
  connect().then(() => {
    console.log(`Worker ${process.pid} connected to DB and running on port ${PORT}`);

    // Start Express server
    app.listen(PORT, () => {
      console.log(`Worker ${process.pid} is listening on port ${PORT}`);
    });
  });

  // Handle Messages from Parent (Optional)
  if (parentPort) {
    parentPort.on("message", (message) => {
      console.log(`Worker ${process.pid} received message:`, message);
    });
  }
}
