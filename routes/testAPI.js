var express = require('express');
var router = express.Router();
const mongoose = require('mongoose');
const uri = 'mongodb+srv://masterUser:WY8mqTzZA8jUY7c@shark-db.idsiv.mongodb.net/test';
const app = express();
 
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
mongoose.connect(uri, {
  useNewUrlParser: true,
  useUnifiedTopology: true
})
.then(() => {
    console.log("MongoDB Connected…")
  })
  .catch(err => console.log(err))
  const sharkSchema = new mongoose.Schema({
    name: String,
    species: String
  });
  const Shark = mongoose.model('Shark', sharkSchema);

router.post('/', function(req, res, next) {
  const sharkToSave = new Shark({ name:req.body.name, species:req.body.species });
  var saved = "Saved"
  var test = JSON.stringify(saved);
  console.log(test)
  sharkToSave.save(function (err, shark) {
    if (err) return console.error(err);
    console.log(sharkToSave)
  });
    res.status(200).send(test);
});

module.exports = router;
