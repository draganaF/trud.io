import requests
import datetime
from threading import Thread
import time

url = 'http://localhost:8080/api/v1/ctg/1'
url_uterine = 'http://localhost:8080/api/v1/ctg/contractions/1'
end_url = 'http://localhost:8080/api/v1/ctg/endCtg/1'
start_url = 'http://localhost:8080/api/v1/ctg/startCtg/1'

# Contractions
contraction_min1 = [31, 40, 42, 43]
contraction_min2 = [41, 33, 29, 26]
contraction_min3 = [27, 35, 42, 30]
contraction_min4 = [24, 30, 40, 29]
contraction_min5 = [28, 27, 25, 25]
contraction_min6 = [30, 40, 41, 42]
contraction_min7 = [41, 35, 29, 25]
contraction_min8 = [25, 25, 24, 28]
contraction_min9 = [26, 25, 24, 28]
contraction_min10 = [29, 29, 29, 20]

# Tachycardia
values_min1 = [172, 164, 172, 166, 171, 166, 172, 167, 170, 165, 170, 167, 170, 165, 172]
values_min2 = [168, 166, 167, 166, 171, 164, 171, 156, 161, 135, 143, 136, 146, 140, 155]
values_min3 = [167, 149, 161, 154, 161, 156, 165, 160, 167, 161, 172, 166, 173, 165, 170]
values_min4 = [163, 170, 164, 173, 158, 171, 164, 172, 161, 172, 168, 170, 168, 171, 135]
values_min5 = [145, 137, 149, 138, 151, 145, 170, 165, 171, 167, 170, 167, 170, 167, 171]
values_min6 = [166, 170, 167, 170, 167, 170, 169, 170, 167, 170, 167, 170, 167, 170, 167]
values_min7 = [167, 170, 167, 169, 168, 170, 168, 179, 167, 170, 168, 171, 167, 170, 166]
values_min8 = [170, 163, 170, 167, 170, 140, 152, 140, 145, 140, 144, 150, 145, 151, 150]
values_min9 = [155, 140, 157, 153, 162, 156, 171, 165, 170, 165, 170, 160, 170, 165, 170]
values_min10 = [169, 165, 171, 168, 170, 168, 171, 168, 169, 168, 169, 167, 170, 168, 170]

# Normal
values_norm_min1 = [120, 125, 122, 135, 130, 140, 132, 139, 129, 135, 128, 135, 127, 135, 129]
values_norm_min2 = [131, 129, 132, 130, 132, 128, 132, 130, 133, 130, 134, 132, 136, 135, 131]

# Bradycardia
values_bad_min1 = [80, 76, 78, 74, 77, 71, 76, 71, 78, 73, 77, 72, 76, 73, 76]

headers = {'Content-Type': 'application/json'}


def send_values(values):
    for value in values:
        requests.post(url, json={
            'bpm': value,
            'timestamp': datetime.datetime.utcnow().isoformat()
        }, headers=headers)
        time.sleep(4)


def send_contractions(values):
    for value in values:
        requests.post(url_uterine, json={
            'value': value,
            'timestamp': datetime.datetime.utcnow().isoformat()
        }, headers=headers)
        time.sleep(15)


def start_ctg_request():
    requests.get(start_url)


def end_ctg_request():
    requests.get(end_url)


def fhr_function():
    send_values(values_bad_min1)
    send_values(values_bad_min1)
    send_values(values_bad_min1)
    send_values(values_bad_min1)
    send_values(values_bad_min1)


def contraction_function():
    send_contractions(contraction_min1)
    send_contractions(contraction_min2)
    send_contractions(contraction_min3)
    send_contractions(contraction_min4)
    send_contractions(contraction_min5)


requests.get(start_url)
print("Krenulo")

t1 = Thread(target=fhr_function)
t2 = Thread(target=contraction_function)

# start the threads
t1.start()
t2.start()

# wait for the threads to complete
t1.join()
t2.join()

end_ctg_request()
