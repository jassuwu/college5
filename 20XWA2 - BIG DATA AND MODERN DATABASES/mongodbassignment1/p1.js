const mongoose = require('mongoose');
const dotenv = require('dotenv');
dotenv.config();

// Connect to MongoDB Atlas using Mongoose
const main = async () => {
    await mongoose.connect(process.env.MONGO_URI)
    console.log('Connected to MongoDB Atlas.')
}
main().catch(err => console.log(err));


// Modelling the diversion schema
const diversionSchema = new mongoose.Schema({
    name: String,
    diversions: Number,
    year: Number,
    month: Number
});
const Diversion = mongoose.model("Diversion", diversionSchema);

// Functionalities
const populate = async () => {
    docs = await Diversion.insertMany([{
        name: 'A',
        diversions: 31,
        year: 2001,
        month: 1
    }, {
        name: 'B',
        diversions: 62,
        year: 2002,
        month: 2
    }, {
        name: 'C',
        diversions: 20,
        year: 2003,
        month: 3
    }, {
        name: 'D',
        diversions: 25,
        year: 2004,
        month: 4
    }, {
        name: 'E',
        diversions: 92,
        year: 2005,
        month: 5
    }
    ]);
    console.log(docs);
    console.log('Data inserted.');
}
const findAllRecords = async () => {
    records = await Diversion.find();
    console.log(records);
}
const readAndAggregate = async () => {
    const records = await Diversion.aggregate([
        {
            $group: {
                _id: "$name",
                total: { $sum: "$diversions" }
            }
        }
    ]);
    console.log(records);
}
const updateRecords = async () => {
    const records = await Diversion.updateMany({ name: /[AB]/ }, { $set: { diversions: 69 } });
    console.log(records);
}
const deleteRecords = async () => {
    const records = await Diversion.deleteMany({ name: /[AB]/ });
    console.log(records);
}



// Populating the database with user-data
// populate().catch(err => console.log(err));

// Querying the database
findAllRecords().catch(err => console.log(err));

// Read + Aggregation
// readAndAggregate().catch(err => console.log(err));

// Update records
// updateRecords().catch(err => console.log(err));

// Delete records
// deleteRecords().catch(err => console.log(err));