# flask_app_sqlalchemy.py

from flask import Flask, render_template_string
from models import db, Monologue
import os

app = Flask(__name__)
# Configure the database URI
BASE_DIR = os.path.abspath(os.path.dirname(__file__))
app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{os.path.join(BASE_DIR, "sqlmono.db")}'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

# Initialize the database with the Flask app
db.init_app(app)

# A simple HTML template to display the monologues
HTML_TEMPLATE = """
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>AI Monologue Feed</title>
    <meta http-equiv="refresh" content="15"> <style>
      body { font-family: monospace; background-color: #f0f0f0; padding: 2em; }
      .monologue { margin-bottom: 2em; padding: 1em; border: 1px solid #ccc; background-color: #fff; border-radius: 5px; }
      .timestamp { color: #888; font-size: 0.8em; }
    </style>
  </head>
  <body>
    <h1>AI Monologue Feed</h1>
    {% for monologue in monologues %}
      <div class="monologue">
        <p>{{ monologue.text }}</p>
        <div class="timestamp">{{ monologue.timestamp }}</div>
      </div>
    {% endfor %}
  </body>
</html>
"""

@app.route('/')
def home():
    monologues = db.session.execute(
        db.select(Monologue).order_by(Monologue.timestamp.desc()).limit(20)
    ).scalars().all()
    print(f"Fetched {len(monologues)} monologues.")
    return render_template_string(HTML_TEMPLATE, monologues=monologues)
if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(debug=True)