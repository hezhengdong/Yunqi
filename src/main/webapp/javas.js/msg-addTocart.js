axios.defaults.headers.common['ngrok-skip-browser-warning'] = `abab`; 
axios({
    method:'get',
    url: 'http://localhost:8080/YunqiIceCity/milktea/selectall',
})
.then(response => {
  const allTeas = response.data.data;

  // 根据 kindid 的不同将奶茶分类
  const fruitTeas = allTeas.filter(tea => tea.kindid === 1);
  const addTeas = allTeas.filter(tea => tea.kindid === 2);
  const iceCreams = allTeas.filter(tea => tea.kindid === 3);
  const milkTeas = allTeas.filter(tea => tea.kindid === 4);

  function displayTeas(teas, listul) {
    // 获取一种奶茶的ul列表
    var listul = document.getElementById(listul);
    teas.forEach(tea => {
      const listItem = document.createElement('li'); //为每个奶茶添加一个li
      const goodsimg = document.createElement('img');//存放奶茶的图片
      const goodsName = document.createElement('h4');//存放奶茶的名称
      const money = document.createElement('i');//存放奶茶的价格
      const btn = document.createElement('button');//存放加购按钮

      goodsimg.src = tea.image;//奶茶的图片
      goodsName.textContent = tea.milkteaname;//奶茶的名称
      money.textContent = `￥`+tea.price;//奶茶的价格
      btn.innerHTML = "&#xe620;"; 
    //   btn.onclick = addToCart2;
        //   btn.onclick = addToCart1;
        
    btn.addEventListener('click', addToCart1);
    btn.addEventListener('click', addToCart2);
    // btn.addEventListener('click',addToCart3);
  
      // 将 img h4 i元素添加到 li元素中
      listItem.appendChild(goodsimg);
      listItem.appendChild(goodsName);
      listItem.appendChild(money);
      listItem.appendChild(btn);
      //为每个奶茶的li添加奶茶的id，以便后续实现购物车的功能
      listItem.setAttribute('data-id', tea.id);// 添加自定义属性data-id，并设置值为123
      // btn.setAttribute('milk-id',tea.id);
        //为加购按钮添加class名
      btn.className = "iconfont addToCartButtons";
      // 将 li 元素添加到ul列表中
      listul.appendChild(listItem);
    });
  }
    displayTeas(fruitTeas, 'fruitTeas');
    displayTeas(addTeas, 'addTeas');
    displayTeas(iceCreams, 'iceCreams');
    displayTeas(milkTeas, 'milkTeas');
})
.catch(error=>{
    console.error("获取奶茶的信息失败",error);
})

function addToCart1() {
    // 获取购物车的界面（只有一个）
    var cart = document.getElementsByClassName("shoppingcat")[0];
    // 检查购物车界面是否存在
    if (cart) {
        // 切换购物车界面的显示状态(三元运算表达式)
        cart.style.display = cart.style.display === 'none' ? 'block' : 'none';
    }
}

function addToCart2(event) {
    let id = event.target.parentElement.getAttribute('data-id');
    console.log(id);
    
    axios.post('http://localhost:8080/YunqiIceCity/shopcart/selectByid', { "id":id })
    .then(response => {
        // console.log(response.data.data);
        const myShoppingCart = response.data.data
        console.log(myShoppingCart)
        const cartimg = document.getElementById("img1");
        const cartname = document.getElementById("milkteaName");
        const milkmsg = document.getElementById("introduce")
        const milkprice=document.getElementById("price")
        let myid=document.createElement("div")
        // myid.style.display="none"
        cartimg.src = myShoppingCart.image;
        cartname.innerHTML = myShoppingCart.milkteaname;
        milkmsg.innerHTML = myShoppingCart.introduce;
        milkprice.innerHTML = myShoppingCart.price;
        myid.innerHTML=myShoppingCart.id;
    })
    .catch(error => {
        console.error('post信息出错了', error);
        // console.log('111');
    });
}
// function add
