      //图片获取,奶茶名获取，奶茶数量获取,获取id用于修改数量的接口
      document.addEventListener("DOMContentLoaded", (event) => {
        const apiUrl =
          "http://localhost:8080/YunqiIceCity/shopcart/selectAll";
          // "https://vast-suitably-ram.ngrok-free.app/YunqiIceCity/setCookie";
        const headers = new Headers();
        headers.append("ngrok-skip-browser-warning", "abab");
        headers.append("Content-Type", "application/json");

        fetch(apiUrl, {
          method: "GET",
          // credentials: 'include',
          headers: headers,
        })
          .then((response) => {
            if (!response.ok) {
              throw new Error("Network response was not ok");
            }
            return response.json();
          })
          .then((data) => {
            // console.log(data)
            // 检查响应状态码和消息，确保请求成功
            if (data.code === 1 && data.msg === "success") {
              // 获取所有的tea类div元素
              const teaDivs = document.querySelectorAll(".tea");
              //teaName类div元素
              const teaNameDivs = document.querySelectorAll(".teaName");
              //milkTeaNumber类div元素
              const milkTeaNumberDivs =
                document.querySelectorAll(".milkTeaNumber");
              //选择一个具体的id对应的对象，例如选择id为1的对象
              // const selectedItem = data.data.find((item) => item.id === 1);

              // 遍历返回的data数组
              data.data.forEach((item, index) => {
                const imageUrl = item.image; // 从当前对象中提取image字段
                const teaDiv = teaDivs[index];
                const milkTeaNumberDiv = milkTeaNumberDivs[index];
                if (teaDiv) {
                  teaDiv.style.backgroundImage = `url(${imageUrl})`;
                  teaDiv.style.backgroundSize = "cover"; // 确保背景图片覆盖整个div
                }
              });
              //设置茶名
              data.data.forEach((item, index) => {
                const teaname = item.milkteaname;
                const teaNameDivs = document.querySelectorAll(".teaName");
                if (teaNameDivs[index]) {
                  teaNameDivs[index].textContent = teaname;
                }

                const count = item.count;
                milkTeaNumberDivs[index].textContent = count;
              });
              
              //赋一个空的初值
              let selectedItem = null;
              // 获取所有的增加和减少按钮
              const addButtons = document.querySelectorAll(".addButton");
              const minusButtons = document.querySelectorAll(".minusButton");
              // 为增加按钮添加点击事件监听器
              addButtons.forEach((button) => {
                button.addEventListener("click", () => {
                  const index = parseInt(button.dataset.index, 10); // 获取按钮的索引
                  const item = data.data[index - 1]; // 根据索引找到对应的数据项（注意数组索引从0开始）
                  if (item) {
                    // 更新数据项中的 count 属性
                    item.count++;
                    // 更新 selectedItem
                    selectedItem = item;
                    console.log(selectedItem); // 打印更新后的 selectedItem
                  }
                });
              });

              // 如果找到了对应的对象，我们将其id和count属性写入dataToSend中
            if(selectedItem){
              const dataToSend = {
                id: selectedItem.id.toString(), // 将数字转换为字符串
                count: selectedItem.count.toString(), // 将数字转换为字符串
              };

              //发送post请求
              fetch(
                "http://localhost:8080/YunqiIceCity/shopcart/update",
                {
                  method: "POST",
                  headers: headers,
                  body: JSON.stringify(dataToSend),
                }
              )
                .then((response) => {
                  if (!response.ok) {
                    throw new Error("Failed to submit data");
                  }
                  return response.json(); // 可以选择解析响应体，取决于是否需要处理返回的数据
                })
                .then((responseData) => {
                  // 处理POST请求的响应数据
                  console.log("Data submitted successfully:", responseData);
                })
                .catch((error) => {
                  // 处理错误
                  console.error(
                    "There was a problem with the fetch operation:",
                    error
                  );
                });
              }

              // 为减少按钮添加点击事件监听器
              minusButtons.forEach((button) => {
                button.addEventListener("click", () => {
                  const index = parseInt(button.dataset.index, 10); // 获取按钮的索引
                  const item = data.data[index - 1]; // 根据索引找到对应的数据项（注意数组索引从0开始）
                  if (item && item.count > 0) {
                    // 更新数据项中的 count 属性（这里只是示例，实际上您可能需要根据业务逻辑来处理）
                    item.count--;
                    // 更新 selectedItem
                    selectedItem = item;
                    console.log(selectedItem); // 打印更新后的 selectedItem
                  }
                });
              });

              console.log(selectedItem);
              // 如果找到了对应的对象，我们将其id和count属性写入dataToSend中
            if(selectedItem){
              const dataToSend1 = {
                id: selectedItem.id.toString(), // 将数字转换为字符串
                count: selectedItem.count.toString(), // 将数字转换为字符串
              };

              //发送post请求
              fetch(
                "http://localhost:8080/YunqiIceCity/shopcart/update",
                {
                  method: "POST",
                  headers: headers,
                  body: JSON.stringify(dataToSend1),
                }
              )
                .then((response) => {
                  if (!response.ok) {
                    throw new Error("Failed to submit data");
                  }
                  return response.json(); // 可以选择解析响应体，取决于是否需要处理返回的数据
                })
                .then((responseData) => {
                  // 处理POST请求的响应数据
                  console.log("Data submitted successfully:", responseData);
                })
                .catch((error) => {
                  // 处理错误
                  console.error(
                    "There was a problem with the fetch operation:",
                    error
                  );
                });
              }

            } else {
              console.error("API response is not successful:", data);
            }
          })
          .catch((error) => {
            console.error(
              "There was a problem with the fetch operation:",
              error
            );
          });
      });
      
      //总金额获取接口
      document.addEventListener("DOMContentLoaded", (event) => {
        const apiUrl =
          "http://localhost:8080/YunqiIceCity/shopcart/totalPrice";
        const headers = new Headers();
        headers.append("ngrok-skip-browser-warning", "abab");
        headers.append("Content-Type", "application/json");

        fetch(apiUrl, {
          method: "GET",
          // credentials: 'include',
          headers: headers,
        })
          .then((response) => {
            if (!response.ok) {
              throw new Error("Network response was not ok");
            }
            return response.json();
          })
          .then((data) => {
            // 检查响应状态码和消息，确保请求成功
            if (data.code === 1 && data.msg === "success") {
              // 提取 data 字段的值
              const totalPrice = data.data;
              // 将值设置到 money 类的 div 元素中
              document.querySelector(".money").textContent = totalPrice;
            } else {
              console.error("API response is not successful:", data);
            }
          })
          .catch((error) => {
            console.error(
              "There was a problem with the fetch operation:",
              error
            );
          });
      });