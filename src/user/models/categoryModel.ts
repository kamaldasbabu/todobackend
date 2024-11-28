import mongoose, { Document } from 'mongoose';

export interface ICategory extends Document {
  name: string;
}

const CategorySchema = new mongoose.Schema({
  name: { type: String, required: true, unique: true }
});

export default mongoose.model<ICategory>('Category', CategorySchema);