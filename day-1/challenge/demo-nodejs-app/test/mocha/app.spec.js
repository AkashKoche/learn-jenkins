const request = require('supertest');
const { expect } = require('chai');
const app = require('../../src/index');


describe('Mocha + Supertest: /hello endpoints', () => {
  it('GET /hello should return greeting', async () => {
    const res = await request(app).get('/hello');
    expect(res.status).to.equal(200);
    expect(res.body).to.have.property('message', 'Hello, world!');
  });


  it('GET /hello/:name should greet name', async () => {
    const res = await request(app).get('/hello/Jane');
    expect(res.status).to.equal(200);
    expect(res.body).to.have.property('message', 'Hello, Jane!');
  });


  it('GET /health should return ok', async () => {
    const res = await request(app).get('/health');
    expect(res.status).to.equal(200);
    expect(res.body).to.deep.equal({ status: 'ok' });
  });
});
