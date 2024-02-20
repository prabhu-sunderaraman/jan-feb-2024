let app = require('express')();
app.get('/hello/:name', (req, res) => {
    res.send('Hello, ' + req.params.name);
});
app.post('/bye/:name', (req, res) => {
    res.send('Goodbye, ' + req.params.name);
});
app.listen(3000, () => {
    console.log('Server is running on port 3000');
});