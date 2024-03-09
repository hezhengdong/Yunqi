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

        // 将 img h4 i元素添加到 li元素中
        listItem.appendChild(goodsimg);
        listItem.appendChild(goodsName);
        listItem.appendChild(money);
        listItem.appendChild(btn);

        //为每个奶茶的li添加奶茶的id，以便后续实现购物车的功能
        listItem.setAttribute('data-id', tea.id); // 添加自定义属性data-id，并设置值为123
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
    console.error("出现错误了",error);
})

// function displayMilkteas(milkteas) {
//   // 将奶茶信息显示在页面上的某个位置
//   // 这里假设有一个id为'milkteaList'的元素用于显示奶茶信息
//   const milkteaListElement = document.getElementById('milkteaList');
//   // 清空现有内容
//   milkteaListElement.innerHTML = '';
//   // 遍历奶茶信息数组，创建HTML元素并添加到页面上
//   milkteas.forEach(milktea => {
//     const listItem = document.createElement('li');
//     listItem.textContent = `${milktea.name}: ￥${milktea.price}`;
//     milkteaListElement.appendChild(listItem);
//   });
// }