from flask import Flask, request, render_template
import requests

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():
    medications = []
    if request.method == 'POST':
        disease = request.form.get('disease')
        if disease:
            url = f"https://api.fda.gov/drug/label.json?search=indications_and_usage:{disease}&limit=5"
            response = requests.get(url)
            if response.status_code == 200:
                data = response.json().get('results', [])
                for item in data:
                    medications.append({
                        'name': item.get('openfda', {}).get('brand_name', ['N/A'])[0],
                        'indications': item.get('indications_and_usage', 'N/A')
                    })
            else:
                medications = [{"name": "N/A", "indications": "Failed to retrieve data"}]

    return render_template('index.html', medications=medications)

if __name__ == '__main__':
    app.run(debug=True)
