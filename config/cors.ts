
import cors from 'cors';

interface CorsConfig {
  origin: string | string[] | boolean;
  methods: string[];
  allowedHeaders: string[];
}

const corsConfig: { [env: string]: CorsConfig } = {
  development: {
    origin: ['http://localhost:3000', 'http://localhost:4000'],
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization'],
  },
  production: {
    origin: ['https://your-production-domain.com'],
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization'],
  },
  quality: {
    origin: ['https://your-production-domain.com'],
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    allowedHeaders: ['Content-Type', 'Authorization'],
  },
  // Add more environments as needed
};

export const getCorsConfig = (env: string): cors.CorsOptions => {
  const config = corsConfig[env];
  if (!config) {
    throw new Error(`CORS configuration not found for environment: ${env}`);
  }
  return config;
};