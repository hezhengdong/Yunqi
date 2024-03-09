function displaynone() {
    document.getElementById("shoppingcat my-box").style.display = 'none';
}


function addcartNum() {
        var num = document.getElementById("number");
        num.innerHTML++;
        document.cookie = num.value;
      }
      function reducecartNum() {
        var num = document.getElementById("number");
        num.innerHTML--;
        document.cookie = num.value;
      }
      document
        .querySelector(".shoppingcat-partthree")
        .addEventListener("click", () => {
          console.log("点击了");
          // const id = event.target.parentElement.getAttribute('data-id');
          let mycount = document.querySelector(".number").innerHTML;
          // let  myid = document.querySelector(".number").innerHTML;
          axios({
            url: "http://localhost:8080/YunqiIceCity/shopcart/add",
            method: "post",
            data: {
                // milkteaid:myid,
              count: mycount,
            },
          }).then((result) => {
            console.log("发送成功");
            console.log(result);
          });
        });
function displayone(){
    document.getElementById('shoppingcat').style.display='none';
}
document.querySelector('shoppingcat-partthree').addEventListener('click',()=>{
    alert('购物车添加成功！')
})