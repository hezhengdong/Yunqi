document.addEventListener("DOMContentLoaded", (event) => {
  var selectAllBtn = document.getElementsByClassName("addButton");
  if (selectAllBtn) {
    // 如果找到了元素，添加事件监听器
    selectAllBtn.addEventListener("click", function () {
      this.classList.toggle("active");
    });
  } else {
    // 如果没有找到元素，打印错误信息
    console.error("元素 #selectAllBtn 未找到！");
  }
});

//全选按钮动效
document.getElementById("selectAllBtn").addEventListener("click", function () {
  this.classList.toggle("active"); // 切换active类，用于显示或隐藏对号
});
