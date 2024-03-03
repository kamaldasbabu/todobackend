const { sendResponse } = require("../lib/resSend");
const dbService = require("../config/dbConfig");
const { POSTS_COLLECTON } = require("../constants/collections");

const getUser = async (req, res) => {
  const client = await dbService.getClient();
  console.log("result1", "iii", new Date().getTime());
  const result = await client.collection(POSTS_COLLECTON).find({}).toArray();
  console.log("result2", result, new Date().getTime());
  console.log("result3", result, new Date().getTime());

  sendResponse(res, true, 200, "Messgage", result);
};

module.exports = { getUser };
