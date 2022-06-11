import axios from 'axios'
import toastr from 'toastr'
      
var client = {}

export function tryConnecting() {
  let userId = localStorage.getItem("userId");
  if (userId) {
    axios.post('http://localhost:8081/api/v1/sockets/doctorSocket')
    .then(() => {
      client = window.io.connect(`http://localhost:9093/doctorSocket`), {
        forceNew: true,
        transports: ['polling', 'websocket']
      }
      client.on("event", data => {
        toastr.options = {
          "closeButton": true,
          "closeDuration": 3000,
          "position-class":'toast-top-full-width'
        }
        toastr.warning(data.message, data.title);
      })
    });

  }
}