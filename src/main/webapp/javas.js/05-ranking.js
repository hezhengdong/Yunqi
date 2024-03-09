axios.defaults.headers.common["ngrok-skip-browser-warning"] = "apppps";

const rankingBody =document.querySelectorAll('.body')
let re = axios.get('http://localhost:8080/milktea/salenumberselect')
  .then(function (response) {
    console.log(response);
    var tea = response.data.data
    console.log(tea[5].image);
    for (var i = 0; i < 3; i++){
      rankingBody[i].style.backgroundImage= `url(${tea[i].image})`;
    }
  })
  .catch(function (error) {
    // 处理错误情况
    console.log(error);
  })