
from flask import Flask
from pymongo import MongoClient
from flask import jsonify
from flask import request

app = Flask(__name__)

@app.route('/jiwoo')
def hello_world():
   return 'Hello World'

@app.route('/test', methods=['GET'])
def get_all_documents():
    client = MongoClient('mongodb://localhost:27017/')
    db = client.test
    collection = db.test
    output = []
    for s in collection.find():
        output.append({'name' : s['name'], 'age' : s['age']})
    return jsonify({'result' : output})

@app.route('/test-one/<name>', methods=['GET'])
def get_one_star(name):
  client = MongoClient('mongodb://localhost:27017/')
  db = client.test
  collection = db.test
  output = []

  s = collection.find_one({'name' : name})
  if s:
    output = {'name' : s['name'], 'age' : s['age']}
  else:
    output = "No such name"
  return jsonify({'result' : output})


if __name__ == '__main__':
  app.run()
