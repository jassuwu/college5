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
const disDeathsSchema = new mongoose.Schema({
    survived: Number,
    name: String,
    sex: String,
    age: Number,
    ticket: String,
    fare: Number,
    cabin: String
});
const DisDeath = mongoose.model("disDeath", disDeathsSchema);

// Functionalities
const populate = async () => {
    await DisDeath.insertMany([
        {
            survived: 0,
            name: "Braund",
            sex: "male",
            age: 22,
            ticket: "A/5 21171",
            fare: 7.25,
            cabin: "C85"
        },
        {
            survived: 1,
            name: "Cumings",
            sex: "female",
            age: 38,
            ticket: "PC 17599",
            fare: 71.2833,
            cabin: "C85"
        },
        {
            survived: 1,
            name: "Heikkinen",
            sex: "female",
            age: 26,
            ticket: "STON/O2. 3101282",
            fare: 7.925,
            cabin: "C123"
        },
        {
            survived: 1,
            name: "Futrelle",
            sex: "female",
            age: 35,
            ticket: "113803",
            fare: 53.1,
            cabin: "C123"
        }, {
            survived: 0,
            name: "Allen",
            sex: "male",
            age: 35,
            ticket: "373450",
            fare: 8.05,
            cabin: "C103"
        }]);
    // console.log(docs);
    console.log('Data inserted.');
}
const findAllRecords = async () => {
    records = await DisDeath.find();
    console.log(records);
}
const readAndAggregate = async () => {
    const records = await DisDeath.aggregate([
        {
            $group: {
                _id: "$name",
                total: { $sum: "$DisDeaths" }
            }
        }
    ]);
    console.log(records);
}
const updateRecords = async () => {
    const records = await DisDeath.updateMany({ sex: /female/ }, { $set: { fare: 0.5 * fare } });
    console.log(records);
}
const deleteRecords = async () => {
    const records = await DisDeath.deleteMany({ name: /female/ });
    console.log(records);
}



// Populating the database with user-data
// populate().catch(err => console.log(err));

// Querying the database
findAllRecords().catch(err => console.log(err));

// // Read + Aggregation
// readAndAggregate().catch(err => console.log(err));

// // Update records
// updateRecords().catch(err => console.log(err));

// // Delete records
// deleteRecords().catch(err => console.log(err));


