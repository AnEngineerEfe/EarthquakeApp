import requests

# Veri toplayan servisin URL'si
url = "http://localhost:8080/api/deprem"

# Enlem, boylam ve şiddet değerlerini girin
lat = 41.01
lon = 28.96
siddet = 7.4

# Veri gönderme isteği
payload = {"lat": lat, "lon": lon, "siddet": siddet}
response = requests.post(url, json=payload)

# Hata kontrolü
if response.status_code != 200:
    print("Hata:", response.text)

print("Deprem eklendi!")