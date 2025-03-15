import { Response } from "express";import { DEFAULT_LIMIT, START_PAGE } from "./constant";

/**
 * SEND RESPONSE FUNCTION
 * @param res Response
 * @param success boolean
 * @param statusCode number
 * @param message string
 * @param data any
 * @param page number
 * @param limit number
 */
const sendResponse = (
  res: Response,
  success: boolean,
  statusCode: number,
  message: string,
  data: any,
  page: number = START_PAGE,
  limit: number = DEFAULT_LIMIT
): void => {
  const responsePayload: ResponseData = {
    success,
    statusCode,
    message,
    data,
    page,
    limit,
  };
  res.status(statusCode).json(responsePayload);
};

interface ResponseData {
  success: boolean;
  statusCode: number;
  message: string;
  data?: any;
  page?: number;
  limit?: number;
}

export { sendResponse };
