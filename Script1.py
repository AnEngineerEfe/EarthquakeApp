import requests

# Veri toplayan servisin URL'si
url = "http://localhost:8080/api/deprem"

# Rastgele değerler üretmek için kütüphaneler
from random import randint

while True:
    # Enlem ve boylam için rastgele değerler
    lat = randint(-90, 90)
    lon = randint(-180, 180)

    # Şiddet için rastgele değer (1 ile 10 arasında)
    siddet = randint(1, 10)

    # Veri gönderme isteği
    payload = {"lat": lat, "lon": lon, "siddet": siddet}
    response = requests.post(url, json=payload)

    # Hata kontrolü
    if response.status_code != 200:
        print("Hata:", response.text)

    # Bekleme süresi (isteğe bağlı)
    time.sleep(1)