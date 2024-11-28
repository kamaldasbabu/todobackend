// src/services/uploadService.ts
import multer, { FileFilterCallback } from "multer";
import path from "path";
import { sendResponse } from "../utils/utils";

// Define a custom storage configuration for multer
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, "./uploads"); // Directory where the files will be uploaded
  },
  filename: (req, file, cb) => {
    // Use a unique filename based on the current timestamp
    cb(null, Date.now() + path.extname(file.originalname));
  },
});

// Function to check if the file type is valid (optional validation)
const fileFilter: multer.Options["fileFilter"] = (req, file, cb) => {
  const allowedMimeTypes = ["image/jpeg", "image/png", "image/gif"];
  if (allowedMimeTypes.includes(file.mimetype)) {
    cb(null, true);
  } else {
    cb(new Error("Invalid file type. Only JPEG, PNG, and GIF are allowed."));
  }
};

// Create multer instance with storage and file filter
const upload = multer({
  storage,
  fileFilter,
});

// Function to handle single file upload
export const uploadSingleFile = (req: any, res: any, next: any) => {
  const uploadSingle = upload.single("photo"); // 'photo' is the name of the file input field

  uploadSingle(req, res, (err: any) => {
    if (err) {
      return sendResponse(res, false, 500, err.message, "File upload failed!!");
    }

    // If no file uploaded
    if (!req.file) {
      return sendResponse(res, false, 400, err.message, "No file uploaded.");
    }

    // Attach uploaded file information to the request object
    req.uploadedFile = req.file;
    next(); // Proceed to the next middleware or route handler
  });
};
