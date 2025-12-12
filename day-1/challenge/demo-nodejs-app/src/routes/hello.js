const express = require('express');
const router = express.Router();


router.get('/', (req, res) => {
  res.json({ message: 'Hello, world!' });
});


router.get('/:name', (req, res) => {
  const { name } = req.params;
  res.json({ message: `Hello, ${name}!` });
});


module.exports = router;
