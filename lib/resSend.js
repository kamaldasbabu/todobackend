/** *  RES SEND FUNCTION * * * * * * 
 * @param {Object} res
 * @param {Boolean} status
 * @param {Number} statusCode
 * @param {String} message
 * @param {any} data
 * * * * * * * * * * * * 
 */

const sendResponse = async (res, status, statusCode, message, data) => {
  const response = { status, statusCode, message, data };
  res.status(statusCode).json(response);
};

module.exports = { sendResponse };
