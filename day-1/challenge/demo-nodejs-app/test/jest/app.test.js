const request = require('supertest');
const app = require('../../src/index');


describe('Jest + Supertest: /hello endpoints', () => {
  test('GET /hello should return greeting', async () => {
    const res = await request(app).get('/hello');
    expect(res.statusCode).toBe(200);
    expect(res.body).toHaveProperty('message', 'Hello, world!');
  });


  test('GET /hello/:name should greet name', async () => {
    const res = await request(app).get('/hello/Akash');
    expect(res.statusCode).toBe(200);
    expect(res.body).toHaveProperty('message', 'Hello, Akash!');
  });


  test('GET /health should return ok', async () => {
    const res = await request(app).get('/health');
    expect(res.statusCode).toBe(200);
    expect(res.body).toEqual({ status: 'ok' });
  });
});
