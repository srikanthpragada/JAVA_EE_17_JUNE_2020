import requests

resp = requests.get("http://localhost:9999/rest/job")
jobs = resp.json()
for job in jobs:
      print(f"{job['id']} - {job['title']}")
