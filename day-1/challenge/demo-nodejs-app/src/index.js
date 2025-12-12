const express = require('express');
const helloRouter = require('./routes/hello');


const app = express();
const PORT = process.env.PORT || 3000;


app.use(express.json());
app.use('/hello', helloRouter);


// health route
app.get('/health', (req, res) => res.json({ status: 'ok' }));


// start server only if run directly
if (require.main === module) {
  app.listen(PORT, () => console.log(`Server listening on port ${PORT}`));
}


module.exports = app;
